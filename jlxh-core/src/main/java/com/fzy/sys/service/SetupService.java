package com.fzy.sys.service;

import java.util.List;
import java.util.Map;

import com.fzy.sys.domain.SetupDO;

/**
 * 网站配置
 * 
 * @author Wang Yanke
 * @email 15638836857@163.com
 * @date 2019-02-21 14:27:52
 */
public interface SetupService {
	
	SetupDO get(Integer id);
	
	List<SetupDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SetupDO setup);
	
	int update(SetupDO setup);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	String getKfPhone();
}
