package com.medical.shiro.realm;

import com.medical.po.Users;
import com.medical.service.UsersService;
import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
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
      Users user = null;
      CustomizedToken token = (CustomizedToken) authenticationToken;
      //从 token获取用户账户到数据库进行查询
      String username = token.getUsername();
      user = usersService.findUserByUsername(username);
      if (user == null)
        throw new UnknownAccountException("用户不存在！");

      //构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
      Object principal = username;  //账号
      Object credentials = user.getPassword();  //密码
      String realmName = getName();   //获取当前 realm的名字
      System.out.println("debug-----账号："+username+",密码:"+credentials);
      System.out.println("getName():"+getName());
      //取用户信息中唯一的字段来生加密后的密码
      ByteSource credentialsSalt = ByteSource.Util.bytes(principal);
      SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,
        realmName);
      System.out.println(info);
      return info;
    }
}
