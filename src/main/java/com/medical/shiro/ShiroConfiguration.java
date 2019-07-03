package com.medical.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class ShiroConfiguration {
//
//  @Bean(name = "hashedCredentialsMatcher")
//  public HashedCredentialsMatcher hashedCredentialsMatcher() {//凭证计算匹配
//    HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//    hashedCredentialsMatcher.setHashAlgorithmName("MD5");
//    hashedCredentialsMatcher.setHashIterations(1024);
//    hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
//    return hashedCredentialsMatcher;  //返回一个bean对象
//  }
//
//}
