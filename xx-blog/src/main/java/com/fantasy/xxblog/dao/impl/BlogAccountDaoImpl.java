package com.fantasy.xxblog.dao.impl;

import com.fantasy.xxbase.dao.BaseDaoImpl;
import com.fantasy.xxbase.datasource.DataSource;
import com.fantasy.xxblog.dao.BlogAccountDao;
import com.fantasy.xxblog.entity.BlogAccountEntity;
import org.springframework.stereotype.Repository;

/**
 * @author li.fang
 * @sine 17/03/13
 */
@Repository
@DataSource
public class BlogAccountDaoImpl extends BaseDaoImpl<BlogAccountEntity> implements BlogAccountDao {


}
