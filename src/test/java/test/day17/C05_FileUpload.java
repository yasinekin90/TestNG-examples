package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    //todo
    // https://the-internet.herokuapp.com/upload adresine gidelim
    // chooseFile butonuna basalim
    // Yuklemek istediginiz dosyayi secelim.
    // Upload butonuna basalim.
    // “File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void upload(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile= driver.findElement(By.id("file-upload"));
        // Yuklemek istediginiz dosyayi secelim.
        String property = System.getProperty("user.home")+"\\Desktop\\Deneme1\\appium.xlsx";
        chooseFile.sendKeys(property);
        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        // “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploaded=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploaded.isDisplayed(),"File Uploaded! görüldü");
    }
}
