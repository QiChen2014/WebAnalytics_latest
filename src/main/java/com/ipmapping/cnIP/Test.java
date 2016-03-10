package com.ipmapping.cnIP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * WebAnalytics
 * Created by ChenQi on 2015/12/10 17:17.
 */
public class Test {
    public static void main(String []args)throws ParseException{
//        RandomIP rdIP=new RandomIP();
//        String ip=rdIP.getRandomIp();
        IPCalculate ipCalculate=new IPCalculate();
        long num=ipCalculate.validateIP("210.0.0.0");

//        String str=ip+"\t"+num;
//        File writer=new File("E:\\ipCompare.txt");
//        try {
//            FileWriter fw=new FileWriter(writer,true);
//            BufferedWriter bw=new BufferedWriter(fw);
//            bw.write(str);
//            bw.newLine();
//            bw.flush();
//            bw.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        SimpleDateFormat loadformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        final Date begin = loadformat.parse("2015-12-01 00:00:00");//开始位置
        final Date closure = new Date(begin.getTime() + 10 * 60 * 1000);//结束位置
        System.out.println(begin.getTime()+"--"+closure.getTime());
    }
}
