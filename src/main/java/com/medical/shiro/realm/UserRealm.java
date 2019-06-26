package com.medical.shiro.realm;

import com.medical.po.Users;
import com.medical.service.UsersService;
import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {

    @Resource
    private UsersService usersService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
      CustomizedToken token = (CustomizedToken) authenticationToken;
      String username = token.getUsername();
      Users user = usersService.findUserByUsername(username);
      if (user == null)
        throw new UnknownAccountException("用户不存在！");
      //构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
      Object principal = username;  //账号
      Object credentials = user.getPassword();  //密码
      String realmName = getName();   //当前 realm的 name
      //取用户信息中唯一的字段来生加密后的密码
      ByteSource credentialsSalt = ByteSource.Util.bytes(username);
      SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,
        realmName);
      return info;
    }
}
