package com.medical.controller;

import com.medical.domain.LoginType;
import com.medical.po.Health_insurance;
import com.medical.po.Users;
import com.medical.service.Health_insuranceService;
import com.medical.service.UsersService;
import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class CustomerController {

    private static final String USER_LOGIN_TYPE = LoginType.USER.toString();

    @Resource
    private UsersService usersService;
    @Resource
    private Health_insuranceService insuranceService;

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody Users users){
        System.out.println("------debug:username="+users.getUsername());
        Users user = this.usersService.findUserByUsername(users.getUsername());
        //查询账号是否已存在, return 返回给前端的值
        if (user == null) {
          //账号不存在则可以注册
          int rows = this.usersService.insert(users);
          if (rows > 0)
            return "注册成功";
        }
        return "注册失败";
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password){

        System.out.println("---------debug:username="+username+",password="+password);
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {

//          String algorithmName = "MD5";
//          Object source = password;
//          Object salt = ByteSource.Util.bytes(source);
//          int hashIterations = 1024;
//          Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
//          System.out.println("result"+result);

          CustomizedToken token = new CustomizedToken(username, password, USER_LOGIN_TYPE);
          token.setRememberMe(false);
          try {
            currentUser.login(token);
            return "home";
          } catch (IncorrectCredentialsException ice) {
            System.out.println("账号或密码输入有误:");
          } catch (LockedAccountException lae) {
            System.out.println("账号被锁定！");
          } catch (AuthenticationException ae) {
            System.out.println(ae.getMessage());
          }
        }
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String doLogout() {
      SecurityUtils.getSubject().logout();
      return "login";
    }

    //查询医保信息
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public Health_insurance listInfo(@RequestParam("username") String username) {
      Health_insurance userInfo = insuranceService.findInsuranceByStudentUsername(username);
      return userInfo;
    }

    //更新用户信息
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCustomersByUsername(@RequestBody Users users) {
      int rows = usersService.updateUsersByUsername(users);
      System.out.println("修改了："+rows);
      if (rows > 0)
        return "修改成功";
      return "修改失败";
    }

}
