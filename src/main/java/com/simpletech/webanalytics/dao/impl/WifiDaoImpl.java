package com.simpletech.webanalytics.dao.impl;

import com.wifiTools.RandomTime;
import com.simpletech.webanalytics.model.Wifi;
import com.simpletech.webanalytics.mapper.WifiMapper;
import com.simpletech.webanalytics.dao.WifiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 数据库表t_url的Dao实现
 *
 * @author 树朾
 * @date 2015-09-21 17:03:53 中国标准时间
 */
@Repository
public class WifiDaoImpl implements WifiDao {

    @Autowired
    WifiMapper mapper;

    @Override
    public void count(String mac,int sig1,int sig2) {

        int num=0;
        int i1 = mapper.count1(mac, sig1, sig2);
        int i2 = mapper.count2(mac, sig1, sig2);
        int i3 = mapper.count3(mac, sig1, sig2);
        int i4 = mapper.count4(mac, sig1, sig2);
        int i5 = mapper.count5(mac, sig1, sig2);
        int i6 = mapper.count6(mac, sig1, sig2);
        int[] ints={i1,i2,i3,i4,i5,i6};
        for(int j=0;j<ints.length;j++){
            num+=ints[j];
        }
            if(num!=0){
                System.out.println("BETWEEN '2016-03-04 10:25:00' AND '2016-03-04 10:35:59' "+i1+" rate="+1f*ints[0]/num*100+"%"+" range:-62,-36");
                System.out.println("BETWEEN '2016-03-04 10:40:00' AND '2016-03-04 10:50:59' "+i2+" rate="+1f*ints[1]/num*100+"%"+" range:-68,-48");
                System.out.println("BETWEEN '2016-03-04 11:00:00' AND '2016-03-04 11:10:59' "+i3+" rate="+1f*ints[2]/num*100+"%"+" range:-72,-46");
                System.out.println("BETWEEN '2016-03-04 11:20:00' AND '2016-03-04 11:30:59' "+i4+" rate="+1f*ints[3]/num*100+"%"+" range:-86,-44");
                System.out.println("BETWEEN '2016-03-04 11:35:00' AND '2016-03-04 11:45:59' "+i5+" rate="+1f*ints[4]/num*100+"%"+" range:-92,-48");
                System.out.println("BETWEEN '2016-03-04 11:50:00' AND '2016-03-04 12:00:59' "+i6+" rate="+1f*ints[5]/num*100+"%"+" range:-88,-58");
            }else {
                System.out.println("BETWEEN '2016-03-04 10:25:00' AND '2016-03-04 10:35:59' "+i1+" rate=null");
                System.out.println("BETWEEN '2016-03-04 10:40:00' AND '2016-03-04 10:50:59' "+i2+" rate=null");
                System.out.println("BETWEEN '2016-03-04 11:00:00' AND '2016-03-04 11:10:59' "+i3+" rate=null");
                System.out.println("BETWEEN '2016-03-04 11:20:00' AND '2016-03-04 11:30:59' "+i4+" rate=null");
                System.out.println("BETWEEN '2016-03-04 11:35:00' AND '2016-03-04 11:45:59' "+i5+" rate=null");
                System.out.println("BETWEEN '2016-03-04 11:50:00' AND '2016-03-04 12:00:59' "+i6+" rate=null");

            }

    }

    @Override
    public void count1(String mac,int sig1,int sig2) {

        int num=0;
        int i1 = mapper.count1(mac, sig1, sig2);
        int i2 = mapper.count2(mac, sig1, sig2);
        int i3 = mapper.count3(mac, sig1, sig2);
        int i4 = mapper.count4(mac, sig1, sig2);
        int i5 = mapper.count5(mac, sig1, sig2);
        int i6 = mapper.count6(mac, sig1, sig2);
        int[] ints={i1,i2,i3,i4,i5,i6};
        for(int j=0;j<ints.length;j++){
            num+=ints[j];
        }
        if(num!=0){
            System.out.println("BETWEEN '2016-03-04 10:25:00' AND '2016-03-04 10:35:59' "+i1+" rate="+1f*ints[0]/num*100+"%"+" range:-62,-30");
            System.out.println("BETWEEN '2016-03-04 10:40:00' AND '2016-03-04 10:50:59' "+i2+" rate="+1f*ints[1]/num*100+"%"+" range:-70,-46");
            System.out.println("BETWEEN '2016-03-04 11:00:00' AND '2016-03-04 11:10:59' "+i3+" rate="+1f*ints[2]/num*100+"%"+" range:-76,-46");
            System.out.println("BETWEEN '2016-03-04 11:20:00' AND '2016-03-04 11:30:59' "+i4+" rate="+1f*ints[3]/num*100+"%"+" range:-62,-40");
            System.out.println("BETWEEN '2016-03-04 11:35:00' AND '2016-03-04 11:45:59' "+i5+" rate="+1f*ints[4]/num*100+"%"+" range:-64,-56");
            System.out.println("BETWEEN '2016-03-04 11:50:00' AND '2016-03-04 12:00:59' "+i6+" rate="+1f*ints[5]/num*100+"%"+" range:null,null");
        }else {
            System.out.println("BETWEEN '2016-03-04 10:25:00' AND '2016-03-04 10:35:59' "+i1+" rate=null");
            System.out.println("BETWEEN '2016-03-04 10:40:00' AND '2016-03-04 10:50:59' "+i2+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:00:00' AND '2016-03-04 11:10:59' "+i3+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:20:00' AND '2016-03-04 11:30:59' "+i4+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:35:00' AND '2016-03-04 11:45:59' "+i5+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:50:00' AND '2016-03-04 12:00:59' "+i6+" rate=null");

        }

    }

    /**
     *
     * @param mac 9c:99:a0:a5:cb:68
     * @param sig1 -36
     * @param sig2 -92
     * @throws ParseException
     */
    @Override
    public void count10seconds(String mac,int sig1, int sig2) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        List<Integer> list1=new ArrayList<>();
//        List<Integer> list2=new ArrayList<>();
//        list1.add(10);
//        list1.add(20);
//        list1.add(30);
//        list1.add(40);
//        list1.add(50);

        //随机选取分钟
        int rand1m= (int)(25+Math.random()*(35-25+1));
        int rand2m= (int)(40+Math.random()*(50-40+1));
        int rand3m= (int)(0+Math.random()*(10-0+1));
        int rand4m= (int)(20+Math.random()*(30-20+1));
        int rand5m= (int)(35+Math.random()*(45-35+1));
        int rand6m= (int)(50+Math.random()*(60-51+1));
        //随机取十秒
        int rand10s= (int)(10+Math.random()*(59-10+1));
//        Collections.shuffle(list1);
//        int closure=list1.get(0);
        int closure=rand10s;
        int begin=closure-10;

        Date start1=sdf.parse("2016-03-04 10:"+rand1m+":"+begin);
        Date end1=sdf.parse("2016-03-04 10:"+rand1m+":"+closure);

        Date start2=sdf.parse("2016-03-04 10:"+rand2m+":"+begin);
        Date end2=sdf.parse("2016-03-04 10:"+rand2m+":"+closure);

        Date start3=sdf.parse("2016-03-04 11:"+rand3m+":"+begin);
        Date end3=sdf.parse("2016-03-04 11:"+rand3m+":"+closure);

        Date start4=sdf.parse("2016-03-04 11:"+rand4m+":"+begin);
        Date end4=sdf.parse("2016-03-04 11:"+rand4m+":"+closure);

        Date start5=sdf.parse("2016-03-04 11:"+rand5m+":"+begin);
        Date end5=sdf.parse("2016-03-04 11:"+rand5m+":"+closure);

        Date start6=sdf.parse("2016-03-04 11:"+rand6m+":"+begin);
        Date end6=sdf.parse("2016-03-04 11:"+rand6m+":"+closure);

        int num=0;
        int i1 = mapper.count10seconds(mac,start1,end1, sig1, sig2);
        int i2 = mapper.count20seconds(mac,start2,end2, sig1, sig2);
        int i3 = mapper.count30seconds(mac,start3,end3, sig1, sig2);
        int i4 = mapper.count40seconds(mac,start4,end4, sig1, sig2);
        int i5 = mapper.count50seconds(mac,start5,end5, sig1, sig2);
        int i6 = mapper.count60seconds(mac,start6,end6, sig1, sig2);
        int[] ints={i1,i2,i3,i4,i5,i6};
        for(int j=0;j<ints.length;j++){
            num+=ints[j];
        }
        if(num!=0){
            System.out.println("BETWEEN '2016-03-04 10:"+rand1m+":"+begin+"' AND '2016-03-04 10:"+rand1m+":"+closure+"' "+i1+" rate="+1f*ints[0]/num*100+"%"+" range:-62,-36");
            System.out.println("BETWEEN '2016-03-04 10:"+rand2m+":"+begin+"' AND '2016-03-04 10:"+rand2m+":"+closure+"' "+i2+" rate="+1f*ints[1]/num*100+"%"+" range:-68,-48");
            System.out.println("BETWEEN '2016-03-04 11:"+rand3m+":"+begin+"' AND '2016-03-04 11:"+rand3m+":"+closure+"' "+i3+" rate="+1f*ints[2]/num*100+"%"+" range:-72,-46");
            System.out.println("BETWEEN '2016-03-04 11:"+rand4m+":"+begin+"' AND '2016-03-04 11:"+rand4m+":"+closure+"' "+i4+" rate="+1f*ints[3]/num*100+"%"+" range:-92,-48");
            System.out.println("BETWEEN '2016-03-04 11:"+rand5m+":"+begin+"' AND '2016-03-04 11:"+rand5m+":"+closure+"' "+i5+" rate="+1f*ints[4]/num*100+"%"+" range:-86,-44");
            System.out.println("BETWEEN '2016-03-04 11:"+rand6m+":"+begin+"' AND '2016-03-04 11:"+rand6m+":"+closure+"' "+i6+" rate="+1f*ints[5]/num*100+"%"+" range:-88,-58");
        }else {
            System.out.println("BETWEEN '2016-03-04 10:"+rand1m+":"+begin+"' AND '2016-03-04 10:"+rand1m+":"+closure+"' "+i1+" rate=null");
            System.out.println("BETWEEN '2016-03-04 10:"+rand2m+":"+begin+"' AND '2016-03-04 10:"+rand2m+":"+closure+"' "+i2+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:"+rand3m+":"+begin+"' AND '2016-03-04 11:"+rand3m+":"+closure+"' "+i3+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:"+rand4m+":"+begin+"' AND '2016-03-04 11:"+rand4m+":"+closure+"' "+i4+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:"+rand5m+":"+begin+"' AND '2016-03-04 11:"+rand5m+":"+closure+"' "+i5+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:"+rand6m+":"+begin+"' AND '2016-03-04 11:"+rand6m+":"+closure+"' "+i6+" rate=null");

        }
//        System.out.println("BETWEEN '2016-03-04 10:25:"+begin+"' AND '2016-03-04 10:35:'"+closure+" "+i1);
    }

    /**
     *
     * @param mac f4:8b:32:a2:44:cd
     * @param sig1 -30
     * @param sig2 -76
     * @throws ParseException
     */
    @Override
    public void count11seconds(String mac,int sig1, int sig2) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        List<Integer> list1=new ArrayList<>();
//        List<Integer> list2=new ArrayList<>();
//        list1.add(10);
//        list1.add(20);
//        list1.add(30);
//        list1.add(40);
//        list1.add(50);

        //随机选取分钟
        int rand1m= (int)(25+Math.random()*(35-25+1));
        int rand2m= (int)(40+Math.random()*(50-40+1));
        int rand3m= (int)(0+Math.random()*(10-0+1));
        int rand4m= (int)(20+Math.random()*(30-20+1));
        int rand5m= (int)(35+Math.random()*(45-35+1));
        int rand6m= (int)(50+Math.random()*(60-51+1));
        //随机取十秒
        int rand10s= (int)(10+Math.random()*(59-10+1));
//        Collections.shuffle(list1);
//        int closure=list1.get(0);
        int closure=rand10s;
        int begin=closure-10;

        Date start1=sdf.parse("2016-03-04 10:"+rand1m+":"+begin);
        Date end1=sdf.parse("2016-03-04 10:"+rand1m+":"+closure);

        Date start2=sdf.parse("2016-03-04 10:"+rand2m+":"+begin);
        Date end2=sdf.parse("2016-03-04 10:"+rand2m+":"+closure);

        Date start3=sdf.parse("2016-03-04 11:"+rand3m+":"+begin);
        Date end3=sdf.parse("2016-03-04 11:"+rand3m+":"+closure);

        Date start4=sdf.parse("2016-03-04 11:"+rand4m+":"+begin);
        Date end4=sdf.parse("2016-03-04 11:"+rand4m+":"+closure);

        Date start5=sdf.parse("2016-03-04 11:"+rand5m+":"+begin);
        Date end5=sdf.parse("2016-03-04 11:"+rand5m+":"+closure);

        Date start6=sdf.parse("2016-03-04 11:"+rand6m+":"+begin);
        Date end6=sdf.parse("2016-03-04 11:"+rand6m+":"+closure);

        int num=0;
        int i1 = mapper.count10seconds(mac,start1,end1, sig1, sig2);
        int i2 = mapper.count20seconds(mac,start2,end2, sig1, sig2);
        int i3 = mapper.count30seconds(mac,start3,end3, sig1, sig2);
        int i4 = mapper.count40seconds(mac,start4,end4, sig1, sig2);
        int i5 = mapper.count50seconds(mac,start5,end5, sig1, sig2);
        int i6 = mapper.count60seconds(mac,start6,end6, sig1, sig2);
        int[] ints={i1,i2,i3,i4,i5,i6};
        for(int j=0;j<ints.length;j++){
            num+=ints[j];
        }
        if(num!=0){
            System.out.println("BETWEEN '2016-03-04 10:"+rand1m+":"+begin+"' AND '2016-03-04 10:"+rand1m+":"+closure+"' "+i1+" rate="+1f*ints[0]/num*100+"%"+" range:-62,-30");
            System.out.println("BETWEEN '2016-03-04 10:"+rand2m+":"+begin+"' AND '2016-03-04 10:"+rand2m+":"+closure+"' "+i2+" rate="+1f*ints[1]/num*100+"%"+" range:-70,-46");
            System.out.println("BETWEEN '2016-03-04 11:"+rand3m+":"+begin+"' AND '2016-03-04 11:"+rand3m+":"+closure+"' "+i3+" rate="+1f*ints[2]/num*100+"%"+" range:-76,-46");
            System.out.println("BETWEEN '2016-03-04 11:"+rand4m+":"+begin+"' AND '2016-03-04 11:"+rand4m+":"+closure+"' "+i4+" rate="+1f*ints[3]/num*100+"%"+" range:-62,-40");
            System.out.println("BETWEEN '2016-03-04 11:"+rand5m+":"+begin+"' AND '2016-03-04 11:"+rand5m+":"+closure+"' "+i5+" rate="+1f*ints[4]/num*100+"%"+" range:-64,-56");
            System.out.println("BETWEEN '2016-03-04 11:"+rand6m+":"+begin+"' AND '2016-03-04 11:"+rand6m+":"+closure+"' "+i6+" rate="+1f*ints[5]/num*100+"%"+" range:null,null");
        }else {
            System.out.println("BETWEEN '2016-03-04 10:"+rand1m+":"+begin+"' AND '2016-03-04 10:"+rand1m+":"+closure+"' "+i1+" rate=null");
            System.out.println("BETWEEN '2016-03-04 10:"+rand2m+":"+begin+"' AND '2016-03-04 10:"+rand2m+":"+closure+"' "+i2+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:"+rand3m+":"+begin+"' AND '2016-03-04 11:"+rand3m+":"+closure+"' "+i3+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:"+rand4m+":"+begin+"' AND '2016-03-04 11:"+rand4m+":"+closure+"' "+i4+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:"+rand5m+":"+begin+"' AND '2016-03-04 11:"+rand5m+":"+closure+"' "+i5+" rate=null");
            System.out.println("BETWEEN '2016-03-04 11:"+rand6m+":"+begin+"' AND '2016-03-04 11:"+rand6m+":"+closure+"' "+i6+" rate=null");

        }
//        System.out.println("BETWEEN '2016-03-04 10:25:"+begin+"' AND '2016-03-04 10:35:'"+closure+" "+i1);
    }

    @Override
    public void realCount(String tableName, String mac, Date start, Date end, int sig1,int sig2){

    }

    /**
     * 100%的信号
     * @param mac
     * @param sig
     */
    @Override
    public void onehundredCount(String mac,  int sig){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date time= RandomTime.randomDate("2016-03-09 10:40:00","2016-03-09 11:10:59");
        System.out.println(time);
        String time1=sdf1.format(time);
//        //随机选取分钟
//        int rand1m= (int)(25+Math.random()*(35-25+1));
        //随机取十秒
        int rand10s= (int)(10+Math.random()*(59-10+1));
        int closure=rand10s;
        int begin=closure-10;

        String t1=time1+":"+begin;
        String t2=time1+":"+closure;
        try {
            Date start=sdf.parse(t1);
            Date end=sdf.parse(t2);
            System.out.println("between "+t1+" and "+t2);
            List<Wifi> list= mapper.onehundredCount(mac,start,end,sig);
            if(list.size()>0){
                for (Wifi wifi:list) {
                    System.out.println("rss= " + wifi.getRss() + ";   num= " + wifi.getNum());
                }
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    /**
     * 区间统计
     * @param mac
     * @param sig1
     * @param sig2
     */
    @Override
    public void rangeCount(String mac,int sig1,int sig2){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date time=RandomTime.randomDate("2016-03-04 10:25:00","2016-03-04 10:35:59");
        System.out.println(time);
        String time1=sdf1.format(time);
//        //随机选取分钟
//        int rand1m= (int)(25+Math.random()*(35-25+1));
        //随机取十秒
        int rand10s= (int)(10+Math.random()*(59-10+1));
        int closure=rand10s;
        int begin=closure-10;

        String t1=time1+":"+begin;
        String t2=time1+":"+closure;
        try {
            Date start=sdf.parse(t1);
            Date end=sdf.parse(t2);
            System.out.println("between "+t1+" and "+t2);
            List<Wifi> list= mapper.rangeCount(mac, start, end, sig1, sig2);
            if(list.size()>0){
                for (Wifi wifi:list) {
                    System.out.println("rss= " + wifi.getRss() + ";   num= " + wifi.getNum());
                }
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    @Override
    public int test2(String idwifi,Date start,Date end,int sig){
       int i= mapper.test2(idwifi,start,end,sig);
        return i;
    }

    @Override
    public int test2in(String idwifi,Date start,Date end,int sig){
        int i= mapper.test2in(idwifi,start,end,sig);
        return i;
    }

    @Override
    public int test2out(String idwifi,Date start,Date end,int sig){
        int i= mapper.test2out(idwifi,start,end,sig);
        return i;
    }
}

