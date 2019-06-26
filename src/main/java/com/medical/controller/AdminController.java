package com.medical.controller;

import com.medical.domain.LoginType;
import com.medical.po.Workers;
import com.medical.service.WorkersService;
import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private WorkersService workersService;
    private static final String ADMIN_LOGIN_TYPE = LoginType.ADMIN.toString();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String adminLogin(@RequestParam String username,
                             @RequestParam String password){

      Subject admin = SecurityUtils.getSubject();
      if (!admin.isAuthenticated()) {
        CustomizedToken token = new CustomizedToken(username,password,ADMIN_LOGIN_TYPE);
        try {
          admin.login(token);
          return "adminHome";
        } catch (IncorrectCredentialsException ice) {
          System.out.println("账号或密码输入有误");
        } catch (LockedAccountException lae) {
          System.out.println("账号被禁用！");
        } catch (AuthenticationException ae) {
          System.out.println(ae.getMessage());
        }
      }
        return "adminLogin";
    }

    @RequestMapping("/delete")
    public String deleteUserByUsername(@RequestParam String username) {
      int rows = workersService.deleteWorkersByUsername(username);
      System.out.println("删除了："+rows);
      if (rows > 0)
        return "删除成功";
      return "删除失败";
    }

    @RequestMapping("/update")
    public String updateWorkersByUsername(@RequestBody Workers workers) {
      int rows = workersService.updateWorkersByUsername(workers);
      System.out.println("修改了："+rows);
      if (rows > 0)
        return "修改成功";
      return "修改失败";
    }
}
