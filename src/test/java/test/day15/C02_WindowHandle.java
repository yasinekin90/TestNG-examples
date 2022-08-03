package test.day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

public class C02_WindowHandle {
    //todo
    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // ● Click Here butonuna basın.
    // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;
    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void heroku(){

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement onw= driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(onw.getText().equals("Opening a new window"),"Opening a new window değil");

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title= driver.getTitle();
        softAssert.assertEquals(title,"The Internet","sayfa baslıkları eşit değil");
        String windowhandle= driver.getWindowHandle();


        // ● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Set<String>handles=driver.getWindowHandles();



        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String newTab="";
        for (String each:handles) {
            if(!each.equals(windowhandle)){
                newTab=each;
            }
        }
        driver.switchTo().window(newTab);
        String newTitle= driver.getTitle();
           softAssert.assertEquals(newTitle,"New Window","başlık new window değil");


       // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String text=driver.findElement(By.tagName("h3")).getText();
        softAssert.assertEquals(text,"New Window","text esşit değil");


        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
            driver.switchTo().window(windowhandle);
        String title1= driver.getTitle();
        softAssert.assertEquals(title1,"The Internet","sayfa baslıkları eşit değil");

        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
