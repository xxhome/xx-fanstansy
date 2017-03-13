package com.xxblog.dao;

import com.xxbase.dao.BaseDaoImpl;
import com.xxblog.entity.AccountEntity;
import com.xxblog.entity.BlogEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 17/02/17.
 */
@Repository
public class BlogDaoImpl extends BaseDaoImpl<BlogEntity, Long> implements BlogDao{


}
