package test.day17;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExists {
    @Test
    public void testFilePath(){

        //kendi bilgisayarımzıın kullanıcı yolunu verir
        System.getProperty("user.home");
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));


        String path=System.getProperty("user.home")+"\\Desktop\\Deneme1\\appium.xlsx";

        System.out.println("path = " + path);

        System.out.println("Files.exists(Paths.get(path)) = " + Files.exists(Paths.get(path)));

        //bir dosya içerisindeki dinamik yolu bize verir
        System.getProperty("user.dir");
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        String pathPomXml=System.getProperty("user.dir")+"\\pom.xml";

        System.out.println("pathPomXml = " + pathPomXml);

        Assert.assertTrue(Files.exists(Paths.get(pathPomXml)),"pom.xml yoktur");

    }
}
