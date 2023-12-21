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

public class demoblaze {
        WebDriver webDriver;
    
    @BeforeClass
    public static void beforeClassJunit(){
        System.out.println("==================================");
    }

    @Before
    public void beforeJunit(){
        webDriver = new ChromeDriver();
        webDriver.get("https://demoblaze.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void puntoControl1(){
        System.out.println("Punto 1: El precio del HTC One M9 debe ser de $700");
        WebElement firstSearch = webDriver.findElement(By.linkText("HTC One M9"));
        firstSearch.click();
        WebElement firstPrice = webDriver.findElement(By.tagName("h3"));
        String priceText1 = firstPrice.getText();
        String precioNum1 = priceText1.replaceAll("[^0-9]", "");

        assertEquals(
        "El precio no es el correcto",
        "700",
        precioNum1
        );

        System.out.println("El precio mostrado en la web es: $"+precioNum1);
        System.out.println("****************************************************");
    }

    @Test
    public void puntoControl2(){
        System.out.println("Punto 2: El precio del MacBook Pro debe ser de $1100");
        WebElement laptopSearch = webDriver.findElement(By.linkText("Laptops"));
        laptopSearch.click();
        WebElement secondSearch = webDriver.findElement(By.linkText("MacBook Pro"));
        secondSearch.click();
        WebElement secondPrice = webDriver.findElement(By.tagName("h3"));
        String priceText2 = secondPrice.getText();
        String precioNum2 = priceText2.replaceAll("[^0-9]", "");

        assertEquals(
        "El precio no es el correcto",
        "1100",
        precioNum2
        );

        System.out.println("El precio mostrado en la web es: $"+precioNum2);
        System.out.println("****************************************************");
    }

    @Test
    public void puntoControl3(){
        System.out.println("Punto 3: El precio del Dell i7 8gb debe ser de $1100");
        WebElement laptopSearch = webDriver.findElement(By.linkText("Laptops"));
        laptopSearch.click();
        WebElement thirdSearch = webDriver.findElement(By.linkText("Dell i7 8gb"));
        thirdSearch.click();
        WebElement thirdPrice = webDriver.findElement(By.tagName("h3"));
        String priceText3 = thirdPrice.getText();
        String precioNum3 = priceText3.replaceAll("[^0-9]", "");

        assertEquals(
        "El precio no es el correcto",
        "700",
        precioNum3
        );

        System.out.println("El precio mostrado en la web es: $"+precioNum3);
        System.out.println("****************************************************");

    }

    @Test
    public void puntoControl4(){
        System.out.println("Punto 4: El precio del ASUS Full HD debe ser de $230");
        WebElement laptopSearch = webDriver.findElement(By.linkText("Laptops"));
        laptopSearch.click();
        WebElement laptopNext = webDriver.findElement(By.id("next2"));
        laptopNext.click();
        WebElement fourthSearch = webDriver.findElement(By.linkText("ASUS Full HD"));
        fourthSearch.click();
        WebElement fourthPrice = webDriver.findElement(By.tagName("h3"));
        String priceText4 = fourthPrice.getText();
        String precioNum4 = priceText4.replaceAll("[^0-9]", "");

        assertEquals(
        "El precio no es el correcto",
        "230",
        precioNum4
        );

        System.out.println("El precio mostrado en la web es: $"+precioNum4);
        System.out.println("****************************************************");
    }

    @Test
    public void puntoControl5(){
        System.out.println("Punto 5: El precio del MacBook Air debe ser de $700");
        WebElement laptopSearch = webDriver.findElement(By.linkText("Laptops"));
        laptopSearch.click();
        WebElement fifthSearch = webDriver.findElement(By.linkText("MacBook air"));
        fifthSearch.click();
        WebElement fifthPrice = webDriver.findElement(By.tagName("h3"));
        String priceText5 = fifthPrice.getText();
        String precioNum5 = priceText5.replaceAll("[^0-9]", "");

        assertEquals(
        "El precio no es el correcto",
        "700",
        precioNum5
        );

        System.out.println("El precio mostrado en la web es: $"+precioNum5);
        System.out.println("****************************************************");
    }

    @After
    public void afterJunit(){
        webDriver.quit();
    }

    @AfterClass
    public static void afterClassJunit(){
        System.out.println("==================================");
    }

}
