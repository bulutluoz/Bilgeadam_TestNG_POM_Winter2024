package Tests.day10_TestNGFramework;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_YeniKullaniciOlusturma {


    @Test
    public void yeniKullaniciOlusturmaTesti(){

        // testotomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // account linkine tiklayin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        // SignUp linkine tiklayin
        testotomasyonuPage.signUpLinki.click();

        // form kisminda isim ve soyisim icin fake degerler girin
        // email ve password olarak configuration.properties dosyasinda verilen
        // toGecerliEmail ve toGecerliPassword degerlerini girin

        // tum bilgi kutularini tek tek locate etmek yerine
        // actions class'i ile tab yapip gecis yapacagiz

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        ReusableMethods.bekle(1);

        actions.click(testotomasyonuPage.signUpFormuFirstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"))
                .perform();

        // SignUp butonuna basin
        testotomasyonuPage.signUpFormuSignUpButonu.click();

        // kaydin olusturuldugunu test edin
        // kayit olusturulunca bizi login sayfasina yonlendiriyor
        // kaydin basarili oldugunu gormek icin login olalim
        // ve signout linkinin gorunur oldugunu test edelim

        testotomasyonuPage.loginSayfasiEmailKutusu
                            .sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        testotomasyonuPage.loginSayfasiPasswordKutusu
                            .sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        testotomasyonuPage.loginSayfasiSignInButonu
                            .click();

        Assert.assertTrue(testotomasyonuPage.logoutLinki.isDisplayed());

        // logout olun

        testotomasyonuPage.logoutLinki.click();

        // sayfayi kapatin

        ReusableMethods.bekle(5);
        Driver.quitDriver();
    }
}
