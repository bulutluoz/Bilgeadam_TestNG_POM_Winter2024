package Tests.day10_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_PageClassKullanimi {

    /*
        POM de locate'ler page class'larinda olur
        ve page class'lari obje olusturularak kullanilir
     */

    @Test
    public void aramaTest(){

        // 1- testotomasyonu anasayfaya gidip title'in "Test otomasyonu" icerdigini test edin

        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // 2- phone icin arama yapin ve urun bulunbildigini test edin

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        ReusableMethods.bekle(1);

        String unExpectedAramaSonucu = "0 Products Found";

        String actualAramaSonucu = testotomasyonuPage.aramaSonucuYaziElementi.getText();

        Assert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu);


        // 3- ilk urunu tiklayin ve acilan sayfadaki urun isminde
        //    case sensitive olmadan "phone" gectigini test edin

        testotomasyonuPage.bulunanUrunElementleriList
                            .get(0)
                            .click();

        String expectedIsimIcerigi = "phone";
        String actualIsim = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                .getText()
                                                .toLowerCase();

        Assert.assertTrue(actualIsim.contains(expectedIsimIcerigi));

        Driver.quitDriver();

    }
}
