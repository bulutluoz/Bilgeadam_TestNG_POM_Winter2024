package Tests.day10_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C09_SoftAssert {

    /*
        TestNG JUnit'deki Assertions class'i ile ayni islevi yapan Assert class'ina sahiptir
        ikisi arasindaki tek fark JUnit'de once expected, sonra actual oluyordu,
        TestNG'de ise once actual, sonra expected


        TestNG assertion ile ilgili JUnit'de olmayan bir alternatif daha sunar.
        Eger softAssert ile test yaparsaniz
        softAssert.assertAll() diyene kadar, yapilan assertion'lar failed olsa bile
        kod calismaya devam eder.
        assertAll() dendiginde yapilan TUM ASSERTION'lar raporlanir ve
        eger failed olan assertion varsa, kodun calismasi
        assertAll() satirinda durur.

        Artilar ve eksiler

        - softAssert kullanirsak tek calistirmada tum hatalari gorebiliriz,
          hardAssert ilk failed olan assertion'da durdugu icin, sonraki assertion'larin sonucunu bilemeyiz
          tekrar tekrar calistirmak gerekebilir

        - softAssert assertAll()'a kadar gittigi icin tum hatalari toplu olarak
          assertAll()'un satirinda verir, Eger hatalari kolay bulmak ve duzeltmek isterseniz
          softAssert ile yapilan her assertion'a aciklama eklemeniz gerekir

     */

    @Test
    public void aramaTest(){

        // 1- testotomasyonu anasayfaya gidip title'in "Test otomasyonu" icerdigini test edin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik),"51.satir, anasayfa title'i beklenenden farkli");

        // 2- phone icin arama yapin ve urun bulunbildigini test edin

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        ReusableMethods.bekle(1);

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = testotomasyonuPage.aramaSonucuYaziElementi.getText();
        softAssert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu,"62.satir, beklenmeyen arama sonucu bulundu");


        // 3- ilk urunu tiklayin ve acilan sayfadaki urun isminde
        //    case sensitive olmadan "phone" gectigini test edin

        testotomasyonuPage.bulunanUrunElementleriList
                            .get(0)
                            .click();

        String expectedIsimIcerigi = "phone";
        String actualIsim = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        softAssert.assertTrue(actualIsim.contains(expectedIsimIcerigi),"77.satir, urun isminde aranan kelime yok");

        softAssert.assertAll(); // yaptigin tum assertion'lari raporla

        Driver.quitDriver();

    }
}
