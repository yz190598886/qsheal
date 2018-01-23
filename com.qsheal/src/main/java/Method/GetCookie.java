package Method;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class GetCookie {
    public String getTmpcookies(String loginurl) throws IOException {
        String tmpcookies = "";
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
            Cookie[] cookies = httpClient.getState().getCookies();

            for (Cookie c : cookies) {
                tmpcookies += c.toString() + ";";
                //        System.out.println(tmpcookies);
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmpcookies;
    }

    public String postMerhod(String httpurl,String cookie) throws IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod1 = new PostMethod(httpurl);
        postMethod1.setRequestHeader("cookie", cookie);
        httpClient.executeMethod(postMethod1);
        String posttxt = postMethod1.getResponseBodyAsString();
        return posttxt;

    }

    public String getMethod(String httpurl,String cookie) throws IOException {
        HttpClient httpClient1 = new HttpClient();
        GetMethod getMethod1 = new GetMethod(httpurl);
        getMethod1.setRequestHeader("cookie", cookie);
        httpClient1.executeMethod(getMethod1);
        String gettxt = getMethod1.getResponseBodyAsString();
        return gettxt;

    }

    public void fhyz(String jsondata) throws IOException {
                JSONObject json= JSON.parseObject(jsondata);
                String first=json.get("pageView").toString();//取第一层
                JSONObject json1= JSON.parseObject(first);
                String two=json1.get("rowCount").toString();//取第二层
                System.out.println("个人会员人数："+two);
    }
}