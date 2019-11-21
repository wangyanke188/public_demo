package com.fzy.banner.service;


import java.util.List;
import java.util.Map;

import com.fzy.banner.domain.BannerDO;

/**
 * @author 马凌冰
 * @email
 * @date 2019-10-19
 */
public interface BannerService {

    BannerDO get(Long id);

    List<BannerDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(BannerDO banner);

    int update(BannerDO banner);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
