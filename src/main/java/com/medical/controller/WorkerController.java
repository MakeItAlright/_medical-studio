package com.medical.controller;

import com.medical.domain.LoginType;
import com.medical.po.Health_insurance;
import com.medical.po.Users;
import com.medical.po.Workers;
import com.medical.service.Health_insuranceService;
import com.medical.service.WorkersService;
import com.medical.shiro.token.CustomizedToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

  @Resource
  private WorkersService workersService;
  @Resource
  private Health_insuranceService insuranceService;

  private static final String WORKER_LOGIN_TYPE = LoginType.WORKER.toString();

  //登录  有问题
  @RequestMapping(value = "/login")
  public String workerLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password){

    Subject worker = SecurityUtils.getSubject();
    if (!worker.isAuthenticated()) {
      CustomizedToken token = new CustomizedToken(username, password, WORKER_LOGIN_TYPE);
      try {
        worker.login(token);
        return "workerHome";
      } catch (IncorrectCredentialsException ice){
        System.out.println("账号或密码输入有误");
      } catch (AuthenticationException ae) {
        System.out.println(ae.getMessage());
      }
    }
    return "login";
  }

  //更新员工信息
  @RequestMapping(value = "/alter", method = RequestMethod.POST)
  public String alterWorkerInfo(@RequestBody Workers workers){
    int rows = workersService.updateWorkersByUsername(workers);
    if (rows > 0)
      return "修改成功";
    return "修改失败";
  }

  //修改学生医保信息
  @RequestMapping(value = "/alter/insurance",method = RequestMethod.POST)
  public String alterCustomerInsuranceInfo(@RequestBody Health_insurance healthInsurance){
   int rows = insuranceService.updateByPrimaryKeySelective(healthInsurance);
    if (rows > 0)
      return "修改成功";
    return "修改失败";
  }

  //列表所有学生
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public List<Users> listCustomer(){
    List<Users> users = workersService.listCustomer();
    return users;
  }

}
