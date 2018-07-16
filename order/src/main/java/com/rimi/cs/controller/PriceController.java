package com.rimi.cs.controller;

import com.rimi.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 充值
 *
 * @author wenyan
 * @date 2018-06-26 15:25
 */
@Controller
public class PriceController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value="/addMoney",method = RequestMethod.POST)
    public Map addmoney(Integer userid, Double money){
        Map map = new HashMap<String,String>();
        double countMoney = userService.selectMoneyById(userid);
        countMoney += money;
        int i = -1;
        i = userService.updateMoneyByUserId(userid, countMoney);

        if(i == -1){
            map.put("mess","您好，当前余额为: " + countMoney);
        }
        if(i == 0){
           map.put("mess","充值失败! 当前余额为: " + countMoney);
        }else{
            map.put("mess","充值成功! 当前余额为: " + countMoney);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value="/selMoney",method = RequestMethod.GET)
    public Map selmoney(Integer userid){
        System.out.println(userid);
        Map map = new HashMap<String,String>();
        double countMoney = userService.selectMoneyById(userid);
        map.put("mess","您当前的余额为:"+countMoney);

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/countMoney",method = RequestMethod.POST)
    public Map countMoney(Integer userid,Double money){
        System.out.println("122222222");
        System.out.println(userid);
        Map map = new HashMap<String,String>();
        double countMoney = userService.selectMoneyById(userid);
        countMoney -= money;
      /*  i = userService.updateMoneyByUserId(1, countMoney);*/

        if(countMoney >= 0){
            userService.updateMoneyByUserId(userid, countMoney);
            map.put("mess","您好，付款成功!");
        }else{
            map.put("mess","您好，,余额不足,付款失败!");
        }
        return map;
    }
}
