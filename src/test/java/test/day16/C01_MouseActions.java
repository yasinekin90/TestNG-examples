package test.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_MouseActions extends TestBase {
    //todo
    // Yeni bir class olusturalim: MouseActions1
   //    https://www.amazon.com/ adresine gidelim
 //    Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
 //    mouse’u bu menunun ustune getirelim
  //    “Create a list” butonuna basalim
 //    Acilan sayfada “Your Lists” yazisi oldugunu test edelim

    //ACTIONS
    ////todo
    //    //doubleClick (): Öğeye çift tıklama yapar
    //    //clickAndHold (): Fareyi serbest bırakmadan uzun tıklama yapar
    //    //dragAndDrop (): Öğeyi bir noktadan diğerine sürükler ve bırakır
    //    //moveToElement (): Fare işaretçisini öğenin üzerine gider
    //    //contextClick (): Fare üzerinde sağ tıklama yapar


 /*   @Test
    public void amazonList(){
        //    https://www.amazon.com/ adresine gidelim
    driver.get("https://www.amazon.com");
        //    Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //    mouse’u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement list= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(list).perform();

        //    “Create a list” butonuna basalim
        WebElement create= driver.findElement(By.linkText("Create a List"));
        //create.click();
        actions.click(create).perform();

        //    Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        System.out.println("driver.getTitle() = " + driver.getTitle());

        Assert.assertTrue(driver.getTitle().contains("Your List"),"your list sayfada yok");

    }*/

    @Test
    public void actions() throws InterruptedException {
        Actions actions=new Actions(driver);
        driver.get("https://webdriveruniversity.com/Actions/index.html#");

        WebElement dontRelease= driver.findElement(By.id("click-box"));
        String text=dontRelease.getText();
        String color=dontRelease.getAttribute("style");
        System.out.println("text1 = " + text);
        System.out.println("color 1= " + color);
        actions.clickAndHold(dontRelease).perform();
        text=dontRelease.getText();
        System.out.println("color2 = " + color);
        System.out.println("text2 = " + text);
        Thread.sleep(5000);
        actions.release().perform();
        text=dontRelease.getText();
        System.out.println("color3 = " + color);
        System.out.println("text3 = " + text);
    }

}
