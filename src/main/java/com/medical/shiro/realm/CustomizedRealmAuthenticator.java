package com.medical.shiro.realm;

import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

public class CustomizedRealmAuthenticator extends ModularRealmAuthenticator {//自定义Authenticator
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 判断getRealms()是否返回为空
        assertRealmsConfigured();
        //强转为自定义的token
        CustomizedToken token = (CustomizedToken) authenticationToken;
        //获取登录类型
        String loginType = token.getLoginType();
        //所有realm
        Collection<Realm> allRealms = getRealms();
        //登录类型对应的realm
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm: allRealms)
          if (realm.getName().contains(loginType))
            typeRealms.add(realm);
      // 当只有一个Realm时，就使用这个Realm，当配置了多个Realm时，会使用所有配置的Realm
      return typeRealms.size() == 1 ?
        this.doSingleRealmAuthentication(typeRealms.iterator().next(), token) : this.doMultiRealmAuthentication(typeRealms, token);
    }
}
