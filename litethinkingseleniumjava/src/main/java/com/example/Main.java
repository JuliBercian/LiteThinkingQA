package com.example;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.google.com");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Punto de control 1
        System.out.println("==================================");
        System.out.println("Punto 1:");
        String navChrome = webDriver.getTitle();
        if(navChrome.equals("Google")){
            System.out.println("El navegador se abre correctamente");
        }else{
            System.out.println("El navegador no se abre correctamente");
        }
        System.out.println("==================================");

        WebElement inputSearch = webDriver.findElement(By.id("APjFqb"));
        inputSearch.clear();
        inputSearch.sendKeys("Selenium Web Driver");

        WebElement btnSearch = webDriver.findElement(By.name("btnK"));
        btnSearch.click();

        // System.out.println(webDriver.getTitle());
        System.out.println("==================================");
        System.out.println("Punto 2:");
        if(webDriver.getTitle().equals("Selenium Web Driver - Buscar con Google")){
            System.out.println("La búsqueda se realizo correctamente");
        }else{
            System.out.println("La búsqueda no se realizo correctamente");
        }
        System.out.println("==================================");

        WebElement imagesPage = webDriver.findElement(By.linkText("Imágenes"));
        imagesPage.click();
        WebElement imagesSearch = webDriver.findElement(By.id("islrg"));


        System.out.println("==================================");
        System.out.println("Punto 3:");
        if (imagesSearch.isDisplayed()) {
            System.out.println("Se muestran los resultados de imagenes de la busqueda");
        } else {
            System.out.println("No se muestran los resultados de imagenes de la busqueda");
        }
        System.out.println("==================================");

        webDriver.navigate().back();
        WebElement seleniumPage = webDriver.findElement(By.cssSelector(".LC20lb"));
        seleniumPage.click();

        System.out.println("==================================");
        System.out.println("Punto 4:");
        String urlSelenium = "https://www.selenium.dev/documentation/webdriver/";
        String urlObtenida = webDriver.getCurrentUrl();
        if (urlObtenida.equals(urlSelenium)) {
            System.out.println("Se retorno correctamente y se ingreso al primer resultado de la busqueda");
        } else {
            System.out.println("No se retorno correctamente y se ingreso al primer resultado de la busqueda");
        }
        System.out.println("==================================");

        WebElement seleBlog = webDriver.findElement(By.linkText("Blog"));
        seleBlog.click();

        System.out.println("==================================");
        System.out.println("Punto 5:");
        String urlSelBlog = "https://www.selenium.dev/blog/";
        String urlPageObtenida = webDriver.getCurrentUrl();
        if (urlPageObtenida.equals(urlSelBlog)) {
            System.out.println("Se ingreso al Blog de la web de Selenium");
        } else {
            System.out.println("No se ingreso al Blog de la web de Selenium");
        }
        System.out.println("==================================");

        webDriver.quit();
    }

}