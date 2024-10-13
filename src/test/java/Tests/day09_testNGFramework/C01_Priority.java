package Tests.day09_testNGFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;

public class C01_Priority {

    /*
        TestNG siralama icin bizim etkimiz olmazsa
        @Test method'larini isim sirasina gore calistirir

        Eger istenirse @Test method'larina priority tanimlanarak
        calisma siralamasi degistirilebilir
        TestNG priority degerlerini kucukten buyuge dogru calistirir

        Eger bir @Test method'una priority degeri atanmazsa
        deger 0 olarak kabul edilir

        Eger priority degeri esit olanlar varsa
        esitler kendi aralarinda harf sirasina gore calisir
        esit olmayanlar ise priority degerine gore calisirlar
     */
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test(priority = -14)
    public void testotomasyonuTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }

    @Test // priority = 0
    public void youtubeTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }

    @Test // priority = 0
    public void bestbuyTesti(){

        // bestbuy.com anasayfaya gidin
        driver.get("https://www.bestbuy.com");

        // url'in bestbuy icerdigini test edin

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }


}
