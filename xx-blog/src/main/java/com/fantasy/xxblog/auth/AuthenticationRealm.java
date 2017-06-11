package com.fantasy.xxblog.auth;

import com.fantasy.xxbase.entity.XXAuthorityEntity;
import com.fantasy.xxbase.vo.Principal;
import com.fantasy.xxblog.entity.BlogAccountEntity;
import com.fantasy.xxblog.entity.BlogAuthorityEntity;
import com.fantasy.xxblog.service.BlogAccountService;
import com.fantasy.xxblog.service.BlogAuthorityService;
import com.fantasy.xxutil.util.XXCipherUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by lifang on 2015/1/24.
 */
public class AuthenticationRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(AuthenticationRealm.class);

    @Autowired
    private BlogAccountService blogAccountService;
    @Autowired
    private BlogAuthorityService blogAuthorityService;

    @Value("${system.login.locked.count}")
    private String lockedCount;

    @Value("${system.login.locked.seconds}")
    private String lockedSeconds;


    /**
     * 权限认证, 在权限校验时执行
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
        Principal principal = (Principal) principals.getPrimaryPrincipal();

        //设置用户的权限
        BlogAccountEntity blogAccountEntity = blogAccountService.findById(principal.getId());
        List<BlogAuthorityEntity> blogAuthorityEntityList = blogAuthorityService.findByAccountId(principal.getId());
        Set<String> strPermissions = blogAuthorityEntityList.stream().map(XXAuthorityEntity::getAuthorities).collect(Collectors.toSet());
        simpleAuthenticationInfo.setRoles(new HashSet<>(blogAccountEntity.getRoleIds()));
        simpleAuthenticationInfo.setStringPermissions(strPermissions);

//        WildcardPermissionEx wildcardPermissionEx = new WildcardPermissionEx();
//        simpleAuthenticationInfo.addObjectPermission(wildcardPermissionEx);
        return simpleAuthenticationInfo;
    }

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        String host = usernamePasswordToken.getHost();

        logger.info("login username : {}", username);
        logger.info("login password : {}", password);
        logger.info("login host : {}", host);

        if (StringUtils.isBlank(username) || StringUtils.isBlank(String.valueOf(password))) {
            throw new UnknownAccountException();
        }
        BlogAccountEntity blogAccountEntity = blogAccountService.findOneByName(username);
        if (blogAccountEntity != null) {
            if (blogAccountEntity.isLocked()) {
                throw new LockedAccountException();
            }
            if (StringUtils.equals(blogAccountEntity.getPassword(), XXCipherUtils.getDesEncryptText(password))) {
                //登录成功,登录次数加1,失败次数归零,并记录登录日志
                Long loginCount = blogAccountEntity.getLoginSucceedCount() + 1L;
                blogAccountEntity.setLoginSucceedCount(loginCount);
                blogAccountEntity.setLoginFailedCount(0);
                blogAccountService.merge(blogAccountEntity);
                logger.info("登录成功");

                return new SimpleAuthenticationInfo(
                        new Principal(blogAccountEntity.getId(), blogAccountEntity.getName()),
                        password,
                        getName());

            } else {
                //登录失败,登录失败次数加1
                logger.info("登录失败");
                long failedCount = blogAccountEntity.getLoginFailedCount() + 1;
                if (failedCount >= getLockCount()) {
                    blogAccountEntity.setLocked(true);
                }
                blogAccountEntity.setLoginFailedCount(failedCount);
                blogAccountService.merge(blogAccountEntity);
                throw new IncorrectCredentialsException();
            }
        }
        throw new UnknownAccountException();
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    private int getLockCount() {
        if (StringUtils.isBlank(lockedCount)) {
            return 5;
        }
        return Integer.valueOf(lockedCount);
    }

}
