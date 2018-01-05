package demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class TestPost {
            public   void getResoucesByLoginCookies() throws Exception
            {
        //        HttpClientDemo demo = new HttpClientDemo();
                String username = "18181915311";// 登录用户
                String password = "158743";// 登录密码
                System.out.println("---------------------------------------");
                System.out.println("登陆账户："+username);
                System.out.println("登陆密码："+password);
                System.out.println("---------------------------------------");
                String urlLogin = "http://120.76.84.195:8086/checkUser?mobile=" + username + "&password=" + password;
                String urlAfter = "http://120.76.84.195:8086/member/memberList";

                DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());
                HttpPost post = new HttpPost(urlLogin);
                HttpResponse response = client.execute(post);
//                HttpEntity entity = response.getEntity();
                System.out.println("---------------------------------------");
                System.out.println("cookie:"+EntityUtils.toString(response.getEntity()));
                System.out.println("---------------------------------------");
                //cookie处理
                CookieStore cookieStore = client.getCookieStore();
                client.setCookieStore(cookieStore);


                HttpPost post1 = new HttpPost(urlAfter);
                HttpResponse response1 = client.execute(post1);
                System.out.println("---------------------------------------");
                System.out.println("会员："+EntityUtils.toString(response1.getEntity()));
                System.out.println("---------------------------------------");
            }
}