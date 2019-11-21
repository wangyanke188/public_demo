package com.fzy.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fzy.project.dao.ServerDao;
import com.fzy.project.domain.ServerDO;
import com.fzy.project.service.ServerService;



@Service
public class ServerServiceImpl implements ServerService {
	@Autowired
	private ServerDao serverDao;
	
	@Override
	public ServerDO get(Integer id){
		return serverDao.get(id);
	}
	
	@Override
	public List<ServerDO> list(Map<String, Object> map){
		return serverDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return serverDao.count(map);
	}
	
	@Override
	public int save(ServerDO server){
		return serverDao.save(server);
	}
	
	@Override
	public int update(ServerDO server){
		return serverDao.update(server);
	}
	
	@Override
	public int remove(Integer id){
		return serverDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return serverDao.batchRemove(ids);
	}
	
}
