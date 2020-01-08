package com.koala.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

/**
 * 验证码发送验证服务.
 * @author Marting.Lee
 * 2019/12/30
 */
public class MessageUtils {

    /**
      *发送短信.
      * @param code String
     * @param phone String
      **/
    public static void Send(String code,String phone){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FtoLM8zU2c9SP9MW6Tq", "5dq0TYqxw9OS8OwAyRLbQqfSzh4csx");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers",phone);
        request.putQueryParameter("SignName", "考拉直播");
        request.putQueryParameter("TemplateCode", "SMS_181506219");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

    /**
      *生成6位随机数.
      * @return java.lang.String
      **/
    public static String generateCode(){
        Random random = new Random();
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        int num3 = random.nextInt(10);
        int num4 = random.nextInt(10);
        int num5 = random.nextInt(10);
        int num6 = random.nextInt(10);
        String code = ""+num1+num2+num3+num4+num5+num6;
        return code;
    }
}
