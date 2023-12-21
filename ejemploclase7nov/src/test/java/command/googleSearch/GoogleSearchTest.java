package command.googleSearch;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    WebDriver webDriver;
    static String urlGoogle = "https://www.google.com/";

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        webDriver.get(urlGoogle);
    }

    @Test
    public void SeleniumWebDriverSearch() {
        GoogleSearchCommands.searchGoogle(webDriver, "Selenium Web Driver");
        GoogleSearchCommands.isUserInResults(webDriver, "Selenium Web Driver - Buscar con Google");
    }

    @Test
    public void FormulaOneSearch() {
        GoogleSearchCommands.searchGoogle(webDriver, "FormulaOne");
        GoogleSearchCommands.isUserInResults(webDriver, "FormulaOne - Buscar con Google");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
