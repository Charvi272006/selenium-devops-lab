
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {

    @Test
    public void testMessage() throws Exception {

        ChromeOptions options = new ChromeOptions();

        String seleniumUrl = System.getenv().getOrDefault(
            "SELENIUM_URL",
            "http://localhost:4444/wd/hub"
        );

        WebDriver driver = new RemoteWebDriver(
            new URL(seleniumUrl),
            options
        );

        try {
            driver.get("data:text/html,"
                + "<html><body><h1 id='message'>"
                + "Hello Charvi Gowda, this is devops lab !!!"
                + "</h1></body></html>");

            String actual = driver.findElement(
                By.id("message")).getText();

            String expected =
                "Hello Charvi Gowda, this is devops lab !!!";

            assertEquals(expected, actual);

            System.out.println(actual);

        } finally {
            driver.quit();
        }
    }
}
