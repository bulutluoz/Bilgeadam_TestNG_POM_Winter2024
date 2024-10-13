package Tests.day09_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_DependsOnMethods {

    /*
        Birbirine bagli test method'larinda
        bir A test method'u failed oldugunda
        calismasi A test method'una bagli olan diger method'lar da failed olacaktir

        Eger bu method'larin birbirine bagli oldugunu soylemezsek
        TestNG hepsini bagimsiz method'lar kabul eder
        A method'u failed olsa da
        diger method'lari calistirmayi dener

        Eger bu tur calismasi baska method'larin calisip PASSED olmasina bagli olan
        method'lar varsa
        dependsOnMethods ozelligi kullanilabilir

        dependsOnMethods bir siralama yontemi DEGILDIR
        sadece C dependsOnMethods D yazilmissa
        sira C method'una geldiginde, D'nin calisip passed oldugunu kontrol eder
        -- eger D calismamissa once onun calismasini saglar,
           D calisip PASSED olduktan sonra C calisir
        -- eger D calismis ve FAILED olmussa
           C calismayi IGNORE eder ve class'in calismasini bitirir

        Normalde bir test method'unu tek basina calistirabiliriz
        ANCAKKK eger C dependsOnMethods D yazilmissa
        ve siz sadece C method'unu calistirmak isterseniz
        C method'u bagli oldugu D method'unun calismasini SAGLAR,
        D calisip PASSED olursa, C method'u calismaya baslar

        Bu kural 2 @Test method'u icin gecerlidir
        3 veya daha fazla @Test method'u olursa bu sekilde calistirmaz

     */


    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


    @Test
    public void anasayfaTesti(){
        // 1- testotomasyonu anasayfaya gidip title'in "Test otomasyonu" icerdigini test edin

        driver.get("https://www.testotomasyonu.com");

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){
        // 2- phone icin arama yapin ve urun bulunbildigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);

        String unExpectedAramaSonucu = "0 Products Found";

        String actualAramaSonucu = driver.findElement(By.className("product-count-text"))
                .getText();

        Assert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu);


    }

    @Test(dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimTesti(){
        // 3- ilk urunu tiklayin ve acilan sayfadaki urun isminde
        //    case sensitive olmadan "phone" gectigini test edin

        driver.findElement(By.xpath(" (//*[@class='prod-img'])[1]"))
                .click();

        String expectedIsimIcerigi = "phone";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"))
                .getText()
                .toLowerCase();


        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));

    }

}
