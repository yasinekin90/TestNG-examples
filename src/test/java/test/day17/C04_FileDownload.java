package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //todo
    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    // 2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    // 3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    // - https://the-internet.herokuapp.com/download adresine gidelim.
    // - code.txt dosyasını indirelim
    // 4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void isExist(){
     String pathText=System.getProperty("user.home")+"\\Downloads\\test.txt";
        System.out.println("pathText = " + pathText);
        Assert.assertTrue(Files.exists(Paths.get(pathText)),"Dosya indirilmemiş");
    }

    @Test
    public void downloadTest(){
        // - https://the-internet.herokuapp.com/download adresine gidelim.
     driver.get("https://the-internet.herokuapp.com/download");
        // - test.txt dosyasını indirelim
          driver.findElement(By.linkText("test.txt")).click();
    }

}
