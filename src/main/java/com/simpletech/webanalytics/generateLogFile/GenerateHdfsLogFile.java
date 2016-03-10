package com.simpletech.webanalytics.generateLogFile;

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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.simpletech.webanalytics.generateLog
 * Created by ChenQi on 2016/1/15 10:32.
 */
public class GenerateHdfsLogFile {

    public void generatePointHdfsLogFile(ShareLinePoint point) throws IOException, ParseException {

        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(configuration);

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        Date date = point.getShareTime();
        String year=dateFormat.format(date);
        String path="/chenqi/shareLog/log-kv/"+year;

        LongWritable key = new LongWritable();
        Text value = new Text();

        SequenceFile.Writer writer = null;


        writer = SequenceFile.createWriter(fs, configuration, new Path(path),//按年存储
                key.getClass(), value.getClass(), SequenceFile.CompressionType.NONE);

        String logformat = JacksonUtil.toJson(point);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            String date1 = sdf.format(date);
            long timeStamp = sdf.parse(date1).getTime();

            key.set(timeStamp);
//            value.set(logs[random.nextInt(logs.length)]);
            value.set(logformat);
            writer.append(key, value);

        } finally {
            IOUtils.closeStream(writer);
        }

    }

    public void generateUserHdfsLogFile(ShareUser user) throws IOException, ParseException{

        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(configuration);

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        Date date = user.getCreateTime();
        String year=dateFormat.format(date);
        String path="/chenqi/userLog/log-kv/"+year;

        LongWritable key = new LongWritable();
        Text value = new Text();

        SequenceFile.Writer writer = null;


        writer = SequenceFile.createWriter(fs, configuration, new Path(path),//按年存储
                key.getClass(), value.getClass(), SequenceFile.CompressionType.NONE);

        String logformat = JacksonUtil.toJson(user);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            String date1 = sdf.format(date);
            long timeStamp = sdf.parse(date1).getTime();

            key.set(timeStamp);
//            value.set(logs[random.nextInt(logs.length)]);
            value.set(logformat);
            writer.append(key, value);

        } finally {
            IOUtils.closeStream(writer);
        }
    }
}
