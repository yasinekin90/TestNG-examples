package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {
    //todo
    //  https://html.com/tags/iframe/ sayfasina gidelim
//   video’yu gorecek kadar asagi inin
//  videoyu izlemek icin Play tusuna basin
//   videoyu calistirdiginizi test edinü

    @Test
    public void test01(){
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);

        //   video’yu gorecek kadar asagi inin
        WebElement element = driver.findElement(By.xpath("//div[@class=\"render\"]"));
        actions.scrollToElement(element).perform();
        /*
    actions.
            sendKeys(Keys.PAGE_DOWN).
            sendKeys(Keys.PAGE_DOWN).
            perform(); */

        //  videoyu izlemek icin Play tusuna basin
      WebElement iframe= driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
        driver.switchTo().frame(iframe);
        WebElement element1 = driver.findElement(By.xpath("//button[@aria-label=\"Oynat\"]"));
        actions.click(element1).perform();

        //   videoyu calistirdiginizi test edinü
        WebElement duraklat= driver.findElement(By.xpath("//button[@title=\"Duraklat (k)\"]"));
        Assert.assertTrue(duraklat.isEnabled(),"video çalışmıyor");
    }
}
