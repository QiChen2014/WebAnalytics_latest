package com.simpletech.webanalytics.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.simpletech.webanalytics.dao.ShareUserDao;
import com.simpletech.webanalytics.dao.TrackShareDao;
import com.simpletech.webanalytics.generateLogFile.GenerateLogFile;
import com.simpletech.webanalytics.mapper.ShareLinePointMapper;
import com.simpletech.webanalytics.mapper.api.TrackShareMapper;
import com.simpletech.webanalytics.model.ShareLinePoint;
import com.simpletech.webanalytics.model.ShareUser;
import com.simpletech.webanalytics.model.Title;
import com.simpletech.webanalytics.model.Url;
import com.simpletech.webanalytics.model.entity.JsDetect;
import com.simpletech.webanalytics.service.TrackShareService;
import com.simpletech.webanalytics.util.AfReflecter;
import com.simpletech.webanalytics.util.AfStringUtil;
import com.simpletech.webanalytics.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * JS探针 接收服务
 * Created by 树朾 on 2015/9/22.
 */
@Service
public class TrackShareServiceImpl implements TrackShareService {

    @Autowired
    TrackShareDao dao;

    @Autowired
    TrackShareMapper mapper;

    @Autowired
    ShareUserDao shareUserDao;

    @Autowired
    ShareLinePointMapper linePointMapper;

    @Override
    public void trackerShare(int siteId, String idsubsite, JsDetect detect, Url url, Title title) {

        if (AfStringUtil.isNotEmpty(detect.getFromvid()) && detect.getFromvts() > 0) {
            String idVisitor = detect.getIdvtor();
            String idFromtor = detect.getFromvid();
            if (!idVisitor.equals(idFromtor)) {
//                ShareUser formtor = dao.getShareUser(siteId, idsubsite, idVisitor, detect);
                //获取上一个点（不存在则添加）
//                ShareLinePoint lpoint = dao.getShareLinePoint(siteId, idsubsite, url.getId(), idFromtor, detect.getFromvts());
                //判断并产生起始点
//                dao.makeSureStartPoint(siteId, idsubsite, url.getId(), idFromtor);
                //获取本次分享点
                ShareLinePoint tpoint = dao.getShareLinePoint(siteId, idsubsite, url.getId(), idFromtor, idVisitor);

                //若数据库中无记录则插入数据
                if (tpoint == null) {
                    //忽略反向线
                    if (dao.getShareLinePoint(siteId, idsubsite, url.getId(), idVisitor, idFromtor) == null) {
                        tpoint = new ShareLinePoint();
                        tpoint.setIdsite(siteId);
                        tpoint.setIdrefervisitor(idFromtor);
                        tpoint.setIdvisitor(idVisitor);//创建上一个分享点
                        tpoint.setShareTo(detect.getShareto());
                        tpoint.setIsStartPoint(mapper.isStartPoint(siteId, url.getId(), idFromtor));
                        tpoint.fillNullID();
                        tpoint.setIdsubsite(idsubsite);
                        tpoint.setIdurl(url.getId());
                        tpoint.setIdtitle(title.getId());
                        tpoint.setShareTime(new Date());
                        tpoint.setShareSpan(Math.abs(new Date().getTime() - detect.getFromvts()));
                        tpoint.setCountPv(1);
                        AfReflecter.setMemberNoException(tpoint, "createTime", new Date());
                        AfReflecter.setMemberNoException(tpoint, "updateTime", new Date());
//                        dao.insertShareLinePoint(tpoint);
                        linePointMapper.insert(tpoint);

                    }
                } else {
                    tpoint.setCountPv(1 + tpoint.getCountPv());
//                    dao.updateShareLinePoint(tpoint);
                    linePointMapper.update(tpoint);

                }

            }
        }
    }

    @Override
    public void addOrUpdateUser(int siteId, ShareUser user) {

        ShareUser old = dao.getShareUser(user.getIdsite(), user.getIdvisitor());
        if (old == null) {
            user.setIdsite(siteId);
//            dao.insertShareUser(user);
            shareUserDao.insert(user);

        } else {
//            dao.updateShareUser(checkNullField(old, user));
            shareUserDao.update(checkNullField(old, user));

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
