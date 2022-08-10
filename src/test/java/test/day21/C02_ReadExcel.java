package test.day21;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);


        Iterator<Cell> cellIterator = row.cellIterator();

        for (Iterator<Cell> it = cellIterator; it.hasNext(); ) {
                Cell cell = it.next();
                System.out.println(cell);
            }

//    // ilk 20 ulkenin baskentlerinin turkce isimlerini yazdirin
        for (int i=0;i<21;i++){
            System.out.println("3.Satır = "+workbook.getSheet("Sayfa1").getRow(i).getCell(3));
            System.out.println("----------------------------------------------");
        }

    }
}
