package test.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_iFrame {
    //todo
   /*
    //https://the-internet.herokuapp.com/iframe adresine gidin.
   // Bir metod olusturun: iframeTest
    //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve    konsolda  yazdirin.
    //Text Box’a “Merhaba Dunya!” yazin.
    //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve
       konsolda yazdirin
    */
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/iframe");

    }
    // Bir metod olusturun: iframeTest
    //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve    konsolda  yazdirin.
    @Test
    public void iframeTest(){
        WebElement text= driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(text.isDisplayed(),"Text görünmüyor");
        System.out.println("text.getText() = " + text.getText());

        //iframe e giriş yapıldı
        WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        //Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox= driver.findElement(By.tagName("p"));

        textBox.clear();
        textBox.sendKeys("Merhaba Dünya");

        //iframeden cıkıs yapılmalı
        driver.switchTo().parentFrame();

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve
        //konsolda yazdirin
       WebElement element= driver.findElement(By.xpath("(//a[@target=\"_blank\"])[2]"));
        softAssert.assertTrue(element.isDisplayed(),"selenium GöRÜLMÜYOR");
        System.out.println("element.getText() = " + element.getText());


        softAssert.assertAll();
    }
}
