package com.simpletech.webanalytics.ispprocess;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simpletech.webanalytics.model.entity.ErrorValue;
import com.simpletech.webanalytics.model.entity.IspValue;
import com.simpletech.webanalytics.model.entity.Result;
import com.simpletech.webanalytics.util.JacksonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 * Created by ChenQi on 2015/12/28 11:23.
 */
public class TestLoad {
    public static void main(String []args) throws Exception{
//        String addr = "210.40.2.236";
////        IPLoad load=new IPLoad();
//        ISPParse ispParse=new ISPParse();
//        String isp=IspParser.ispParser(addr);
//        System.out.println(isp);
//        try {
//            List<IPModel> listIP=load.fileLoad();
//
//            System.out.println("写入中……");
//            //写入文件
//            load.write(listIP);
//            System.out.println("处理完成");
//        }catch (FileNotFoundException e){
//            System.err.println("文件不存在");
//        }
        List<IspValue> ispValues=new ArrayList<>();
        for(int i=0;i<5;i++){
            IspValue ispValue=new IspValue();
            ispValue.setName("dianxin");
            ispValue.setNum(10);
            ispValue.setRate((float) 0.2);
            ispValues.add(ispValue);
        }
        List<ErrorValue> errorValues=new ArrayList<>();
        for(int i=0;i<5;i++){
            ErrorValue error=new ErrorValue();
            error.setIp("1212");
            error.setName("dsds");
            error.setRemark("sdsds");
            error.setUerAgent("useragent");
            errorValues.add(error);
        }
        Result result=new Result();
        result.setId("dsdsdsd");
        result.setIspValue(ispValues);
        result.setErrorValue(errorValues);
        result.setPv(112);
        result.setUv(23);
        String ss= JacksonUtil.toJson(result);
        ObjectMapper mapper=new ObjectMapper();
        Result result1=mapper.readValue(ss, Result.class);
        System.out.println(ss);
        System.out.println(result1);
//        try {
//            ispParse.ispParser(addr);
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }

    }
}
