package features;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.TiendaEnLineaPage;
import pages.TiendaEnLineaPageFactory;

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
    public void CompraSauceDemo() {
        TiendaEnLineaPage tiendaEnLineaPage = new TiendaEnLineaPage(webDriver);
        tiendaEnLineaPage.ingresarTiendaEnLinea("standard_user", "secret_sauce");
        tiendaEnLineaPage.puntoControlOne("https://www.saucedemo.com/inventory.html");
        tiendaEnLineaPage.seleccionarProductos();
        tiendaEnLineaPage.checkOut();
        tiendaEnLineaPage.puntoControlTwo("https://www.saucedemo.com/checkout-step-one.html");
        tiendaEnLineaPage.enviarDatosAdicional("JULISSA", "BERCIAN", "EL SALVADOR");
        tiendaEnLineaPage.puntoControlThree("https://www.saucedemo.com/checkout-step-two.html");
        tiendaEnLineaPage.finCompra();
        tiendaEnLineaPage.puntoControlFour("https://www.saucedemo.com/checkout-complete.html");
        tiendaEnLineaPage.salirTiendaEnLinea();
        tiendaEnLineaPage.puntoControlFive("https://www.saucedemo.com/");
    }

    @Test
    public void CompraSauceDemoPageFactory() {
        TiendaEnLineaPageFactory tiendaEnLineaPageFactory = new TiendaEnLineaPageFactory(webDriver);
        tiendaEnLineaPageFactory.ingresarTiendaEnLinea("standard_user", "secret_sauce");
        tiendaEnLineaPageFactory.puntoControlOne("https://www.saucedemo.com/inventory.html");
        tiendaEnLineaPageFactory.seleccionarProductos();
        tiendaEnLineaPageFactory.checkOut();
        tiendaEnLineaPageFactory.puntoControlTwo("https://www.saucedemo.com/checkout-step-one.html");
        tiendaEnLineaPageFactory.enviarDatosAdicional("JULISSA", "BERCIAN", "EL SALVADOR");
        tiendaEnLineaPageFactory.puntoControlThree("https://www.saucedemo.com/checkout-step-two.html");
        tiendaEnLineaPageFactory.finCompra();
        tiendaEnLineaPageFactory.puntoControlFour("https://www.saucedemo.com/checkout-complete.html");
        tiendaEnLineaPageFactory.salirTiendaEnLinea();
        tiendaEnLineaPageFactory.puntoControlFive("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() {
       webDriver.quit();
    }

}
