package com.fzy.common.service;


import com.fzy.domain.LogDO;
import com.fzy.domain.PageDO;
import com.fzy.utils.Query;

/**
 *
 */
public interface LogService {
	void save(LogDO logDO);
	PageDO <LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
