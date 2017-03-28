package com.sxy.service;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.sxy.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
public class WeiXinService {

    @Value("${weixin.token}")
    private String token;
    @Value("${weixin.aeskey}")
    private String aeskey;
  @Value("${weixin.corpId}")
    private String corpId;

    /**
     * 微信初始化方法
     * @return
     */
    public String init(String msg_signature,String timestamp,String nonce,String echostr){
        try {
            WXBizMsgCrypt crypt=new WXBizMsgCrypt(token,aeskey,corpId);
            return  crypt.VerifyURL(msg_signature,timestamp,nonce,echostr);
        } catch (AesException e) {
            e.printStackTrace();
            throw new ServiceException("微信初始化异常",e);
        }

    }
}
