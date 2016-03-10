package com.simpletech.webanalytics.dao.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simpletech.webanalytics.dao.ShareInfoDao;
import com.simpletech.webanalytics.mapper.ShareLinePointMapper;
import com.simpletech.webanalytics.mapper.ShareUserMapper;
import com.simpletech.webanalytics.model.ShareLinePoint;
import com.simpletech.webanalytics.model.ShareUser;
import com.simpletech.webanalytics.util.JacksonUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 从数据库表t_share_line_point和t_share_user中读取数据构造原始Log文件
 * @author 树朾
 * @date 2015-10-20 14:49:10 中国标准时间
 */
@Repository
public class ShareInfoDaoImpl implements ShareInfoDao{
    @Autowired
    ShareLinePointMapper linePointMapper;
    @Autowired
    ShareUserMapper userMapper;

    public List<ShareLinePoint> getShareInfo(){
        List<ShareLinePoint> shareLinePoints=linePointMapper.findAll("order by share_time");

        return shareLinePoints;
    }

    public List<ShareUser> getShareUser(){
        List<ShareUser> shareUsers=userMapper.findAll("order by create_time");
        return shareUsers;
    }

    @Override
    public void generatePointLogFile(String path) throws FileNotFoundException,JsonProcessingException,ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        File writer=new File(path);
        List<ShareLinePoint> shareInfos=getShareInfo();
//        List<String> infos=new ArrayList<>();
        for(ShareLinePoint share:shareInfos){
            ObjectMapper mapper=new ObjectMapper();
            String json=mapper.writeValueAsString(share);
            Date date=share.getShareTime();
            String date1=sdf.format(date);
            String jsonInfo=sdf.parse(date1).getTime()+" "+json;
            System.out.println(jsonInfo);
            try {
                FileWriter fw=new FileWriter(writer,true);
                BufferedWriter bw=new BufferedWriter(fw);
                bw.write(jsonInfo);
                bw.newLine();
                bw.flush();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
//            infos.add(jsonInfo);
        }

    }
    @Override
    public void generateUserLogFile(String path) throws FileNotFoundException,JsonProcessingException,ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        File writer=new File(path);
        List<ShareUser> shareUsers=getShareUser();
//        List<String> infos=new ArrayList<>();
        for(ShareUser shareUser:shareUsers){
            ObjectMapper mapper=new ObjectMapper();
            String json=mapper.writeValueAsString(shareUser);
            Date date=shareUser.getCreateTime();
            String date1=sdf.format(date);
            String jsonInfo=sdf.parse(date1).getTime()+" "+json;
            System.out.println(jsonInfo);
            try {
                FileWriter fw=new FileWriter(writer,true);
                BufferedWriter bw=new BufferedWriter(fw);
                bw.write(jsonInfo);
                bw.newLine();
                bw.flush();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
//            infos.add(jsonInfo);
        }

    }
    @Override
    public void generatePointHdfsLogFile() throws IOException, ParseException {
        List<ShareLinePoint> points=getShareInfo();
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(configuration);

        LongWritable key = new LongWritable();
        Text value = new Text();

        SequenceFile.Writer writer = null;


        writer = SequenceFile.createWriter(fs, configuration, new Path("/chenqi/shareLog/log-kv"),//按年存储
                key.getClass(), value.getClass(), SequenceFile.CompressionType.NONE);
        try {
        for(ShareLinePoint point:points){
            String logformat = JacksonUtil.toJson(point);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = point.getShareTime();
                String date1 = sdf.format(date);
                long timeStamp = sdf.parse(date1).getTime();

                key.set(timeStamp);
//            value.set(logs[random.nextInt(logs.length)]);
                value.set(logformat);
                writer.append(key, value);

            }
        }finally {
            IOUtils.closeStream(writer);
        }
    }
    @Override
    public void generateUserHdfsLogFile() throws IOException, ParseException{
        List<ShareUser> users=getShareUser();
//        System.out.println(users.size());
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(configuration);

        LongWritable key = new LongWritable();
        Text value = new Text();

        SequenceFile.Writer writer = null;


        writer = SequenceFile.createWriter(fs, configuration, new Path("/chenqi/userLog/log-kv"),
                key.getClass(), value.getClass(), SequenceFile.CompressionType.NONE);
        try {
        for(ShareUser user:users){
            String logformat = JacksonUtil.toJson(user);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                Date date = user.getCreateTime();
                String date1 = sdf.format(date);
                long timeStamp = sdf.parse(date1).getTime();
//                System.out.println(timeStamp+" "+logformat);
                key.set(timeStamp);
//            value.set(logs[random.nextInt(logs.length)]);
                value.set(logformat);
                writer.append(key, value);

            }
        }finally {
            IOUtils.closeStream(writer);
        }

    }
}
