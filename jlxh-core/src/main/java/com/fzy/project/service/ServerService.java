package com.fzy.project.service;

import com.fzy.project.domain.ServerDO;

import java.util.List;
import java.util.Map;

/**
 * 服务项目
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-12 10:07:53
 */
public interface ServerService {
	
	ServerDO get(Integer id);
	
	List<ServerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ServerDO server);
	
	int update(ServerDO server);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
