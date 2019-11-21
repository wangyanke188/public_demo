package com.fzy.shop.util;

import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.common.bean.WxJsapiSignature;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * 官方给的使用js的验证工具
 */
public class SignUtil {

    public static String accessToken = null;

    public static WxJsapiSignature sign(String url,String appId,String appSecret) throws IOException {
        String appurl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+appSecret;
        JSONObject accesTokenObject = AuthUtil.doGetJson(appurl);
        String accesToken = (String) accesTokenObject.get("access_token");
        System.out.println("微信返回accesTokenObject"+accesTokenObject);
        JSONObject jsapiTicketObject = AuthUtil.doGetJson("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accesToken + "&type=jsapi");
        String jsapi_ticket  = (String) jsapiTicketObject.get("ticket");
        System.out.println("微信返回jsapiTicketObject"+jsapiTicketObject);
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "×tamp=" + timestamp +
                "&url=" + url;
        System.out.println("string1="+string1);

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        WxJsapiSignature wxJsapiSignature=new WxJsapiSignature();
        wxJsapiSignature.setAppId("wx56c5f184879412f4");
        wxJsapiSignature.setUrl(url);
        wxJsapiSignature.setNonceStr(nonce_str);
        wxJsapiSignature.setTimestamp(Long.parseLong(timestamp));
        wxJsapiSignature.setSignature(signature);
        //ret.put("jsapi_ticket", jsapi_ticket);
       // ret.put("nonceStr", nonce_str);
//        ret.put("timestamp", timestamp);
       // ret.put("signature", signature);
        //ret.put("appId", "wx1d91459aadf9156e");

        System.out.println("1.ticket(原始)="+jsapi_ticket);
        System.out.println("2.url="+wxJsapiSignature.getUrl());
        //System.out.println("3.jsapi_ticket（处理后）="+);
        System.out.println("4.nonceStr="+wxJsapiSignature.getNonceStr());
        System.out.println("5.signature="+wxJsapiSignature.getSignature());
        System.out.println("6.timestamp="+wxJsapiSignature.getTimestamp());

        return wxJsapiSignature;
    }


    /**
     * 随机加密
     * @param hash
     * @return
     */
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * 产生随机串--由程序自己随机产生
     * @return
     */
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    /**
     * 由程序自己获取当前时间
     * @return
     */
    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}