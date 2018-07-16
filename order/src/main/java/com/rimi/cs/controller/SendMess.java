package com.rimi.cs.controller;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
        *发送短信验证
        *
        *

@author wenyan
 * @date 2018-06-26 08:43
 */
@Controller
public class SendMess {
    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    @RequestMapping(value="/sendMessage",method = RequestMethod.POST)
    public Map sendMess(String phonenum){
        System.out.println(phonenum);
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);
        Map<String, String> map = new HashMap<>();

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

        int mobile_code = 6457;  //随机数生成验证码
        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "1C90056379"), //查看用户名请登录用户中心->验证码、通知短信->帐户及签名设置->APIID
                new NameValuePair("password", "419c0c895a9ebe6fe7ffc4ed97f75cea "),  //查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),   //根据需要，可能要对密码进行加密
                new NameValuePair("mobile", phonenum), //要发送验证码的手机号
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();
            //System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();


        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        map.put("result","true");
        return map;
    }

}
