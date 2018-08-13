package com.amar.web.shiro;

import com.amar.domain.Resource;
import com.amar.domain.Role;
import com.amar.domain.User;
import com.amar.service.ResourceService;
import com.amar.service.RoleService;
import com.amar.service.UserService;
import com.amar.util.common.SetUtils;
import com.amar.util.common.StringUtils;
import com.amar.util.tool.ShiroKit;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingmx
 * @date 2018/8/12 20:54
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String currentUsername = (String) super.getAvailablePrincipal(principalCollection);
        List<String> roleList = new ArrayList<String>();
        List<String> permissionList = new ArrayList<String>();
        User user = userService.getUserByUserName(currentUsername);
        logger.debug(StringUtils.objToString(user));
        List<Role> listRole = roleService.listRoleByUserName(user.getUsername());
        if (!SetUtils.isNullList(listRole)) {
            for (Role role : listRole) {
                roleList.add(role.getRoleCode());
            }
            logger.debug(StringUtils.objToString(roleList));
        }
        List<Resource> listResource = resourceService.listResourceByRoleList(listRole);
        if (!SetUtils.isNullList(listResource)) {
            for (Resource resource : listResource) {
                permissionList.add(resource.getUrl());
            }
            logger.debug(StringUtils.objToString(permissionList));
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roleList);
        authorizationInfo.addStringPermissions(permissionList);
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        logger.debug("验证当前Subject时获取到token为" + StringUtils.objToString(token));
        User user = userService.getUserByUserName(token.getUsername());
        AuthenticationInfo authenticationInfo = null;
        if(user != null) {
            authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), this.getName());
            ShiroKit.setSession("currentUser", user);
        } else {
            logger.info("获取用户为空[用户名=" + token.getUsername() + "]");
        }
        return authenticationInfo;
    }


}
