package features;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TiendaEnLinea {

    WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.saucedemo.com/");
    }

    @Test
    public void Autenticacion() {
        TiendaEnLinea tiendaEnLinea = new TiendaEnLinea();
        tiendaEnLinea.Autenticacion();
        // tiendaEnLinea.searchGoogle("Selenium Web Driver");
        // tiendaEnLinea.isUserInSearchResult("Selenium Web Driver - Buscar con Google");
    }




    @After
    public void tearDown() {
        webDriver.quit();
    }

}
