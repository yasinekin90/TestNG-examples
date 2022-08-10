package test.day19;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenShotKlasoru extends TestBase {
    //todo//amazona gidin
    //  //3 farkli test methodu ile java, honey ve elma aratip
    //    //sonuc sayfasini screenshot'i kaydedin

    @Test
    public void javaTest() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        //1-Önce obje olustur

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("java", Keys.ENTER);
        screenShot();

    }
    @Test
    public void elmaTest() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        //1-Önce obje olustur

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("elma", Keys.ENTER);
        screenShot();
    }
    @Test
    public void honeyTest() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        //1-Önce obje olustur

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("honey", Keys.ENTER);
        screenShot();
    }
}
