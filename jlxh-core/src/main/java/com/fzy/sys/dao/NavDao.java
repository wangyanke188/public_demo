package com.fzy.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.fzy.sys.domain.NavDO;

/**
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:14:51
 */
@Mapper
public interface NavDao {

	NavDO get(Integer id);
	
	List<NavDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(NavDO nav);
	
	int update(NavDO nav);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
