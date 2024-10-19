package Tests.day11_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluNegatifLoginTesti extends TestBaseRapor {


    @Test(groups = {"Smoke", "Regression"})
    public void gecersizPasswordTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();

        //3- gecerli username, gecersiz password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSignInButonu
                .click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        //6- sayfayi kapatin


    }

    @Test(groups = {"Smoke", "kullanici E2E"})
    public void gecersizEmailTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();

        //3- gecersiz username, gecerli password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSignInButonu
                .click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        //6- sayfayi kapatin

    }

    @Test(groups = {"Smoke", "Regression", "kullanici E2E"})
    public void gecersizEmailGecersizPasswordTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();

        //3- gecersiz username, gecersiz password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSignInButonu
                .click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        //6- sayfayi kapatin


    }



}
