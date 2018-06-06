package demo;

import Method.HttpRequest;
import Method.OneExcelDemo;
import Method.Params;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class InterfaceTest {
    private static final Logger log =Logger.getLogger(InterfaceTest.class);

    public String GetCookie() throws IOException {
        String LoginUrl="https://dev.fkhwl.com/webgis_test/login.html?loginAccount=18181915310&loginPasswd=95075dfedfe8f80ac6e45115918fd7f3&randomCode=111&loginType=2";
        HttpRequest httpRequest=new HttpRequest();
        String cookie=httpRequest.getTmpcookies(LoginUrl);
        return cookie;
    }
            @Test
   public void IntetfaceaTestOne() throws IOException {
        String path = "E:/接口参数.xlsx";
        OneExcelDemo oneExcelDemo=new OneExcelDemo();
        List<Params> params=oneExcelDemo.read(path);
//        第一行数据
        String Url=params.get(0).getUrl();
        String Parameter=params.get(0).getParameter();
        String result=params.get(0).getResult();
        String HttpUrl=Url+"?"+Parameter;
        System.out.println(Url);
        System.out.println(Parameter);
//        System.out.println(result);
        String Cookie=GetCookie();
        HttpRequest httpRequest=new HttpRequest();
        String response=httpRequest.getMethod(HttpUrl,Cookie);
        log.info(httpRequest.getMethod(HttpUrl,Cookie));
        System.out.println(response);




    }
}
