package features;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.TiendaEnLineaPage;

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
        TiendaEnLineaPage tiendaEnLineaPage = new TiendaEnLineaPage(webDriver);
        tiendaEnLineaPage.llenarUser("standard_user");
        tiendaEnLineaPage.llenarPass("secret_sauce");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
