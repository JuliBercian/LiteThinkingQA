import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testUNIT {

    WebDriver webDriver;
    
    @BeforeClass
    public static void beforeClassJunit(){
        System.out.println("==================================");
        System.out.println("Me conecto a la base de datos");
    }

    @Before
    public void beforeJunit(){
        webDriver = new ChromeDriver();
        webDriver.get("https:/www.google.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void primerTest() throws InterruptedException{
        WebElement inputSearch = webDriver.findElement(By.id("APjFqb"));
        inputSearch.clear();
        inputSearch.sendKeys("Selenium Web Driver");

        // Thread.sleep(5000);
        WebElement btnSearch = webDriver.findElement(By.name("btnK"));
        btnSearch.click();

        System.out.println(webDriver.getTitle());

        assertEquals(
        "El resultado obtenido es igual al resultado esperado",
        "Selenium Web Driver - Buscar con Google",
        webDriver.getTitle()
        );
    }

    @Test
    public void segundoTest(){
        WebElement inputSearch = webDriver.findElement(By.id("APjFqb"));
        inputSearch.clear();
        inputSearch.sendKeys("Formula 1");

        WebElement btnSearch = webDriver.findElement(By.name("btnK"));
        btnSearch.click();

        System.out.println(webDriver.getTitle());

        assertEquals(
        "El resultado obtenido es igual al resultado esperado",
        "Formula 1 - Buscar con Google",
        webDriver.getTitle()
        );
    }

    @After
    public void afterJunit(){
        webDriver.quit();
    }

    @AfterClass
    public static void afterClassJunit(){
        System.out.println("Desconectar la Base de Datos");
        System.out.println("==================================");
    }


}
