package com.g16.healthpay.controller;

import com.aliyuncs.exceptions.ClientException;
import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.intercepter.AuthToken;
import com.g16.healthpay.service.UserService;
import com.g16.healthpay.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Resource
//    @Autowired
    @Autowired
    UserService userService;

    //等价@PostMapping("/login")
    @ApiOperation("登录/注册")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public GeneralMessage login(@RequestParam("phone") String phone,
                              @RequestParam("captcha") String captcha){
        GeneralMessage message = new GeneralMessage();
        String token = userService.verify(phone,captcha);
        if(token!=null){
            message.setState(true);
            message.setMessage(token);
        }else{
            message.setState(false);
            message.setMessage("登录失败");
        }

        return message;
    }

    //等价@PostMapping("/login")
    @ApiOperation("注销")
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @AuthToken
    public GeneralMessage logout(@RequestHeader("token") String token){
        GeneralMessage message = new GeneralMessage();
        if(userService.logout(token)){
            message.setState(true);
            message.setMessage("注销成功");
        }else{
            message.setState(false);
            message.setMessage("注销失败");
        }
        return message;
    }


    @ApiOperation("发送验证码")
    @RequestMapping(value = "/sendCaptcha",method = RequestMethod.POST)
    public GeneralMessage sendCaptcha(@RequestParam("phone") String phone) throws ClientException {
        GeneralMessage message = new GeneralMessage();
        if(userService.sendCaptcha(phone)){
            message.setState(true);
            message.setMessage("发送成功");
        }
        else {
            message.setState(false);
            message.setMessage("发送失败");
        }
        return message;
    }
}
