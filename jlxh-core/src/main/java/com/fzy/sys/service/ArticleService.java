package com.fzy.sys.service;

import java.util.List;
import java.util.Map;

import com.fzy.sys.domain.ArticleDO;

/**
 * 系统文章
 * 
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:14:57
 */
public interface ArticleService {
	
	ArticleDO get(Integer id);
	
	List<ArticleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ArticleDO article);
	
	int update(ArticleDO article);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
