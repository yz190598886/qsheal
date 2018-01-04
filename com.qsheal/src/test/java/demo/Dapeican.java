package demo;
import org.junit.Test;
public class Dapeican {
    @Test
    public void login() {
        TestPost ok = new TestPost();
        try {
            ok.getResoucesByLoginCookies();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}