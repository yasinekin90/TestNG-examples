package test.day22;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test01() throws IOException {
        String path="src/test/java/resources/veriler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        //Exceli oku
        Workbook workbook= WorkbookFactory.create(fis);
        FileOutputStream fos=new FileOutputStream(path);
        //çalısma sayfasını seçelim
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("Yorumlar");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("100");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("50");
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("25");

        //excelde satır silme
        Sheet sheet= workbook.getSheet("Sayfa1");
       /* Row silinecekSatir=sheet.getRow(3);
        sheet.removeRow(silinecekSatir);
        */
        //silinecek hücre
        Cell silinecekhücre=sheet.getRow(0).getCell(2);

        sheet.getRow(0).removeCell(silinecekhücre);
        workbook.write(fos);
        workbook.close();
        fos.close();
        fis.close();
    }
}
