package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.security.auth.kerberos.KerberosTicket;

public class C04_KeyboardActions extends TestBase {
    //todo
    //   sendKeys (): Öğeye bir dizi anahtar gönderir
    // keyDown (): Klavyede tuşa basma işlemi gerçekleştirir
    // keyUp (): Klavyede tuşu serbest bırakma işlemi gerçekleştirir





    //todo
    // https://www.amazon.com/ sayfasina gidelim
    // Arama kutusuna actions method’larine kullanarak samsung Apple IPHONE 12 yazdirin ve Enter’a basarak arama yaptirin
    // aramanin gerceklestigini test edin
     @Test
    public void amazon(){
         driver.get("https://www.amazon.com/");
// Arama kutusuna actions method’larine kullanarak samsung Apple IPHONE 12 yazdirin ve Enter’a basarak arama yaptirin
         WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
         Actions actions=new Actions(driver);
         actions.click(searchbox)
                 .keyDown(Keys.SHIFT)
                 .sendKeys("a")
                 .keyUp(Keys.SHIFT)
                 .sendKeys("pple")
                 .keyDown(Keys.SHIFT)
                 .sendKeys(" iphone")
                 .keyUp(Keys.SHIFT)
                 .sendKeys("12")
                 .sendKeys(Keys.ENTER).perform();

     }
}
