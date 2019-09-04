package tr.gov.tubitak.bilgem.yte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class TranslatorService {

    static String translate(String sourceLang, String targetLang, String text) {
        String url = "https://translate.google.com/#view=home&op=translate&sl=" + sourceLang + "&tl=" + targetLang + "&text=" + text;
        System.setProperty("webdriver.chrome.driver", "/Users/fatihsaracoglu/IdeaProjects/text-to-speech/src/main/java/tr/gov/tubitak/bilgem/yte/driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver wd = new ChromeDriver(options);
        wd.get(url);
        WebElement webElement = wd.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div/span[1]/span"));
        return webElement.getText();
    }
}
