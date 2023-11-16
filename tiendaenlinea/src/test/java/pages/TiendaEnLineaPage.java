package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TiendaEnLineaPage {
    WebDriver webDriver;
    //INGRESAR A LA TIENDA EN LINEA
    private By userName = By.name("user-name");
    private By passWord = By.name("password");
    private By btnLogin = By.name("login-button");
    //SELECCIONAR PRODUCTOS
    private By prod1 = By.id("add-to-cart-sauce-labs-backpack");
    private By prod2 = By.id("add-to-cart-sauce-labs-bike-light");
    private By prod3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By prod4 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By prod5 = By.id("add-to-cart-sauce-labs-onesie");
    //VER PRODUCTOS EN CARRITO
    private By carrito = By.id("shopping_cart_container");
    //IR AL CKECKOUT
    private By btcCheck = By.id("checkout");
    //LLENAR DATOS ADICIONALES
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By btnContinuar = By.name("continue");
    //FINALIZAR Y SALIR DE LA TIENDA
    private By btnFinish = By.name("finish");
    private By btnBackHome = By.name("back-to-products");
    private By btnMenuP = By.id("react-burger-menu-btn");
    private By optLogOut = By.id("logout_sidebar_link");

    //ABRIR TIENDA EN EL NAVEGADOR
    public TiendaEnLineaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //INGRESAR A LA TIENDA
    private void llenarLogin(String usuario, String contra) {
        webDriver.findElement(userName).clear();
        webDriver.findElement(userName).sendKeys(usuario);
        webDriver.findElement(passWord).clear();
        webDriver.findElement(passWord).sendKeys(contra);
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
        System.out.println("*******************POM***************************");
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
