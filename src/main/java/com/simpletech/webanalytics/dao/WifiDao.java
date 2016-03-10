package com.simpletech.webanalytics.dao;

import java.text.ParseException;
import java.util.Date;

/**
 * 数据库表t_action的Dao接口
 * @author 树朾
 * @date 2015-10-12 15:00:31 中国标准时间
 */

public interface WifiDao{
	/*
	* 统计每个信号的概率*/
	void count(String mac,int sig1,int sig2);
	void count1(String mac,int sig1,int sig2);
	/*
	* 统计10秒的信号
	**/
	void count10seconds(String mac,int sig1,int sig2) throws ParseException;
	void count11seconds(String mac,int sig1,int sig2) throws ParseException;
	/*
	* 统计真实店铺的传播情况
	* */
	void realCount(String tableName, String mac, Date start, Date end, int sig1,int sig2);
	/*
	* 100%入店的信号个数*/
	void onehundredCount(String mac, int sig);
	/*
	* 在某个区间段的信号个数
	* */
	void rangeCount(String mac, int sig1,int sig2);

	int test2(String idWifi, Date start, Date end, int sig);

	int test2in(String idWifi, Date start, Date end, int sig);

	int test2out(String idWifi, Date start, Date end, int sig);
}
