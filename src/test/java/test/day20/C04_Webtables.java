package test.day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_Webtables extends TestBase {
//todo
//  1. Bir metod oluşturun: printData(int row, int column);
//  a. Satır(row) ve sütun(column) numarasını girdiğinizde,
//  printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
//  2. Baska bir metod daha oluşturun: printDataTest();
//  a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
//  b. Örnek: printData (3.5); =>
//  3. satır, 5. Sütundaki veriyi yazdırmalıdır.
    //* //tbody[3]//td[5]


    public void printData(int row, int column) throws InterruptedException {
        driver.get("https://editor.datatables.net/");
        Thread.sleep(5000);
        WebElement rowCol= driver.findElement(By.xpath("//tr["+row+"]//td["+column+"]"));
        System.out.println("rowCol.getText() = " + rowCol.getText());
    }

    @Test
    public void printDataTest() throws InterruptedException {

        printData(6,6);
        printData(5,3);
        printData(2,3);

    }

}
