package Tests.day11_htmlReports;

public class C01_HtmlReports {

    /*
        TestNG kendisi direkt rapor olusturmaz
        Avenstack depency sayesinde raporlar olusturabiliriz
        1- Avenstack depency pom.xml'e ekle
        2- avenstack raporlama icin 3 objeye ve bu objeleri ayarlamaya ihtiyac duyar
           her test method'u icin u islemleri tekrar tekrar yapmamak icin
           rapor almak istedigimiz class'larla TestBaserapor kullanacagiz

        3- Failed olan test method'u olursa
           ekran resmi cekmesi icin Reusable methods class'ina
           getScreenshot(String name)  ekledik

        4- @BeforeTest
           belirlenen tum class/package/method'lar calismaya baslamadan once bir kere calisir
           ve rapor icin istenen objeleri olusturup,
           bu objelerde yapilmasi gereken ayarlari yapar

           @Aftertest
           belirlenen tum class/package/method'lar calisip bittikten sonra
           bir kez calisir
           ve raporun kapanis islemlerini yapar

           @Aftermethod
           her test method'undan sonra calisir
           FAILED olan method varsa, ekran resmi alir

         5- Raporlu bir test method'u olusturmak icin
            - class'i  TestBaseRapor'a extends yapariz
            - normal class'i olusturup kodlarimizi yazariz
            - extentTest objesine deger atayip,
              raporda olmasini istedigimiz her aciklamayi
              extentTest objesi ile test method'una yazariz

     */
}
