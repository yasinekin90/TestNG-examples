package test.day21;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel {
    //todo
    // ulkeler exceline 5.sutun olarak NUFUS sutunu ekleyelim
    // 4.satirdaki ulkenin nufusunu 5000 yapalim

    @Test
    public void writeTest() throws IOException {
        //1. adım path almak
        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        //2. adım dosyanın kopyasını olusturmak
        Workbook workbook= WorkbookFactory.create(fis);
        //3.adım dosyaya yazmak
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        workbook.getSheet("Sayfa1").getRow(4).createCell(4).setCellValue("5000");
        //4.satirdaki ulkenin nufusunu 5000 yapalim
        FileOutputStream fos=new FileOutputStream(path);
        workbook.write(fos);

    }
}
