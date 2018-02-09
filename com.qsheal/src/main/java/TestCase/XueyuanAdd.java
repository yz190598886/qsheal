package TestCase;

import Method.HttpRequest;
import Method.IdCard;
import org.junit.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XueyuanAdd {
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
        public void addUser() throws IOException {
            String name=name();
            String idCard=idcard();
            String addUser="http://120.76.84.195:8087/student/add?IDTypeId=1&IDNumber="+idCard+"&name="+name+"&nationId=40&partiesId=41&degreeId=49&degreeValueId=43&duty=%E8%81%8C%E5%8A%A1&title=%E8%81%8C%E7%A7%B0&domicileAddress=%E6%88%B7%E7%B1%8D%E5%9C%B0%E5%9D%80&contact=11112222&phone=13699999999&owningUnit=%E6%89%80%E5%B1%9E%E5%8D%95%E4%BD%8D&address=%E7%8E%B0%E5%B1%85%E5%9C%B0%E5%9D%80&file=&mergencyeContacts=%5B%7B%22emergyUserName%22%3A%22%E5%BC%A0%E4%B8%89%22%2C%22emergyUserRelation%22%3A%22%E5%AD%90%E5%A5%B3%22%2C%22emergyUserContact%22%3A%2215966666666%22%7D%2C%7B%22emergyUserName%22%3A%22%E6%9D%8E%E5%9B%9B%22%2C%22emergyUserRelation%22%3A%22%E9%85%8D%E5%81%B6%22%2C%22emergyUserContact%22%3A%2215888888888%22%7D%5D&annex=http%3A%2F%2Ffile.chinaylzl.com%2Fpro%2Fcollege%2F2018%2F02%2F09%2F87b06f8d2b044614b62e144bd857ebd6.jpg%3Bhttp%3A%2F%2Ffile.chinaylzl.com%2Fpro%2Fcollege%2F2018%2F02%2F09%2F8bc89521eac34043967220ad9c173a2a.jpeg";
            String UuniLogin="http://120.76.84.195:8087/checkUser?mobile=admin_test&password=158743";
            HttpRequest HttpRequest=new HttpRequest();
            String LNcookie=HttpRequest.getTmpcookies(UuniLogin);
            System.out.println(LNcookie);
            String a=HttpRequest.postMethod(addUser,LNcookie);
            System.out.println(a);
            String result=HttpRequest.Jsonvalue(a,"detail");
            Assert.assertEquals("添加成功",result);





}


}
