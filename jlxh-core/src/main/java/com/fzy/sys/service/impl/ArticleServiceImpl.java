package com.fzy.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.sys.dao.ArticleDao;
import com.fzy.sys.domain.ArticleDO;
import com.fzy.sys.service.ArticleService;



@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public ArticleDO get(Integer id){
		return articleDao.get(id);
	}
	
	@Override
	public List<ArticleDO> list(Map<String, Object> map){
		return articleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return articleDao.count(map);
	}
	
	@Override
	public int save(ArticleDO article){
		return articleDao.save(article);
	}
	
	@Override
	public int update(ArticleDO article){
		return articleDao.update(article);
	}
	
	@Override
	public int remove(Integer id){
		return articleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return articleDao.batchRemove(ids);
	}
	
}
