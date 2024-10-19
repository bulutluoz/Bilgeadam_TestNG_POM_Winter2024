package Tests.day11_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluNegatifLoginTesti extends TestBaseRapor {


    @Test(groups = {"raporluSmoke"})
    public void gecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz password testi",
                "Gecersiz password, gecerli username ile giris yapilamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3- gecerli username, gecersiz password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Kullanici sifresi olarak gecersiz password girer");


        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSignInButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6- sayfayi kapatin
        extentTest.info("Window'u kapatir");

    }

    @Test(groups = {"raporluSmoke"})
    public void gecersizEmailTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Testi",
                "Kullanici gecersiz email ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3- gecersiz username, gecerli password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("Kullanici email'i olarak gecersiz email girer");


        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");


        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSignInButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");


        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6- sayfayi kapatin
        extentTest.info("Window'u kapatir");
    }

    @Test(groups = {"raporluSmoke"})
    public void gecersizEmailGecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Gecersiz Password Testi",
                "Kullanici gecersiz email ve gecersiz password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3- gecersiz username, gecersiz password girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("Kullanici email'i olarak gecersiz email girer");

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Kullanici sifresi olarak gecersiz password girer");


        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSignInButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");


        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6- sayfayi kapatin
        extentTest.info("Window'u kapatir");

    }



}
