package com.simpletech.webanalytics.service;

import java.util.List;

import com.simpletech.webanalytics.model.IpLocation;
import com.simpletech.webanalytics.service.base.BaseService;

/**
 * 数据库表t_ip_location的Service接口层
 * @author 树朾
 * @date 2015-10-16 10:38:40 中国标准时间
 */
public interface IpLocationService extends BaseService<IpLocation> {

	/**
	 * 插入一条新数据
	 * @param model 添加的数据
	 * @return 改变行数
	 */
	int insert(IpLocation model);
	/**
	 * 根据ID删除
	 * @param id 主键ID
	 */
	int delete(Object id);
	/**
	 * 更新一条数据
	 * @param model 需要更新数据
	 * @return 改变行数
	 */
	int update(IpLocation model);
	/**
	 * 统计全部出数据
	 * @return 全部数据量
	 */
	int countAll();
	/**
	 * 根据ID获取
	 * @param id 主键ID
	 * @return 数据对象 or null
	 */
	IpLocation findById(Object id);
	/**
	 * 获取全部数据
	 * @return 全部所有数据
	 */
	List<IpLocation> findAll();
	/**
	 * 分页查询数据
	 * @param limit 分页最大值
	 * @param start 开始编号
	 * @return 分页列表数据
	 */
	List<IpLocation> findByPage(int limit, int start);

//	List<IpLocation> findVisitWhereByPage(String where,int limit, int start) throws Exception;
//	/**
//	 * 查询t_visit表中的所有不重复的、未被对比的IP
//	 * @return
//	 * @throws Exception
//	 */
//	List<IpLocation> findAllIp()throws Exception;
}
