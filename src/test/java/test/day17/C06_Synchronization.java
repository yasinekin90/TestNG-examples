package test.day17;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Synchronization extends TestBase {
    // https://the-internet.herokuapp.com/dynamic_controls sayfasina gidin
    // disable butonuna basin
    // disabled yazisinin ciktigini test edin

    @Test
    public void enabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()=\"Enable\"]")).click();
        // disable butonuna basin
      driver.findElement(By.xpath("//button[text()=\"Disable\"]")).click();
      String disabled=driver.findElement(By.id("message")).getText();

        Assert.assertTrue(disabled.equals("It's disabled!"),"It's disabled! yazmıyor");
    }
}
