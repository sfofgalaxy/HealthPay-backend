package com.g16.healthpay.controller;

import com.g16.healthpay.dto.BillMessage;
import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.dto.BankCardMessage;
import com.g16.healthpay.intercepter.AuthToken;
import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.service.BankCardService;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankCard")
public class BankCardController {
    @Autowired
    BankCardService bankCardService;

    @ApiOperation("绑定银行卡")
    @RequestMapping(value = "/bindBankCard",method = RequestMethod.POST)
    @AuthToken
    public GeneralMessage sendCaptcha(@RequestHeader("token") String token,
                                      @RequestParam("cardNumber") String cardNumber,
                                      @RequestParam("password") String password){
        GeneralMessage message = new GeneralMessage();
        boolean result = bankCardService.bindCard(token,cardNumber,password);
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

    @ApiOperation("删除银行卡")
    @RequestMapping(value = "/deleteBankCard",method = RequestMethod.POST)
    @AuthToken
    public GeneralMessage sendCaptcha(@RequestParam("cardNumber") String cardNumber){
        GeneralMessage message = new GeneralMessage();
        boolean result = bankCardService.deleteCard(cardNumber);
        if(result){
            message.setState(true);
            message.setMessage("删除成功");
        }
        else{
            message.setState(false);
            message.setMessage("删除失败");
        }
        return message;
    }

    @ApiOperation("返回对应银行卡")
    @RequestMapping(value = "/getBankCard",method = RequestMethod.POST)
    @AuthToken
    public BankCardMessage getBankCard(@RequestHeader("token") String token){
        BankCardMessage message = new BankCardMessage();
        List<BankCard> bankCardMessages = bankCardService.getBankCard(token);
        if(bankCardMessages!=null){
            message.setState(true);
            message.setBankCards(bankCardMessages);
        }else{
            message.setState(false);

        }
        return message;
    }

    @ApiOperation("付款")
    @RequestMapping(value = "/pay",method = RequestMethod.PUT)
    @AuthToken
    public GeneralMessage pay(@RequestParam("cardNumber") String cardNumber,
                              @RequestHeader("token") String token,
                              @RequestParam("amount") Double amount){
        return bankCardService.pay(token,cardNumber,amount);
    }
}
