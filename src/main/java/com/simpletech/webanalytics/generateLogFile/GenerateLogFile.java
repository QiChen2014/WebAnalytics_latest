package com.simpletech.webanalytics.generateLogFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simpletech.webanalytics.model.ShareLinePoint;
import com.simpletech.webanalytics.model.ShareUser;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * com.simpletech.webanalytics.generateLog
 * Created by ChenQi on 2016/1/15 10:32.
 */
public class GenerateLogFile {
    public void generatePointLogFile(String path,List<ShareLinePoint> shareLinePoints) throws FileNotFoundException,JsonProcessingException,ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        File writer=new File(path);

//        List<String> infos=new ArrayList<>();
        for(ShareLinePoint share:shareLinePoints){
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

    public void generateUserLogFile(String path,List<ShareUser> shareUsers) throws FileNotFoundException,JsonProcessingException,ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        File writer=new File(path);

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

    public void shareLinePoint2HdfsLog(){

    }
}
