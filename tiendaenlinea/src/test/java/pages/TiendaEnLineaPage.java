package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TiendaEnLineaPage {
    
    WebDriver webDriver;

    private By userName = By.id("username");
    private By passWord = By.id("password");

    public TiendaEnLinea(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private void llenarAuntenticacion(String usuario, String contra) {
        userName.clear();
        userName.sendKeys(usuario);
        passWord.clear();
        passWord.sendKeys(contra);
    }

}
