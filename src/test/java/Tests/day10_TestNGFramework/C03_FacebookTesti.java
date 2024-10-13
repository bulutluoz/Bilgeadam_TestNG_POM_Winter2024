package Tests.day10_TestNGFramework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_FacebookTesti {

    @Test
    public void faceboooktesti(){

        //1- https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");


        FacebookPage facebookPage = new FacebookPage();
        //   cookies kabul etmek gerekiyorsa, kabul edin
        facebookPage.cookiesKabulButonu.click();

        //2- POM’a uygun olarak email, sifre kutularini
        // ve giris yap butonunu locate edin


        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());


        facebookPage.loginButonu.click();

        //4- Basarili giris yapilamadigini test edin

        // giris yapilamadigini, email kutusunun hala gorunur olmasi ile yapabiliriz

        Assert.assertTrue(facebookPage.emailKutusu.isDisplayed());


        Driver.quitDriver();

    }
}
