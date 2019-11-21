package com.fzy.banner.dao;

import org.apache.ibatis.annotations.Mapper;

import com.fzy.banner.domain.BannerDO;

import java.util.List;
import java.util.Map;
@Mapper
public interface BannerDao {
    BannerDO get(Long id);

    List <BannerDO> list(Map <String, Object> map);

    int count(Map<String, Object> map);

    int save(BannerDO banner);

    int update(BannerDO banner);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
