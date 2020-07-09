package com.g16.healthpay.controller;

import com.g16.healthpay.api.HealthApi;
import com.g16.healthpay.dto.BillMessage;
import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.dto.BankCardMessage;
import com.g16.healthpay.intercepter.AuthToken;
import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.service.BankCardService;
import com.g16.healthpay.service.HealthService;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
public class HealthController {

    @Autowired
    HealthService healthService;


    @ApiOperation("查询健康状况")
    @RequestMapping(value = "/checkHealth",method = RequestMethod.POST)
    public GeneralMessage sendCaptcha(@RequestParam("id") String id){

        GeneralMessage message = new GeneralMessage();
        List<Integer> result = healthService.checkHealthService(id);
        if(null==result||result.size()==0){
            message.setState(false);
            message.setMessage("查询失败");
        }else{
            message.setState(true);
            message.setMessage(result.get(0)+"");
        }

        return message;
    }



}
