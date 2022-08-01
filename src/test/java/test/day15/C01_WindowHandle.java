package test.day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import java.util.Set;


public class C01_WindowHandle {
    //todo
//    amazon.com a git
//    Sayfana handell değerini al
//    Yeni bir pencere aç
//    bestbuy.com git
//    yeni açılan pencerenin handel değerini al
//    sonra bütün handelların değerini al
//    şimdi yeni bir tab aç
//    facebook.com a git
//    amazon.com a geri dön
//    arama kısmına  Nutella yaz ve ara
//    sonra bestbuy.com geç, title  doğrula
//    Şimdi de facebook.com penceresine git
//    title  facebook.com olduğunu  doğrula

    WebDriver driver;
    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void handleWindow(){
        //    amazon.com a git
        // Sayfana handell değerini al
        driver.get("https://www.amazon.com");
        System.out.println("driver.getWindowHandle(amazon) = " + driver.getWindowHandle());
        String amazon= driver.getWindowHandle();
        //    Yeni bir pencere aç
        driver.switchTo().newWindow(WindowType.WINDOW);
         //    bestbuy.com git
        driver.get("https://www.bestbuy.com");
        //    yeni açılan pencerenin handel değerini al
        String bestBuy= driver.getWindowHandle();
        System.out.println("driver.getWindowHandle(bestbuy) = " + driver.getWindowHandle());
        //    sonra bütün handelların değerini al
        Set<String> handels=driver.getWindowHandles();

        System.out.println("bütün handel degerleri");
        System.out.println("handels.toString() = " + handels.toString());
       // handels.stream().forEach(System.out::println);

        //    şimdi yeni bir tab aç
//    facebook.com a git
        driver.switchTo().newWindow(WindowType.TAB);
        String facebook= driver.getWindowHandle();
        driver.get("https://www.facebook.com");

        //    amazon.com a geri dön
//    arama kısmına  Nutella yaz ve ara
        driver.switchTo().window(amazon);
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Nutella", Keys.ENTER);

        //    sonra bestbuy.com geç, title  doğrula
        driver.switchTo().window(bestBuy);
        String bestTitle= driver.getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(bestTitle.contains("bestbuy.com"),"bestbuy.com içermiyor");


        //    Şimdi de facebook.com penceresine git
        //    title  facebook.com olduğunu  doğrula

        driver.switchTo().window(facebook);


        System.out.println("driver.getTitle(facebook) = " + driver.getTitle());

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
