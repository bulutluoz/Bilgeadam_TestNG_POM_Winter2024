package Tests.day10_TestNGFramework;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_LoginPortal {

    @Test
    public void loginPortalTesti(){

        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("webUniUrl"));
        ReusableMethods.bekle(1);

        WebUniPage webUniPage = new WebUniPage();
        //2."Login Portal" a  kadar asagi inin

        /*
            Eger login portal yazisi gorunuyorsa
            ortalamak icin js executor kullanabiliriz

            Eger login portal yazisi gorunmuyorsa
            actions ile pagedown yapabiliriz
         */

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",webUniPage.loginPortalElementi);

        //Actions actions = new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.PAGE_DOWN).perform();

        //3."Login Portal" a tiklayin
        webUniPage.loginPortalElementi
                    .click();

        //4.Diger window'a gecin
        ReusableMethods.switchToWindowTitle(Driver.getDriver(),"WebDriver | Login Portal");

        Faker faker = new Faker();
        //5."username" ve  "password" kutularina fake deger yazdirin
        webUniPage.usernameKutusu
                    .sendKeys(faker.name().username());

        webUniPage.passwordKutusu
                    .sendKeys(faker.internet().password());

        //6."login" butonuna basin
        webUniPage.loginSayfasiLoginButonu
                    .click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedAlertYazisi = ConfigReader.getProperty("webUniAlertYazi");
        String actualAlertYazisi = Driver.getDriver()
                                            .switchTo().alert()
                                            .getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver()
                .switchTo().alert()
                .accept();

        //9.Ilk sayfaya geri donun
        ReusableMethods.switchToWindowTitle(Driver.getDriver(),"WebDriverUniversity.com");

        //10.Ilk sayfaya donuldugunu test edin

        String expectedTitle = "WebDriverUniversity.com";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        ReusableMethods.bekle(1);
        Driver.quitDriver();

    }
}
