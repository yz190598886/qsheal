package TestCase;

import Method.HttpRequest;
import Method.jdbc;
import Method.IdCard;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class yanglaoOrderTest {
    private static Logger log = Logger.getLogger(HttpRequest.class);
    public String name(){
            SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        //    System.out.println(sdf.format(new Date()));
            String name="ylz"+sdf.format(new Date());
            return name;
        }
        public String idcard(){
            IdCard.Id idCard=new IdCard.Id();
            String idc=idCard.Calculate();
            return idc;

        }
        public void adduser() throws Exception {
            String name=name();
            String idC=idcard();
            String ZFloginurl="https://test.chinaylzl.com/j_spring_security_check?mobile=13999999996&password=158743&passwordState=false";
            String addUserurl="https://test.chinaylzl.com/surveyUser/addSurveyUser?" +
                    "id=&uid=&buyYwshbxZiji=&buyYwshbxZinv=&buyYwshbxDanwei=&buyYwshbxZengyu=&buyYwshbxQita=&sourceType=&currentStatus=1&headImage=&idcard="+idC+"&username="+name+"&nationality=%E6%B1%89%E6%97%8F&maritalstatus=0" +
                    "&level=2&contact1=13812341234&residenceaddress=9001090201&address=%E8%AF%A6%E7%BB%86%E5%9C%B0%E5%9D%801%E5%8F%B7&czAddress=%E5%B8%B8%E4%BD%8F%E5%9C%B0%E5%9D%802%E5%8F%B7&emergencycontact1name=%E7%B4%A7%E6%80%A5%E8%81%94%E7%B3%BB%E4%BA%BA%E5%A7%93%E5%90%8D&emergencycontact1relationship=0" +
                    "&emergencycontact1address=%E7%B4%A7%E6%80%A5%E8%81%94%E7%B3%BB%E4%BA%BA%E5%B1%85%E4%BD%8F%E5%9C%B0%E5%9D%80&emergencycontact1phone=%E7%B4%A7%E6%80%A5%E8%81%94%E7%B3%BB%E4%BA%BA%E8%81%94%E7%B3%BB%E6%96%B9%E5%BC%8F&ssCard=&yanglaojigoumingcheng=&laoniandaxuemingcheng=&laonianxiehuimingcheng=";
            System.out.println("政府端登陆获取cookie--------------------------");
            HttpRequest ZFHttp=new HttpRequest();
            String ZFcookie=ZFHttp.getTmpcookies(ZFloginurl);
            log.info(ZFHttp.postMethod(addUserurl,ZFcookie));//添加老人

            String SqlUid="SELECT id from user where idCard='"+idC+"'";//SQL书写+++++++++++
            jdbc jdbc=new jdbc();
            String Uid=jdbc.getSearchResult(SqlUid);

            String charge="https://test.chinaylzl.com/Balance/SingleRecharge?uid="+Uid+"&balance=1000&remark=0&source=";
            String yue="https://test.chinaylzl.com/surveyUser/userListFinance?uid="+Uid+"&_=1516695813599";
            System.out.println("积分充分--------------------------");
            log.info(ZFHttp.postMethod(charge,ZFcookie));//充分
            String first=ZFHttp.Jsonvalue(ZFHttp.getMethod(yue,ZFcookie),"data");
            System.out.println("余额："+first);
            assertEquals("余额：","1000.00",first);

            System.out.println("企业端登陆获取cookie-------------------");
            String DYloginurl="https://test1.chinaylzl.com/submitLogin?account=191415&password=158743";
            String Orderurl="https://test1.chinaylzl.com/service/createOrders?classification=1&groupId=2&idcard="+idC+"&uid="+Uid+"&memberId=&mark=&itemsId=8761&number=1&endDate=2018-01-24+23%3A59%3A59";
            HttpRequest QYHttp=new HttpRequest();
            String QYcookie=QYHttp.getTmpcookies(DYloginurl);

            System.out.println("创建订单---------------------");
            log.info(QYHttp.postMethod(Orderurl,QYcookie));//创建订单

            String SqlOrderId="SELECT order_id from assist_pai_orders where uid=(SELECT id from user where idCard='"+idC+"')";
            String OrderId=jdbc.getSearchResult(SqlOrderId);
            String paidanurl="https://test1.chinaylzl.com/serviceRecord/saveServiceRecord?buid=736&orderId="+OrderId;

            System.out.println("派工----------------------------");
            log.info(QYHttp.postMethod(paidanurl,QYcookie));//派工

            String Orderlisturl="https://test1.chinaylzl.com/user/api/queryWaitServiceList?startRow=0&buid=736";
            QYHttp.getMethod(Orderlisturl,QYcookie);

            String apploginurl="https://test1.chinaylzl.com/user/api/login?password=158743&account=827685";
            HttpRequest AppHttp=new HttpRequest();

            System.out.println("App登陆----------------------------");
            String Appcookie=AppHttp.getTmpcookies(apploginurl);
            String startServiceurl="https://test1.chinaylzl.com/user/api/startService&startPosition=104.081906%2C30.546332&orderId="+OrderId;

            System.out.println("开始服务----------------------------");
            log.info(AppHttp.postMethod(startServiceurl,Appcookie));//开始服务，上传坐标

            String completeServiceUrl="https://test1.chinaylzl.com/user/api/completeService?type=2&images=https%3A%2F%2Ffile.chinaylzl.com%2Ftest%2FserviceImages%2F2018%2F01%2F24%2F39f1efaf23ed4299b962289714207202.jpg&endPosition=104.081902%2C30.546354&orderId="+OrderId;

            System.out.println("完成服务----------------------------");
            log.info(AppHttp.postMethod(completeServiceUrl,Appcookie));

            System.out.println("满意度----------------------------");
            String updateServiceDegreeUrl="https://test1.chinaylzl.com/user/api/updateServiceDegree?degree=80&orderId="+OrderId;
            log.info(AppHttp.postMethod(updateServiceDegreeUrl,Appcookie));









}
}