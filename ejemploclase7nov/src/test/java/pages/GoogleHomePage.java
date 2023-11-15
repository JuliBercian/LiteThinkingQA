package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    WebDriver webDriver;
    private By textBoxSearch = By.id("APjFqb");
    private By btnSearch = By.name("btnK");

    public GoogleHomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private void fillTextBoxSearch(String text){
        webDriver.findElement(textBoxSearch).clear();
        webDriver.findElement(textBoxSearch).sendKeys(text);
    }

    private void clickBtnSearch(){
        webDriver.findElement(btnSearch).click();
    }

    public void searchGoogle(String txtToSearch){
        fillTextBoxSearch(txtToSearch);
        clickBtnSearch();
    }

    public void isUserInSearchResult(String expectedTitle){
        assertEquals(
            "El titulo es el correcto",
            "Selenium Web Driver - Buscar con Google",
            webDriver.getTitle()
            );
    }
}