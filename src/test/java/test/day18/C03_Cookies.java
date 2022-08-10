package test.day18;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;
import java.util.stream.Collectors;

public class C03_Cookies extends TestBase {
//todo
// Yeni bir class olusturun : cookiesAutomation
// Amazon anasayfaya gidin
// tum cookie’leri listeleyin
// Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
//  ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
// ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
// olusturun ve sayfaya ekleyin
// eklediginiz cookie’nin sayfaya eklendigini test edin
// ismi skin olan cookie’yi silin ve silindigini test edin
// tum cookie’leri silin ve silindigini test edin

    @Test
    public void cookiesAutomation(){
        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // tum cookie’leri listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
       // tum cookie’leri listeleyin
        cookies.stream().forEach(System.out::println);
        // Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        Assert.assertTrue(cookies.size()>5,"the size of cookies are not greater than five");
        System.out.println("cookies.size() = " + cookies.size());
//  ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
// i18n-prefs=USD; expires=Cmt, 05 Ağu 2023 02:52:48 TRT; path=/; domain=.amazon.com

        String cookieValue="";
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("i18n-prefs")){
                System.out.println("cookie.getValue() = " + cookie.getValue());
                cookieValue=cookie.getValue();
            }
        }
        Assert.assertTrue(cookieValue.equals("USD"),"cookie value is not USD");

        // ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        // olusturun ve sayfaya ekleyin

        Cookie myCook=new Cookie("en sevdiğim cookie","çikolatalı");

        driver.manage().addCookie(myCook);
        cookies = driver.manage().getCookies();
        System.out.println("-".repeat(20)+"SECOND lİST"+"-".repeat(20));
        cookies.stream().forEach(System.out::println);
    // eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookies.contains(myCook),"eklediğimiz cookiesi içermiyor");

        // ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookie(driver.manage().getCookieNamed("skin"));
        System.out.println();
        cookies = driver.manage().getCookies();
        cookies.stream().forEach(System.out::println);
        // ismi skin olan cookie’yi silin ve silindigini test edin
        Assert.assertFalse(cookies.contains(driver.manage().getCookieNamed("skin")),"içinde skin var");

        // tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Set<Cookie>lastCook=driver.manage().getCookies();
        Assert.assertTrue(lastCook.size()==0,"içerigi tamamen silinemedi");
    }
}
