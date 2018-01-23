package Method;
import java.sql.*;

public class jdbc {
        private Connection conn = null;
        private PreparedStatement ps = null;
        private ResultSet rs = null;
        String sql = null;

        public void initDb() throws ClassNotFoundException, SQLException {
            //链接数据库
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://120.76.84.195:3306/qsheal_health_8_17", "root", "qsheal");
        }

//    public void getBranchIdByLogAccount(String idcard) throws SQLException{

//        //更新
//        sql="update assist_benefit_apply set publicity_end_time=now() where uid='"+getuid(idcard)+"' ";
//        ps=(PreparedStatement) conn.prepareStatement(sql);
//        ps.executeUpdate();

//    }
    public String getuid(String idcard) throws SQLException{
        //查询
        String uid="";
        sql="SELECT id FROM qsheal_health_new.user where idCard='"+idcard+"'";
        ps=(PreparedStatement) conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            uid=rs.getString(1);
        }
        return uid;
    }
        public void startTime() throws SQLException{
            String time="";
            sql="SELECT start_time from assist_pai_orders where  item_id=8761 and uid=(SELECT id from `user` where idCard='971513191701170177')  order by start_time DESC LIMIT 1";
            ps=(PreparedStatement) conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                time=rs.getString(1);
        }
                System.out.println(time);
    }
//    public static void main(String[] args) throws ClassNotFoundException, SQLException{
//        jdbc db=new jdbc();
//        db.initDb();
//        db.startTime();
//    }
}
