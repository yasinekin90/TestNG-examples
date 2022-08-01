package test.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DependsOnMethods {

    //todo
    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //    arama yapin ve aramanizin gerceklestigini Test edin
    // //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }


    @Test
    public void logoTest(){
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }

    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //    arama yapin ve aramanizin gerceklestigini Test edin
    @Test(dependsOnMethods ="logoTest")
    public void aramaTest(){

        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Nutella", Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("Nutella"),"Nutella bulunamadı");

    }
    // //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin
    @Test(dependsOnMethods = "aramaTest")
    public void firstProduct(){
        driver.findElement(By.xpath("(//span[@class=\"a-size-base-plus a-color-base a-text-normal\"])[1]")).click();
        WebElement price=driver.findElement(By.xpath("(//span[@class=\"a-size-mini olpWrapper\"])[2]"));
        System.out.println("price.getText() = " + price.getText());

        Assert.assertTrue(price.getText().contains("$14.99"));
    }


}
