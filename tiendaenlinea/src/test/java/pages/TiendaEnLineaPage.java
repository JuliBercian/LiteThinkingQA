package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TiendaEnLineaPage {
    
    WebDriver webDriver;
    private By userName = By.name("user-name");
    private By passWord = By.name("password");

    public TiendaEnLineaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void llenarUser(String usuario) {
        webDriver.findElement(userName).clear();
        webDriver.findElement(userName).sendKeys(usuario);
    }

    public void llenarPass(String contra) {
        webDriver.findElement(passWord).clear();
        webDriver.findElement(passWord).sendKeys(contra);
    }




}
