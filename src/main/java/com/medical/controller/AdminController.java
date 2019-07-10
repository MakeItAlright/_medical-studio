package com.medical.controller;

import com.medical.domain.LoginType;
import com.medical.po.Users;
import com.medical.po.Workers;
import com.medical.service.AdminService;
import com.medical.service.WorkersService;
import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private WorkersService workersService;

    private static final String ADMIN_LOGIN_TYPE = LoginType.ADMIN.toString();

    //管理员登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String adminLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password){

      Subject admin = SecurityUtils.getSubject();
      if (!admin.isAuthenticated()) {

//        String algorithmName = "MD5";   //加密算法
//        Object source = password;  //密码
//        ByteSource salt = ByteSource.Util.bytes(username);    //取唯一字段(账号)生成盐值
//        int hashIterations = 10204;   //加密次数
//        Object result = new SimpleHash(algorithmName,source,salt,hashIterations);
//        System.out.println("result:"+result);

        CustomizedToken token = new CustomizedToken(username,password,ADMIN_LOGIN_TYPE);
        token.setRememberMe(false);
        try {
          admin.login(token);
          return "adminHome";
        } catch (IncorrectCredentialsException ice) {
          System.out.println("账号或密码输入有误");
        } catch (AuthenticationException ae) {
          System.out.println(ae.getMessage());
        }
      }
        return "adminLogin";
    }

    @RequestMapping(value = "/logout")
    public String doLogout() {
      SecurityUtils.getSubject().logout();
      return "adminLogin";
    }

    //创建一个员工用户
    @RequestMapping(value = "/create/worker", method = RequestMethod.POST)
    public String createWorker(@RequestBody Workers workers){
      //查询账号是否已存在
      Workers worker = workersService.findWorkerByUsername(workers.getUsername());
      if (worker == null) {
        //账号不存在则可以注册
        int rows = adminService.insertWorker(workers);
        if (rows > 0)
          return "注册成功";
      }
      return "注册失败";
    }

    //删除角色为员工的接口
    @RequestMapping("/delete")
    public String deleteWorkersByUsername(@RequestParam("username") String username) {
      int rows = adminService.deleteWorkersByUsername(username);
      System.out.println("删除了："+rows);
      if (rows > 0)
        return "删除成功";
      return "删除失败";
    }

    //更改员工的角色信息
    @RequestMapping("/update")
    public String updateWorkersByUsername(@RequestBody Workers workers) {
      int rows = adminService.updateWorkersByUsername(workers);
      System.out.println("修改了："+rows);
      if (rows > 0)
        return "修改成功";
      return "修改失败";
    }

    //管理员信息修改
    @RequestMapping("/alter")
    public String alterAdminInfo(@RequestBody Users users){
      int rows = adminService.alterAdminInfo(users);
      if (rows > 0)
        return "修改成功";
      return "修改失败";
    }

    //列出员工信息
    @RequestMapping("/info")
    public List<Workers> listInfo() {
      List<Workers> workerInfo = adminService.listWorkers();
      return workerInfo;
    }

}
