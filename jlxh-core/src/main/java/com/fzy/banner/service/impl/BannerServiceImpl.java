package com.fzy.banner.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.banner.dao.BannerDao;
import com.fzy.banner.domain.BannerDO;
import com.fzy.banner.service.BannerService;

/**
 * @author 马凌冰
 * @date 2019-02-19
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public BannerDO get(Long id){
        return bannerDao.get(id);
    }

    @Override
    public List <BannerDO> list(Map <String, Object> map){
        return bannerDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return bannerDao.count(map);
    }

    @Override
    public int save(BannerDO banner){
        return bannerDao.save(banner);
    }

    @Override
    public int update(BannerDO banner){
        return bannerDao.update(banner);
    }

    @Override
    public int remove(Long id){
        return bannerDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids){
        return bannerDao.batchRemove(ids);
    }

}


