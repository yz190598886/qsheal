package demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;
import qshealtest.GetCookie;

import java.io.IOException;

public class ATest {
    @Test
    public void gerenhuiyuan() throws IOException {
        String numurl="https://test1.chinaylzl.com/member/findMemberList?classification=3";
        String loginurl="https://test1.chinaylzl.com/submitLogin?account=191415&password=158743";
        GetCookie ok=new GetCookie();
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod1=new PostMethod(numurl);
        postMethod1.setRequestHeader("cookie",ok.getTmpcookies(loginurl));
        httpClient.executeMethod(postMethod1);
        String txt=postMethod1.getResponseBodyAsString();
//        System.out.println(txt);
        JSONObject json= JSON.parseObject(txt);
        String a=json.get("pageView").toString();//取第一层
        JSONObject json1= JSON.parseObject(a);
        String b=json1.get("rowCount").toString();//取第二层
        System.out.println("个人会员人数："+b);
    }
    @Test
    public void orderlist() throws IOException {
        String aplogin="https://test1.chinaylzl.com/user/api/login?password=158743&account=13999999998";
//        String ServiceList="https://test1.chinaylzl.com/user/api/queryWaitServiceList?startRow=0&buid=249 ";
        String completeService="https://test1.chinaylzl.com/user/api/completeService?type=2&images=https%3A%2F%2Ffile.chinaylzl.com%2Ftest%2FserviceImages%2F2018%2F01%2F19%2F282afea38588459ead565e66874c984b.jpg&endPosition=104.081873%2C30.546266&orderId=159673754337";
        GetCookie ok=new GetCookie();
        HttpClient httpClient = new HttpClient();
        GetMethod GetMethod=new GetMethod(completeService);
        GetMethod.setRequestHeader("cookie",ok.getTmpcookies(aplogin));
        httpClient.executeMethod(GetMethod);
        String txt1=GetMethod.getResponseBodyAsString();
        System.out.println(txt1);

}
}