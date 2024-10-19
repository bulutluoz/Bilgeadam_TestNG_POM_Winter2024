package Tests.day11_htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C05_TopluNegatifLoginTesti extends TestBaseRapor {


    // disardan parametre olarak yolladigimiz
    // email ve password ile giris yapilamadigini test edin

    @DataProvider
    public static Object[][] kullaniciBilgileriProvideri() {

        String[][] emailVePasswordler = { {"kemalDeneme@gmail.com","876543"}
                                        ,{ "hasanElma@gmail.com","874tyfg"}
                                        ,{ "yasarYasamaz@gmail.com","hgf3456"}};

        return emailVePasswordler;
    }



    @Test(dataProvider = "kullaniciBilgileriProvideri",groups = "raporluSmoke")
    public void negatifLoginTesti(String email, String password){
        extentTest = extentReports.createTest("Parametreli negatif login testi",
                "verilen "+ email +" ve " + password + " ile giris yapilamamali");

        // Kullanici testotomasyonu anasayfaya gider

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        // account linkine tiklar
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine tiklar");

        // kullanici verilen email'i girer
        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(email);
        extentTest.info("Verilen " + email +" degerini email olarak girer");

        // verilen password'u girer
        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(password);
        extentTest.info("Verilen " + password +" degerini password olarak girer");


        // login butonuna basarak login olmayi dener
        testotomasyonuPage.loginSayfasiSignInButonu.click();
        extentTest.info("login butonuna basarak login olmayi dener");

        // login olunamadigini test eder
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.pass("login olunamadigini test eder");


        // sayfayi kapatir
        extentTest.info("sayfayi kapatir");
    }
}
