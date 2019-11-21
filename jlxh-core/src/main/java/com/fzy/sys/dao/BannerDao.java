package com.fzy.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.fzy.sys.domain.BannerDO;

/**
 * banner图
 * @author Wang Yanke
 * @email waittoforyou521@163.com
 * @date 2019-09-11 10:14:46
 */
@Mapper
public interface BannerDao {

	BannerDO get(Integer id);
	
	List<BannerDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(BannerDO banner);
	
	int update(BannerDO banner);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
