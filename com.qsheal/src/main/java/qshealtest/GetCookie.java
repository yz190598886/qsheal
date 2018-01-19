package qshealtest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
public class GetCookie{
public String getTmpcookies(String loginurl){
        String tmpcookies= "";
        HttpClient httpClient = new HttpClient();
        //获得POST请求方法
        PostMethod postMethod = new PostMethod(loginurl);
//       postMethod.setRequestBody(data);

        try {
        //设置 HttpClient 接收 Cookie,用与浏览器一样的策略
        httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        int loginState = httpClient.executeMethod(postMethod);
        System.out.println(loginState);
        //获得登陆后的 Cookie
        Cookie[] cookies=httpClient.getState().getCookies();

        for(Cookie c:cookies){
        tmpcookies += c.toString()+";";
//        System.out.println(tmpcookies);
        }
        } catch (HttpException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }

        return tmpcookies;
}

}