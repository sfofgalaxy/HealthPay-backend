package com.g16.healthpay.controller;

import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.service.BankCardService;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankCard")
public class BankCardController {
    @Autowired
    BankCardService bankCardService;
    @Autowired
    RedisUtils redisUtils;

    @ApiOperation("绑定银行卡")
    @RequestMapping(value = "/bindBankCard",method = RequestMethod.POST)
    public GeneralMessage sendCaptcha(@RequestParam("phone") String phone,
                                      @RequestParam("cardNumber") String cardNumber,
                                      @RequestParam("password") String password){
        GeneralMessage message = new GeneralMessage();
        boolean result = bankCardService.bindCard(phone,cardNumber,password);
        if(result){
            message.setState(true);
            message.setMessage("绑定成功");
        }
        else{
            message.setState(false);
            message.setMessage("绑定失败");
        }
        return message;
    }

}
