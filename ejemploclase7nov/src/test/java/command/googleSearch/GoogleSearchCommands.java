package command.googleSearch;

import static org.junit.Assert.assertEquals;

//metodos con los cuales vamos a interactuar con las pruebas
//si quuiero interactuar con estos metodos necesito pasarles toda la informacion

import org.openqa.selenium.WebDriver;

public class GoogleSearchCommands {
    
    public static void searchGoogle(WebDriver webDriver, String text) {
        webDriver.findElement(GoogleSearchPage.txtBoxSearch).sendKeys(text);
        webDriver.findElement(GoogleSearchPage.btnSearch).click();
    }

    public static void isUserInResults(WebDriver webDriver, String expectResult) {
        assertEquals(
            "El usuario no se encuentra en la pagina de resultados",
            expectResult,
            webDriver.getTitle()
            );
    }

}
