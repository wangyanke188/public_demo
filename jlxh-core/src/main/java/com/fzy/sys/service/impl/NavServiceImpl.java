package com.fzy.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.sys.dao.NavDao;
import com.fzy.sys.domain.NavDO;
import com.fzy.sys.service.NavService;



@Service
public class NavServiceImpl implements NavService {
	@Autowired
	private NavDao navDao;
	
	@Override
	public NavDO get(Integer id){
		return navDao.get(id);
	}
	
	@Override
	public List<NavDO> list(Map<String, Object> map){
		return navDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return navDao.count(map);
	}
	
	@Override
	public int save(NavDO nav){
		return navDao.save(nav);
	}
	
	@Override
	public int update(NavDO nav){
		return navDao.update(nav);
	}
	
	@Override
	public int remove(Integer id){
		return navDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return navDao.batchRemove(ids);
	}
	
}
