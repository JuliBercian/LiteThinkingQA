package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePageFactory {

    WebDriver webDriver;

    @FindBy(name = "q")
    WebElement textBoxSearch;

    @FindBy(name = "btnK")
    WebElement btnSearch;

    public GoogleHomePageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    private void fillTextBoxSearch(String text){
        textBoxSearch.clear();
        textBoxSearch.sendKeys(text);
    }

    private void clickBtnSearch(){
        btnSearch.click();
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
