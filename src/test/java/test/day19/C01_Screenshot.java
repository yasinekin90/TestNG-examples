package test.day19;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {

    //TakesScreenshot ts = (TakesScreenshot) driver;
    //        File tumResim = new File(pathname:"target/ekranResmi/tumSayfa");
    //        File resimGecici = ts.getScreenshotAs(OutputType.FILE);
    //        FileUtils.copyFile(resimGecici,tumResim);
//todo
// amazon anasayfaya gidin
// amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
// Nutella icin arama yapin
// sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin

    @Test
    public void testScreen() throws IOException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
         //1-Önce obje olustur
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        //2-kaydedeceğimiz dosyayı olustur
        File file=new File("TScreen/allpage.png");
        //3-geçici dosya olusturup screenshot ile screen alalım
        File tempPage=takesScreenshot.getScreenshotAs(OutputType.FILE);
        //4-geçicideki dosyayı asıl yerine alacağız
        FileUtils.copyFile(tempPage,file);

        // Nutella icin arama yapin
        WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
        //search.sendKeys("Nutella", Keys.ENTER);
    }
}
