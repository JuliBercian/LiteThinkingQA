package features;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebElement inputSearch = webDriver.findElement(By.id("APjFqb"));
        inputSearch.clear();
        inputSearch.sendKeys("Selenium Web Driver");

        WebElement btnSearch = webDriver.findElement(By.name("btnK"));
        
        assertEquals("El titulo es el correcto", "Selenium Web Driver - Buscar con Google", webDriver.getTitle());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}