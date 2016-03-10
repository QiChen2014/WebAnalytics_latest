package com.simpletech.webanalytics.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.simpletech.webanalytics.model.ShareLinePoint;
import com.simpletech.webanalytics.model.ShareUser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


/**
 * 从数据库表t_share_line_point和t_share_user中读取数据构造原始Log文件
 * @author 树朾
 * @date 2015-10-20 14:49:10 中国标准时间
 */
public interface ShareInfoDao{
	void generatePointLogFile(String path) throws FileNotFoundException,JsonProcessingException,ParseException;
	void generateUserLogFile(String path) throws FileNotFoundException,JsonProcessingException,ParseException;
	void generatePointHdfsLogFile() throws IOException, ParseException;
	void generateUserHdfsLogFile() throws IOException, ParseException;
}
