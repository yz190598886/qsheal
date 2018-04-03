package appiumTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

public class Demo1 {
    protected AppiumDriver<AndroidElement> driver;
    @BeforeClass
    public  void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");//appium做自动化
//        cap.setCapability("app", "C:\\qqq.apk");//安装apk
//    cap.setCapability("browserName", "chrome");//设置HTML5的自动化，打开谷歌浏览器
        cap.setCapability("deviceName", "vivi X7");//设备名称
        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "5.1.1"); //安卓操作系统版本
        cap.setCapability("udid", "36766be9"); //设备的udid (adb devices 查看到的)
        cap.setCapability("appPackage", "com.qs.pg");//被测app的包名
        cap.setCapability("appActivity", ".ui.activity.StartActivity");//被测app的入口Activity名称
        cap.setCapability("unicodeKeyboard", "True"); //支持中文输入
        cap.setCapability("resetKeyboard", "True"); //支持中文输入，必须两条都配置
        cap.setCapability("noSign", "True"); //不重新签名apk
//        cap.setCapability("newCommandTimeout", "30"); //没有新命令，appium30秒退出
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);//把以上配置传到appium服务端并连接手机
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//隐式等待
    }
    public void clearText(){

   }
    @Test
    public void  doOne() {

//通过id定位元素
        driver.findElement(By.id("com.qs.pg:id/et_account")).clear();
        driver.findElement(By.id("com.qs.pg:id/et_account")).sendKeys("827685");
        driver.findElement(By.id("com.qs.pg:id/et_pwd")).clear();
        driver.findElement(By.id("com.qs.pg:id/et_pwd")).sendKeys("158743");
        driver.findElement(By.id("com.qs.pg:id/login_btn")).click();
        driver.findElement(By.id("com.qs.pg:id/rb_mine")).click();
        driver.findElement(By.id("com.qs.pg:id/rb_MyInfo")).click();
    }
    @Test
    public void exit(){
        driver.findElement(By.id("com.qs.pg:id/ActionBar_Iv_Back")).click();
        driver.findElement(By.id("com.qs.pg:id/dialog_ensure")).click();
        String denglu=driver.findElement(By.id("com.qs.pg:id/login_btn")).getText();
        Assert.assertEquals( "登录",denglu);
    }

    @AfterClass
    public void  tearDown() {
        driver.quit();
    }
    }

