package com.sxy.controller;

import com.sxy.service.WeiXinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/3/28.
 */
@Controller
@RequestMapping("/wx")
public class WeiXinController {

    @Autowired
    private WeiXinService weiXinService;

    /**
     * 微信初始化方法
     * @return
     */
    @RequestMapping(value = "/init",method = RequestMethod.GET)
    @ResponseBody
    public String init(String msg_signature,String timestamp,String nonce,String echostr){

        return weiXinService.init(msg_signature,timestamp,nonce,echostr);
    }
}
