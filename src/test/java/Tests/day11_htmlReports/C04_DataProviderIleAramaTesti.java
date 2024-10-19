package Tests.day11_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C04_DataProviderIleAramaTesti extends TestBaseRapor {


    // ayni testi phone, java, dress, shoe, suitcase, apple icin yapin


    /*
        Eger bir test method'unun farkli degerler icin
        tekrar tekrar calismasini istersek
        Data Provider kullanabiliriz

        1- test method'unu parametre ile calisabilecek sekilde duzenle

        2- test method'una bir data provider tanimlayin

        3- provider isminin uzerine gelip, create provider deyin

        4- Olusturulan data provider MUTLAKA 2 katli bir array dondurmelidir
           bize gondermesini istedigimiz degerleri
           2 katli bir array olarak olusturup
           return kismina olusturdugumuz 2 katli array ismini yazalim
     */

    @DataProvider
    public static Object[][] aranacakKelimeProvideri() {

        String[][] aranacakKelimelerArrayi = {{"phone"}, {"java"}, {"dress"},
                {"shoe"}, {"suitcase"}, {"apple"}};

        return aranacakKelimelerArrayi;
    }


    @Test(dataProvider = "aranacakKelimeProvideri")
    public void aramaTesti( String aranacakKelime ){
        extentTest = extentReports.createTest(aranacakKelime+" arama testi",
                "Arama sonucunda urun bulanabilmeli");

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        // phone icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
        extentTest.info(aranacakKelime+" icin arama yapar");

        // arama sonucunda urun bulunabildigini test edin

         // arama sonucunda urun bulunabildi ise
         // sonuc yazisi "0 Products Found" a esit olmaz

        Assert.assertNotEquals(testotomasyonuPage.aramaSonucuYaziElementi.getText() ,
                                ConfigReader.getProperty("toBulunamadiSonucu"));
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");

        // sayfayi kapatin
        extentTest.info("sayfayi kapatir");



    }
}
