package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    //todo
    // https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //  Cizili alan uzerinde sag click yapalim
    // Alert’te cikan yazinin “You selected a context menu” oldugunu  test edelim.
    // Tamam diyerek alert’I kapatalim
    // Elemental Selenium linkine tiklayalim
    // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void actions2(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //  Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement hotspot= driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotspot).perform();
        // Alert’te cikan yazinin “You selected a context menu” oldugunu  test edelim.
        String text = driver.switchTo().alert().getText();
        Assert.assertTrue(text.equals("You selected a context menu"),"yazı eşleşmiyor");
        // Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        String page1=driver.getWindowHandle();
        WebElement elemental_selenium = driver.findElement(By.linkText("Elemental Selenium"));
         elemental_selenium.click();
        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> pagehandles=driver.getWindowHandles();
        String page2="";
        for (String each:pagehandles) {
            if(!each.equals(page1)){
                page2=each;
            }
        }
        driver.switchTo().window(page2);
        String elemental=driver.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(elemental.equals("Elemental Selenium"),"yazı eşleşmiyor");


    }
}
