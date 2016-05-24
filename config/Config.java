package com.iteam.findu.config;

import com.iteam.findu.Util.HttpUtil;
import com.iteam.findu.domain.LocMsg;
import com.iteam.findu.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 存放常量，配置和api接口等
 */
public class Config {
    public static String example = "";
    public static String serverURL = "http://qp520.picp.net";
    public static String saveLocMsgURL = serverURL + "/find/locmsg/save.do";



    public static void test(){
        Map<String,String> params = new HashMap<String,String>();
        User user = new User();
        user.setId("2c93b07f548112fc0154811429710002");
        LocMsg locMsg = new LocMsg();
        locMsg.setUser(user);
        locMsg.setAddr("即墨");
        params.put("locMsg", HttpUtil.createJsonString(locMsg));
        String result = HttpUtil.sendPostMessage(Config.saveLocMsgURL, params);

        System.out.print(result);

    }

}
