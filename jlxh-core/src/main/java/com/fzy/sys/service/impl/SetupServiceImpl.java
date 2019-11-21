package com.fzy.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.sys.dao.SetupDao;
import com.fzy.sys.domain.SetupDO;
import com.fzy.sys.service.SetupService;



@Service
public class SetupServiceImpl implements SetupService {
	@Autowired
	private SetupDao setupDao;
	
	@Override
	public SetupDO get(Integer id){
		return setupDao.get(id);
	}
	
	@Override
	public List<SetupDO> list(Map<String, Object> map){
		return setupDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return setupDao.count(map);
	}
	
	@Override
	public int save(SetupDO setup){
		return setupDao.save(setup);
	}
	
	@Override
	public int update(SetupDO setup){
		return setupDao.update(setup);
	}
	
	@Override
	public int remove(Integer id){
		return setupDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return setupDao.batchRemove(ids);
	}


	@Override
	public String getKfPhone() {
		List<SetupDO> setupList=list(null);
		return (setupList==null||setupList.size()==0)?"":setupList.get(0).getServiceTelephone();
	}

}
