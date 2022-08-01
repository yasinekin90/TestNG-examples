package test.day11;

import org.testng.annotations.Test;

public class C01_Notations1 {

    @Test (priority = 5)
    public void youtubeTest(){
        System.out.println("youtube testi ");
    }
    @Test (priority = 7)
    public void bestbuyTest(){
        System.out.println("bestbuy testi ");
    }
    @Test (priority = 11)
    public void amazonTest(){
        System.out.println("amazon testi ");
    }
}
