package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
        public static void main(String[] args) throws InterruptedException {

            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://www.google.com");

            WebElement inputSearch = webDriver.findElement(By.id("APjFqb"));
            inputSearch.clear();
            inputSearch.sendKeys("Selenium Web Driver");

            Thread.sleep(5000);
            WebElement btnSearch = webDriver.findElement(By.name("btnK"));
            btnSearch.click();

            //System.out.println(webDriver.getTitle());
            System.out.println("-------------------------");
            if(webDriver.getTitle().equals("Selenium Web Driver - Buscar con Google")){
            System.out.println("El resultado obtenido es igual al resultado esperado");
            }
            else{
            System.out.println("El resultado obtenido es diferente al resutaldo esperado");
            }
            System.out.println("-------------------------");
            webDriver.quit();


    }
}