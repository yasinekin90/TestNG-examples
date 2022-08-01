package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C01_Alerts {
    // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // ● Bir metod olusturun: acceptAlert
    //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
    // ● Bir metod olusturun: dismissAlert
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının“successfuly” icermedigini test edin.
    // ● Bir metod olusturun: sendKeysAlert
    // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass
    public void test(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
         softAssert=new SoftAssert();
    }
    @AfterClass
    public void tearDown(){
        softAssert.assertAll();
        driver.close();
    }
    // ● Bir metod olusturun: acceptAlert
    //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
    // result mesajının “You successfully clicked an alert” oldugunu test edin.
    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
        driver.switchTo().alert().accept();

        String text=driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();

            softAssert.assertTrue(text.equals("You successfully clicked an alert"),"Mesaj beklendiği gibi değil");
    }

    // ● Bir metod olusturun: dismissAlert
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının“successfuly” icermedigini test edin.
    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//button[@onClick=\"jsConfirm()\"]")).click();
        driver.switchTo().alert().dismiss();

        String resultMsg=driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();

        softAssert.assertTrue(resultMsg.contains("successfuly"),"mesaj successfully içermiyor");
        System.out.println("resultMsg = " + resultMsg);

    }
    // ● Bir metod olusturun: sendKeysAlert
    // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    // OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
   @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//button[@onClick=\"jsPrompt()\"]")).click();
        driver.switchTo().alert().sendKeys("YASİN EKİN");
        driver.switchTo().alert().accept();
       String resultMsg=driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();

       softAssert.assertTrue(resultMsg.contains("YASİN EKİN"),"isim görüntüleme başarısız");
       System.out.println("resultMsg = " + resultMsg);


   }

}
