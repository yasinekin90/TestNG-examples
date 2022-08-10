package test.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    //todo
    // Yeni Class olusturun ActionsClassHomeWork
    //    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //    //2- Hover over Me First" kutusunun ustune gelin
    //    //3- Link 1" e tiklayin
    //    //4- Popup mesajini yazdirin
    //    //5- Popup'i tamam diyerek kapatin
    //    //6- “Click and hold" kutusuna basili tutun
    //    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //    //8- “Double click me" butonunu cift tiklayin

    @Test
    public void test02() throws InterruptedException {
        //    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions=new Actions(driver);
        //    //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverFirst = driver.findElement(By.xpath("(//button[@class=\"dropbtn\"])[1]"));
        actions.moveToElement(hoverFirst).perform();

        //    //3- Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.linkText("Link 1"));
       link1.click();
        //    //4- Popup mesajini yazdirin
        String text = driver.switchTo().alert().getText();
        System.out.println("text = " + text);
        //    //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //    //6- “Click and hold" kutusuna basili tutun
        WebElement click= driver.findElement(By.id("click-box"));
        actions.scrollToElement(click).perform();
        actions.clickAndHold(click).perform();
        Thread.sleep(5000);
        //    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("click.getText() = " + click.getText());
        actions.release(click).perform();

        WebElement doublee= driver.findElement(By.id("double-click"));
        actions.doubleClick(doublee).perform();


    }
}
