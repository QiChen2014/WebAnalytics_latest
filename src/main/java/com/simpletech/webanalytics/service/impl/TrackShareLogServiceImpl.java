package com.simpletech.webanalytics.service.impl;

import com.simpletech.webanalytics.generateLogFile.GenerateHdfsLogFile;
import com.simpletech.webanalytics.model.ShareLinePoint;
import com.simpletech.webanalytics.model.ShareUser;
import com.simpletech.webanalytics.model.Title;
import com.simpletech.webanalytics.model.Url;
import com.simpletech.webanalytics.model.entity.JsDetect;
import com.simpletech.webanalytics.service.TrackShareLogService;
import com.simpletech.webanalytics.util.AfReflecter;
import com.simpletech.webanalytics.util.AfStringUtil;
import com.simpletech.webanalytics.util.JacksonUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.Date;

/**
 * JS探针 接收服务
 * Created by 树朾 on 2015/9/22.
 */
@Service
public class TrackShareLogServiceImpl implements TrackShareLogService {

    @Override
    public void trackerShareLog(int siteId, String idsubsite, JsDetect detect, Url url, Title title){
        GenerateHdfsLogFile ghlf=new GenerateHdfsLogFile();

        if (AfStringUtil.isNotEmpty(detect.getFromvid()) && detect.getFromvts() > 0) {
            String idVisitor = detect.getIdvtor();
            String idFromtor = detect.getFromvid();
            if (!idVisitor.equals(idFromtor)) {
                //对每一条记录进行实例化
                ShareLinePoint point= new ShareLinePoint();
                point.setIdsite(siteId);
                point.setIdrefervisitor(idFromtor);
                point.setIdvisitor(idVisitor);//创建上一个分享点
                point.setShareTo(detect.getShareto());
//                point.setIsStartPoint(mapper.isStartPoint(siteId, url.getId(), idFromtor));
                point.fillNullID();
                point.setIdsubsite(idsubsite);
                point.setIdurl(url.getId());
                point.setIdtitle(title.getId());
                point.setShareTime(new Date());
                point.setShareSpan(Math.abs(new Date().getTime() - detect.getFromvts()));
                point.setCountPv(1);
                AfReflecter.setMemberNoException(point, "createTime", new Date());
                AfReflecter.setMemberNoException(point, "updateTime", new Date());
                //写入HDFS中
                try {
                    ghlf.generatePointHdfsLogFile(point);
                }catch (IOException e){
                    e.printStackTrace();
                }catch (ParseException e1){
                    e1.printStackTrace();
                }

            }
        }
    }

    @Override
    public void trackerShareUser(int siteId, ShareUser user){
        GenerateHdfsLogFile ghlf=new GenerateHdfsLogFile();

        user.setIdsite(siteId);

        //写入HDFS中
        try {
            ghlf.generateUserHdfsLogFile(user);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e1){
            e1.printStackTrace();
        }
    }

    /**
     * 检测非空字段
     *
     * @param old   老数据
     * @param model 新数据model
     */
    @SuppressWarnings("unchecked")
    protected <T> T checkNullField(T old, T model) {
        try {
            Class<?> clazz = old.getClass();
            old = (T) JacksonUtil.toObject(JacksonUtil.toJson(old), clazz);
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Object nfield = field.get(model);
                if (nfield != null) {
                    field.set(old, nfield);
                }
            }
        } catch (Exception e) {

        }
        return old;
    }
}
