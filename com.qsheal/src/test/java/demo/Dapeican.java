package demo;
import org.junit.*;

public class Dapeican {
    @Before
    public void Start(){
        System.out.println("开始-------------------------");
    }
    @Test
    public void login() {
        TestPost ok = new TestPost();
        try {
             ok.getResoucesByLoginCookies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @After
    public void Over (){
        System.out.println("结束-------------------------");
    }
}