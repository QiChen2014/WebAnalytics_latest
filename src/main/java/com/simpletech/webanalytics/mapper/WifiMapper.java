package com.simpletech.webanalytics.mapper;

import com.simpletech.webanalytics.model.Wifi;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


/**
 * 数据库表t_bdip的mapper接口
 * @author 树朾
 * @date 2015-12-11 18:11:54 中国标准时间
 */
public interface WifiMapper{

	/**
	 * 统计全部出数据
	 * @return 统计数
	 */
	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND (create_time BETWEEN '2016-03-04 10:25:00' AND '2016-03-04 10:35:59')  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count1(@Param("mac") String mac, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND (create_time BETWEEN '2016-03-04 10:40:00' AND '2016-03-04 10:50:59' )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count2(@Param("mac") String mac, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND (create_time BETWEEN '2016-03-04 11:00:00' AND '2016-03-04 11:10:59' )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count3(@Param("mac") String mac, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND (create_time BETWEEN '2016-03-04 11:20:00' AND '2016-03-04 11:30:59')  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count4(@Param("mac") String mac, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND (create_time BETWEEN '2016-03-04 11:35:00' AND '2016-03-04 11:45:59' )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count5(@Param("mac") String mac, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND ( create_time BETWEEN '2016-03-04 11:50:00' AND '2016-03-04 12:00:59' )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count6(@Param("mac") String mac, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND ( create_time BETWEEN #{start} AND #{end} )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count10seconds(@Param("mac") String mac,@Param("start")Date start,@Param("end")Date end, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND ( create_time BETWEEN #{start} AND #{end} )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count20seconds(@Param("mac") String mac,@Param("start")Date start,@Param("end")Date end, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND ( create_time BETWEEN #{start} AND #{end} )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count30seconds(@Param("mac") String mac,@Param("start")Date start,@Param("end")Date end, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND ( create_time BETWEEN #{start} AND #{end} )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count40seconds(@Param("mac") String mac,@Param("start")Date start,@Param("end")Date end, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND ( create_time BETWEEN #{start} AND #{end} )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count50seconds(@Param("mac") String mac,@Param("start")Date start,@Param("end")Date end, @Param("sig1") int sig1, @Param("sig2") int sig2);

	@Select("SELECT count(*) FROM probe_log WHERE mac_device = #{mac} AND ( create_time BETWEEN #{start} AND #{end} )  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	int count60seconds(@Param("mac") String mac,@Param("start")Date start,@Param("end")Date end, @Param("sig1") int sig1, @Param("sig2") int sig2);

	/**
	 * 统计某一个店的真实数据
	 * @param tableName 表名
	 * @param mac mac地址
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param sig1 信号强度上限
     * @param sig2 限号强度下限
     * @return
     */
	@Select("SELECT count(*) num,signal_strength rss FROM #{tableName} WHERE mac_device = #{mac} AND (create_time BETWEEN #{start} AND #{end})  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2}")
	List<Wifi> realCount(@Param("tableName") String tableName,@Param("mac") String mac,@Param("start")Date start,@Param("end")Date end, @Param("sig1") int sig1, @Param("sig2") int sig2);


	@Select("SELECT count(*) num,signal_strength rss FROM probe_log WHERE idwifi = #{mac} AND (create_time BETWEEN #{start} AND #{end})  AND signal_strength  >= ${sig} group by signal_strength")
	List<Wifi> onehundredCount(@Param("mac") String mac, @Param("start")Date start, @Param("end")Date end, @Param("sig") int sig);

	@Select("SELECT count(*) num,signal_strength rss FROM probe_log WHERE mac_device = #{mac} AND (create_time BETWEEN #{start} AND #{end})  AND signal_strength  <= ${sig1} AND signal_strength > ${sig2} group by signal_strength")
	List<Wifi> rangeCount(@Param("mac") String mac, @Param("start")Date start, @Param("end")Date end, @Param("sig1") int sig1,@Param("sig2") int sig2);

	/**
	 * 实验2 所有数据
	 * @param idwifi WiFi ID
	 * @param start 开始时间
	 * @param end	结束时间
	 * @param sig	信号
	 * @return
	 */
	@Select("SELECT count(*) FROM probe_log_1 WHERE idwifi = #{idwifi} AND (create_time BETWEEN #{start} AND #{end})  AND signal_strength  = ${sig} ")
	int test2(@Param("idwifi") String idwifi, @Param("start")Date start, @Param("end")Date end, @Param("sig") int sig);

	/**
	 * 实验2 店内
	 * @param idwifi WiFi ID
	 * @param start 开始时间
	 * @param end	结束时间
	 * @param sig	信号
	 * @return
	 */
	@Select("SELECT count(*) FROM probe_log_1 WHERE idwifi = #{idwifi} AND mac_device IN ('D4:97:0B:4D:CE:4D','88:E3:AB:CA:A0:14','D8:1D:72:99:D2:89','9C:99:A0:A5:CB:68','48:E9:F1:CF:5B:62','D0:22:BE:79:83:79','94:EB:CD:4F:52:E1','54:9F:13:8E:C9:41') AND (create_time BETWEEN #{start} AND #{end})  AND signal_strength  = ${sig} ")
	int test2in(@Param("idwifi") String idwifi, @Param("start")Date start, @Param("end")Date end, @Param("sig") int sig);

	/**
	 * 实验2 店外
	 * @param idwifi WiFi ID
	 * @param start 开始时间
	 * @param end	结束时间
	 * @param sig	信号
	 * @return
	 */
	@Select("SELECT count(*) FROM probe_log_1 WHERE idwifi = #{idwifi} AND mac_device IN ('ac:cf:85:5f:4d:bd','70:8D:09:91:2D:20','DC:2B:2A:60:75:56','F4:8B:32:A2:44:CD','30:9B:AD:6D:79:C1','D4:97:0B:4B:CE:4B','C4:6A:B7:3A:EC:11','60:F8:1D:00:D2:CC','74:51:BA:0B:F9:32','74:51:BA:77:25:BE','90:18:7C:3F:ED:F2','30:A8:DB:BF:55:78','48:43:7C:45:69:86','f0:25:b7:48:2b:21','B4:0B:44:2E:F2:04','38:BC:1A:D3:94:7D') AND (create_time BETWEEN #{start} AND #{end})  AND signal_strength  = ${sig} ")
	int test2out(@Param("idwifi") String idwifi, @Param("start")Date start, @Param("end")Date end, @Param("sig") int sig);
}