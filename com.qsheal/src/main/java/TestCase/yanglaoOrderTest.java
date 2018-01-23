package TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import Method.GetCookie;
import Method.IdCard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class yanglaoOrderTest {
        public String name(){
            SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        //    System.out.println(sdf.format(new Date()));
            String name="ylz"+sdf.format(new Date());
            return name;
        }
        public void adduser() throws IOException {
            IdCard.Id idCard=new IdCard.Id();
            String loginurl="https://test.chinaylzl.com/j_spring_security_check?mobile=13999999996&password=158743&passwordState=false";
            String addUserurl="https://test.chinaylzl.com/surveyUser/addSurveyUser?" +
                    "id=&uid=&buyYwshbxZiji=&buyYwshbxZinv=&buyYwshbxDanwei=&buyYwshbxZengyu=&buyYwshbxQita=&sourceType=&currentStatus=1&headImage=&idcard="+idCard.Calculate()+"&username="+name()+"&nationality=%E6%B1%89%E6%97%8F&maritalstatus=0" +
                    "&level=2&contact1=13812341234&residenceaddress=9001090201&address=%E8%AF%A6%E7%BB%86%E5%9C%B0%E5%9D%801%E5%8F%B7&czAddress=%E5%B8%B8%E4%BD%8F%E5%9C%B0%E5%9D%802%E5%8F%B7&emergencycontact1name=%E7%B4%A7%E6%80%A5%E8%81%94%E7%B3%BB%E4%BA%BA%E5%A7%93%E5%90%8D&emergencycontact1relationship=0" +
                    "&emergencycontact1address=%E7%B4%A7%E6%80%A5%E8%81%94%E7%B3%BB%E4%BA%BA%E5%B1%85%E4%BD%8F%E5%9C%B0%E5%9D%80&emergencycontact1phone=%E7%B4%A7%E6%80%A5%E8%81%94%E7%B3%BB%E4%BA%BA%E8%81%94%E7%B3%BB%E6%96%B9%E5%BC%8F&ssCard=&yanglaojigoumingcheng=&laoniandaxuemingcheng=&laonianxiehuimingcheng=";
            String charge="https://test.chinaylzl.com/Balance/SingleRecharge?uid=781241&balance=1000&remark=0&source=";
            String yue="https://test.chinaylzl.com/surveyUser/userListFinance?uid=781241&_=1516695813599?uid=781241&_=1516695813599";
            System.out.println("-----------------------添加老人--------------------------");
            GetCookie getCookie=new GetCookie();
            String cookie=getCookie.getTmpcookies(loginurl);
//            getCookie.postMerhod(addUserurl,cookie);//添加
            System.out.println("-----------------------积分充分--------------------------");
//            getCookie.postMerhod(charge,cookie);//充分
            JSONObject json= JSON.parseObject(getCookie.getMethod(yue,cookie));
            String first=json.get("data").toString();//取第一层
            System.out.println("余额："+first);
            assertEquals("余额：","2000.00",first);


}
}