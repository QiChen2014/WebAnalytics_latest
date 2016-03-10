package com.simpletech.webanalytics.dao;

import com.simpletech.webanalytics.mapper.WifiMapper;
import com.simpletech.webanalytics.model.Wifi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 数据库表t_action的Dao层测试类
 *
 * @author 树朾
 * @date 2015-09-21 17:03:53 中国标准时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class WIFIDaoTester {

    @Autowired
    WifiDao dao;

    @Autowired
    WifiMapper mapper;
    SimpleDateFormat monthf = new SimpleDateFormat("y-M-d HH:mm:ss");

    @Test
    public void count() throws Exception {
        int i = 36;
        while (i <= 92) {
            System.out.println("**************************i=" + i + "**************");
            dao.count("9c:99:a0:a5:cb:68", -(i), -(i + 1));
            i++;

        }

    }

    @Test
    public void count1() throws Exception {
        int i = 30;
        while (i <= 76) {
            System.out.println("**************************i=" + i + "**************");
            dao.count1("f4:8b:32:a2:44:cd", -(i), -(i + 1));
            i++;

        }

    }

    /**
     * 随机一分钟内随机的十秒钟
     *
     * @throws Exception
     */
    @Test
    public void count10() throws Exception {
        int i = 36;
        while (i <= 92) {
            System.out.println("**************************i=" + i + "**************");
            dao.count10seconds("9c:99:a0:a5:cb:68", -(i), -(i + 1));
            i++;

        }

    }

    /**
     * 随机一分钟内随机的十秒钟
     *
     * @throws Exception
     */
    @Test
    public void count11() throws Exception {
        int i = 30;
        while (i <= 76) {
            System.out.println("**************************i=" + i + "**************");
            dao.count11seconds("f4:8b:32:a2:44:cd", -(i), -(i + 1));
            i++;
        }

    }

    @Test
    public void onehundredCount() throws Exception {
        int i = 1;
        int j=1;
        System.out.println("40A5EF83CCB8");
        while (i <= 5) {
            System.out.println("40A5EF83CCB8*************i=" + i + "**************");
            dao.onehundredCount("40A5EF83CCB8", -42);
            i++;
        }
//        System.out.println("f4:8b:32:a2:44:cd");
//        while(j<=5){
//            System.out.println("f4:8b:32:a2:44:cd>>>>>>>>>j=" + j +" >>>>>>>>>>>>>>>>>>>>>");
//            dao.onehundredCount("f4:8b:32:a2:44:cd", -38);
//            j++;
//        }
    }

    @Test
    public void test() throws Exception {

        int i = mapper.count1("9c:99:a0:a5:cb:68", -36, -43);
        System.out.println("**************************i=" + i + "**************");
    }

    /**
     * 所有信号
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        int t=-18;
        int num=0;
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        while(t>= -70) {
            int i=dao.test2("40A5EF83CCB8", monthf.parse("2016-03-08 18:05:00"), monthf.parse("2016-03-08 18:15:59"), t);
            map.put(t, i);
            t--;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            num+=entry.getValue();
        }
        System.out.println("all total="+num);
        if(num>0){
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                System.out.println("sig="+entry.getKey()+"; num="+entry.getValue()+"; rate="+(1f*entry.getValue()/num)*100+"%");
            }
        }
    }

    /**
     * 店内
     * @throws Exception
     */
    @Test
    public void test2in() throws Exception {
        int t=-18;
        int num=0;
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        while(t>= -68) {
            int i=dao.test2in("40A5EF83CCB8", monthf.parse("2016-03-08 18:05:00"), monthf.parse("2016-03-08 18:15:59"), t);
            map.put(t, i);
            t--;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            num+=entry.getValue();
        }
        System.out.println("dian nei total="+num);
        if(num>0){
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                System.out.println("sig="+entry.getKey()+"; num="+entry.getValue()+"; rate="+(1f*entry.getValue()/num)*100+"%");
            }
        }
    }

    /**
     * 店外
     * @throws Exception
     */
    @Test
    public void test2out() throws Exception {
        int t=-44;
        int num=0;
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        while(t>= -70) {
            int i=dao.test2out("40A5EF83CCB8", monthf.parse("2016-03-08 18:05:00"), monthf.parse("2016-03-08 18:15:59"), t);
            map.put(t, i);
            t--;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            num+=entry.getValue();
        }
        System.out.println("dian wai total="+num);
        if(num>0){
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                System.out.println("sig="+entry.getKey()+"; num="+entry.getValue()+"; rate="+(1f*entry.getValue()/num)*100+"%");
            }
        }
    }

    /**
     * 店外
     * @throws Exception
     */
    @Test
    public void test2inout() throws Exception {
        int j=-16;
        int num=0;
        HashMap<Integer,Integer> mapin=new LinkedHashMap<>();
        HashMap<Integer,Integer> mapout=new LinkedHashMap<>();
        while(j>= -86) {
            System.out.println("**************************signal_Strength=" + j + "**************");
            int i=dao.test2out("40A5EF83CCB8", monthf.parse("2016-03-09 10:40:00"), monthf.parse("2016-03-09 11:10:59"), j);
            int p=dao.test2in("40A5EF83CCB8", monthf.parse("2016-03-09 10:40:00"), monthf.parse("2016-03-09 11:10:59"), j);
            mapout.put(j, i);
            mapin.put(j,p);
            num=i+p;
            if(num>0){
                System.out.println("sig="+j+"; in num="+p+"; rate="+(1f*p/num)*100+"%");
                System.out.println("sig="+j+"; out num="+i+"; rate="+(1f*i/num)*100+"%");
            }
            j-=2;
        }
    }
}
