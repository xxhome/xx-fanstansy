package com.fantasy.xxblog.auth;

import org.apache.shiro.authz.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lifang on 2015/5/18.
 */
public class WildcardPermissionEx implements Permission {

    @Override
    public boolean implies(Permission permission) {
        return true;
    }
}
