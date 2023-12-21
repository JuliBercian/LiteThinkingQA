package pagesobjects.features;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pagesobjects.pages.GoogleHomePage;
import pagesobjects.pages.GoogleHomePageFactory;

public class GoogleSearch {

    WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com/");
    }

    @Test
    public void SeleniumWebDriverSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
        googleHomePage.searchGoogle("Selenium Web Driver");
        googleHomePage.isUserInSearchResult("Selenium Web Driver - Buscar con Google");
    }

    @Test
    public void FormulaOneSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage(webDriver);
        googleHomePage.searchGoogle("FormulaOne");
        googleHomePage.isUserInSearchResult("FormulaOne - Buscar con Google");
    }

    @Test
    public void SeleniumWebDriverSearchPageFactory() {
        GoogleHomePageFactory googleHomePageFactory = new GoogleHomePageFactory(webDriver);
        googleHomePageFactory.searchGoogle("Selenium Web Driver");
        googleHomePageFactory.isUserInSearchResult("Selenium Web Driver - Buscar con Google");
    }

    @Test
    public void FormulaOneSearchPageFactory() {
        GoogleHomePageFactory googleHomePageFactory = new GoogleHomePageFactory(webDriver);
        googleHomePageFactory.searchGoogle("FormulaOne");
        googleHomePageFactory.isUserInSearchResult("FormulaOne - Buscar con Google");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}