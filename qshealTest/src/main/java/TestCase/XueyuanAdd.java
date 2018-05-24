package TestCase;

import Method.HttpRequest;
import Method.IdCard;
import org.testng.Assert;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XueyuanAdd {
    static int i=1000;
    public String name(){
    SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
    //    System.out.println(sdf.format(new Date()));
    String name="yz"+sdf.format(new Date());
            return name;
}
    public String idcard() {
        IdCard.Id idCard = new IdCard.Id();
        String idc = idCard.Calculate();
        return idc;
    }
    public static  synchronized  int  aa(){
//        int cardNumber=(int)(Math.random()*9+1)*10000000;
//        return cardNumber;
        return i++;

    }
        public void addUser() throws IOException {
            String name=name();
            String idCard=idcard();
//            String addUser="http://120.76.84.195:8087/student/add?&cardNumber="+cardNumber()+"&IDTypeId=1&IDNumber="+idCard+"&name="+name+"&nationId=40&partiesId=41&degreeId=49&degreeValueId=43&duty=%E8%81%8C%E5%8A%A1&title=%E8%81%8C%E7%A7%B0&domicileAddress=%E6%88%B7%E7%B1%8D%E5%9C%B0%E5%9D%80&contact=11112222&phone=13699999999&owningUnit=%E6%89%80%E5%B1%9E%E5%8D%95%E4%BD%8D&address=%E7%8E%B0%E5%B1%85%E5%9C%B0%E5%9D%80&file=&mergencyeContacts=%5B%7B%22emergyUserName%22%3A%22%E5%BC%A0%E4%B8%89%22%2C%22emergyUserRelation%22%3A%22%E5%AD%90%E5%A5%B3%22%2C%22emergyUserContact%22%3A%2215966666666%22%7D%2C%7B%22emergyUserName%22%3A%22%E6%9D%8E%E5%9B%9B%22%2C%22emergyUserRelation%22%3A%22%E9%85%8D%E5%81%B6%22%2C%22emergyUserContact%22%3A%2215888888888%22%7D%5D&annex=http%3A%2F%2Ffile.chinaylzl.com%2Fpro%2Fcollege%2F2018%2F02%2F09%2F87b06f8d2b044614b62e144bd857ebd6.jpg%3Bhttp%3A%2F%2Ffile.chinaylzl.com%2Fpro%2Fcollege%2F2018%2F02%2F09%2F8bc89521eac34043967220ad9c173a2a.jpeg";
            int cardNumber=aa();
//            String addUser ="http://120.76.84.195:8034/assistBedCheckInRecord/insertAssistBedCheckInRecord?id=&name="+name+"&idcard="+idCard+"&sex=m&national=%E6%B1%89%E6%97%8F&birthday=1990-06-29&community=5109030202&contact=12626226262&address=%E5%AE%B6%E5%BA%AD%E4%BD%8F%E5%9D%80&emergency=%7B%22name%22%3A%22%E7%B4%A7%E6%80%A5%E8%81%94%E7%B3%BB%E4%BA%BA%22%2C%22phone%22%3A%2215526562562%22%7D&checkInTime=2018-05-17&bedNumber="+cardNumber+"&paymentCycle=1&uploadIdcardFront=http%3A%2F%2Ffile.chinaylzl.com%2Ftest%2FcheckInRecord%2F4.jpg&uploadIdcardBack=http%3A%2F%2Ffile.chinaylzl.com%2Ftest%2FcheckInRecord%2F2.jpg&uploadIdcardHold=http%3A%2F%2Ffile.chinaylzl.com%2Ftest%2FcheckInRecord%2F3.jpg&uploadReceipt=http%3A%2F%2Ffile.chinaylzl.com%2Ftest%2FcheckInRecord%2F5.jpg&uploadPermanent=http%3A%2F%2Ffile.chinaylzl.com%2Ftest%2FcheckInRecord%2F6.jpg&uploadCheckInAgreement=http%3A%2F%2Ffile.chinaylzl.com%2Ftest%2FcheckInRecord%2F7.jpg";
//            String UuniLogin="http://120.76.84.195:8034/checkUser?account=18181915310&password=123456";
            String UrlLogin="https://dev.fkhwl.com/webgis_test/login.html?loginAccount=18181915310&loginPasswd=95075dfedfe8f80ac6e45115918fd7f3&randomCode=323&loginType=2";
            HttpRequest HttpRequest=new HttpRequest();
            String LNcookie=HttpRequest.getTmpcookies(UrlLogin);
            System.out.println(LNcookie);
//            String a=HttpRequest.postMethod(addUser,LNcookie);
//            System.out.println(a);
//            String result=HttpRequest.Jsonvalue(a,"detail");
//            Assert.assertEquals("添加成功",result);





}


}
