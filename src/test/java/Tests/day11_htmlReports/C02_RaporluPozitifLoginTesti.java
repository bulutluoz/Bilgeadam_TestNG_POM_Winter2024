package Tests.day11_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test(groups = {"Smoke", "kullanici E2E", "Regression"})
    public void pozitifLoginTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLinki
                .click();

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiSignInButonu
                .click();

        //6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(testotomasyonuPage.logoutLinki.isDisplayed());

        testotomasyonuPage.logoutLinki.click();


    }


}
