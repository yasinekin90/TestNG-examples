package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Heroku {

    //todo
    /*https://the-internet.herokuapp.com/iframe siteye gidilsin
      Dünyanın Bütün Denizleri,textboxa yazılsın.
       Yazı kalınlığı Bold Olsun
        Yazılan yazı silisin
      Ve "Hollandanın nufusu 8 milyon" 7 kere yazılsn.
Yazılan yazı ortalansın.
Element Selenium Tıklansın.
"Sauce Labs" yazısının sonuna "box" eklenerek konsola yazılsın.*/

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void herokuTextBox() throws InterruptedException {
        WebElement iframe= driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(iframe);
        WebElement textbox= driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
        textbox.clear();
        driver.switchTo().parentFrame();

        // Yazı kalınlığı Bold Olsun
        driver.findElement(By.xpath("(//span[@class=\"tox-icon tox-tbtn__icon-wrap\"])[3]")).click();
        Thread.sleep(2000);

        driver.switchTo().frame(iframe);

        // Dünyanın Bütün Denizleri,textboxa yazılsın.
        textbox.sendKeys("Dünyanın Bütün Denizleri");
        Thread.sleep(3000);

        // Yazılan yazı silisin
        textbox.clear();
        Thread.sleep(2000);
        //"Hollandanın nufusu 8 milyon" 7 kere yazılsn.Yazılan yazı ortalansın.

        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("(//span[@class=\"tox-icon tox-tbtn__icon-wrap\"])[6]")).click();
        Thread.sleep(2000);

        driver.switchTo().frame(iframe);
        for (int i = 0; i <7 ; i++) {
            textbox.sendKeys("Hollandanın nufusu 8 milyon", Keys.ENTER);
        }
        Thread.sleep(2000);

        //Element Selenium Tıklansın.
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Elemental Selenium")).click();


      //  "Sauce Labs" yazısının sonuna "box" eklenerek konsola yazılsın.
      /*  WebElement sauce= driver.findElement(By.xpath("//a[@class=\"link\"]"));
        String saucelabs= sauce.getText();
        String box="Box";
        System.out.println(saucelabs+box);*/

    }
}
