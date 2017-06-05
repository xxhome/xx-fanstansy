package com.fantasy.xxblog.service;

import com.fantasy.xxbase.service.BaseService;
import com.fantasy.xxblog.entity.BlogAuthorityEntity;

import java.util.List;

/**
 * @author li.fang
 * @since 2017/6/3
 */
public interface BlogAuthorityService extends BaseService<BlogAuthorityEntity> {

    List<BlogAuthorityEntity> findByAccountId(String accountId);

}
