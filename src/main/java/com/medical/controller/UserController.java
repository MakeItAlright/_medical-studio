package com.medical.controller;

import com.medical.domain.LoginType;
import com.medical.po.Users;
import com.medical.service.UsersService;
import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final String USER_LOGIN_TYPE = LoginType.USER.toString();

    @Resource
    private UsersService usersService;

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody Users users){
        System.out.println("------debug:username="+users.getUsername());
        //对前端传来的账号查询是否已存在
        Users user = this.usersService.findUserByUsername(users.getUsername());
        //查询到用户信息代表存在
        if (user != null)
          return "账号已存在";
        else {
          //账号不存在则可以注册
          int rows = this.usersService.insert(users);
          if (rows > 0)
            return "注册成功";
        }
        return "注册失败";
    }
    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@RequestParam String username,
                            @RequestParam String password){

        System.out.println("---------debug:username="+username+",password="+password);
        Subject user = SecurityUtils.getSubject();
        if (!user.isAuthenticated()) {
          CustomizedToken token = new CustomizedToken(username, password, USER_LOGIN_TYPE);
          try {
            user.login(token);
            System.out.println("用户是否登录:" + user.isAuthenticated());
            return "home";
          } catch (IncorrectCredentialsException ice) {
            System.out.println("账号或密码输入有误");
          } catch (LockedAccountException lae) {
            System.out.println("账号被禁用！");
          } catch (AuthenticationException ae) {
            System.out.println(ae.getMessage());
          }
        }
          return "login";
    }
    //查询用户信息
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public Users listInfo(@RequestParam String username) {
      Users userInfo = usersService.findUserByUsername(username);
      return userInfo;
    }
    //更新用户信息
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateWorkersByUsername(@RequestBody Users users) {
      int rows = this.usersService.updateUsersByUsername(users);
      System.out.println("修改了："+rows);
      if (rows > 0)
        return "修改成功";
      return "修改失败";
    }

}
