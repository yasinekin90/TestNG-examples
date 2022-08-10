package test.day19;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_Screenshot extends TestBase {
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
        search.sendKeys("Nutella", Keys.ENTER);
        WebElement resultScreen= driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));

        String result=resultScreen.getText();
        System.out.println("result = " + result);
        Assert.assertTrue(result.contains("Nutella"),"nutella içermiyor");
        File file1=new File("TScreen1/webelement.png");
        File tempPage1=resultScreen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tempPage1,file1);
    }

}
