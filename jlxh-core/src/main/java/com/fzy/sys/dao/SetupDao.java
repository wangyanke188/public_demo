package com.fzy.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.fzy.sys.domain.SetupDO;

/**
 * 网站配置
 * @author Wang Yanke
 * @email 15638836857@163.com
 * @date 2019-02-21 14:27:52
 */
@Mapper
public interface SetupDao {

	SetupDO get(Integer id);
	
	List<SetupDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SetupDO setup);
	
	int update(SetupDO setup);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	/**
	 * 获取第一条客服信息 客服的电话和二维码
	 * @return
	 */
	@Select("select `service_telephone`,`service_img`,prize_is_start from sys_setup ORDER BY id desc LIMIT 1")
	SetupDO getSetUpInfoTopOne();
}
