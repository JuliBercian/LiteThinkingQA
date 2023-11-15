package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TiendaEnLineaPageFactory {
    
    WebDriver webDriver;
    //INGRESAR A LA TIENDA EN LINEA
    @FindBy(name = "user-name")
    WebElement userName;
    @FindBy(name = "password")
    WebElement passWord;
    @FindBy(name = "login-button")
    WebElement btnLogin;
    //SELECCIONAR PRODUCTOS
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement prod1;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement prod2;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement prod3;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement prod4;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement prod5;
    //VER PRODUCTOS EN CARRITO
    @FindBy(id = "shopping_cart_container")
    WebElement carrito;
    //IR AL CKECKOUT
    @FindBy(id = "checkout")
    WebElement btcCheck;
    //LLENAR DATOS ADICIONALES
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement btnContinuar;
    //FINALIZAR Y SALIR DE LA TIENDA
    @FindBy(name = "finish")
    WebElement btnFinish;
    @FindBy(name = "back-to-products")
    WebElement btnBackHome;
    @FindBy(id = "react-burger-menu-btn")
    WebElement btnMenuP;
    @FindBy(id = "logout_sidebar_linke")
    WebElement optLogOut;

    //ABRIR TIENDA EN EL NAVEGADOR
    public TiendaEnLineaPageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //INGRESAR A LA TIENDA
    private void llenarLogin(String usuario, String contra) {
       userName.clear();
       userName.sendKeys(usuario);
       passWord.clear();
       passWord.sendKeys(contra);
    }

    public void ingresarTiendaEnLinea(String txtUser, String txtPass) {
        llenarLogin(txtUser, txtPass);
        webDriver.findElement(btnLogin).click();
    }

    //SELECCIONAR PRODUCTOS E IR AL CARRITO DE COMPRAS
    public void seleccionarProductos(){
        webDriver.findElement(prod1).click();
        webDriver.findElement(prod2).click();
        webDriver.findElement(prod3).click();
        webDriver.findElement(prod4).click();
        webDriver.findElement(prod5).click();
        webDriver.findElement(carrito).click();
    }

    //GENERAR EL CHECKOUT
    public void checkOut(){
        webDriver.findElement(btcCheck).click();
    }

    //LLENAR EL FORMULARIO DE DATOS ADICIONALES
    private void llenarAdicional(String nombre, String apellido, String postal) {
        webDriver.findElement(firstName).clear();
        webDriver.findElement(firstName).sendKeys(nombre);
        webDriver.findElement(lastName).clear();
        webDriver.findElement(lastName).sendKeys(apellido);
        webDriver.findElement(postalCode).clear();
        webDriver.findElement(postalCode).sendKeys(postal);
    }

    public void enviarDatosAdicional(String txtNombre, String txtApellido, String txtPostal) {
        llenarAdicional(txtNombre, txtApellido, txtPostal);
        webDriver.findElement(btnContinuar).click();
    }

    //FINALIZAR COMPRA
    public void finCompra() {
        webDriver.findElement(btnFinish).click();
    }

    //BACKHOME Y SALIR DE LA TIENDA
    public void salirTiendaEnLinea() {
        webDriver.findElement(btnBackHome).click();
        webDriver.findElement(btnMenuP).click();
        webDriver.findElement(optLogOut).click();
    }

    //PUNTOS DE CONTROL
    public void puntoControlOne(String ingresarTienda) {
        assertEquals(
            "Punto de control 1: No se ha ingresado a la tienda en linea",
            ingresarTienda,
            webDriver.getCurrentUrl()
            );
        System.out.println("Punto de control 1: Se ha ingresado a la tienda en linea");
    }

    public void puntoControlTwo(String agenerarcheckOut) {
        assertEquals(
            "Punto de control 2: Se agregaron los productos al carrito y se genero el ckeckout",
            agenerarcheckOut,
            webDriver.getCurrentUrl()
            );
        System.out.println("Punto de control 2: Se agregaron los productos al carrito y se genero el ckeckout");
    }

    public void puntoControlThree(String datosAdicionales) {
        assertEquals(
            "Punto de control 3: No se lleno el form de datos adicionales correctamente",
            datosAdicionales,
            webDriver.getCurrentUrl()
            );
        System.out.println("Punto de control 3: Se lleno el form de datos adicionales correctamente");
    }

    public void puntoControlFour(String finalizarCompra) {
        assertEquals(
            "Punto de control 4: La compra no se realizo correctamente",
            finalizarCompra,
            webDriver.getCurrentUrl()
            );
        System.out.println("Punto de control 4: La compra se realizo correctamente");
    }

    public void puntoControlFive(String salirTienda) {
        assertEquals(
            "Punto de control 5: No se ha salido de la tienda en linea",
            salirTienda,
            webDriver.getCurrentUrl()
            );
        System.out.println("Punto de control 5: Se ha salido de la tienda en linea");
    }


}
