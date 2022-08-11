package test.day22;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadExcel {

    @Test
    public void test01() throws IOException {
        String path="src/test/java/resources/veriler.xlsx";
        FileInputStream fis=new FileInputStream(path);

        //Exceli oku
        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet (sayfa seçimi)
        Sheet sheet=workbook.getSheet("Sayfa1");

        //Sayfadan sonra satır seçimi
        Row row=sheet.getRow(0);
   /*     Cell cell=row.getCell(0);
        Cell cell1=row.getCell(1);
        Cell cell2=row.getCell(2);
        System.out.println("cell.toString() = " + cell.toString());
        System.out.println("cell.toString() = " + cell1.toString());
        System.out.println("cell.toString() = " + cell2.toString());*/
        for (int i = 0; i <row.getLastCellNum() ; i++) {
            System.out.println("row.getCell(i).toString() = " + row.getCell(i).toString());
        }
        System.out.println("row.getLastCellNum() = " + row.getLastCellNum());
        //içerisinde data olan satır sayısı
        int satirSayisi=sheet.getPhysicalNumberOfRows();
        System.out.println("satirSayisi = " + satirSayisi);



        fis.close();
        workbook.close();

    }

}
