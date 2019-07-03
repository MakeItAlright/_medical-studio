package com.medical.shiro.realm;

import com.medical.po.Users;
import com.medical.service.AdminService;
import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class AdminRealm extends AuthorizingRealm {

    @Resource
    private AdminService adminService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
      Users adminUser = null;
      CustomizedToken token = (CustomizedToken) authenticationToken;
      String username = token.getUsername();
      adminUser = adminService.findAdminByUsername(username);
      if (adminUser == null)
        throw new UnknownAccountException("用户不存在！");
      //构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
      Object principal = username;  //账号
      Object credentials = adminUser.getPassword();  //密码
      System.out.println("debug-----账号："+username+",密码:"+credentials);
      String realmName = getName();   //当前 realm的 name
      System.out.println("getName():"+getName());
      //取用户信息中唯一的字段来生加密后的密码
      ByteSource credentialsSalt = ByteSource.Util.bytes(username);
      SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,
        realmName);
      System.out.println("admin:"+info);
      return info;
    }
}
