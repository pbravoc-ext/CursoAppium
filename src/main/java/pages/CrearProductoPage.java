package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static reports.ReportAllure.addStep;
import static utils.Utils.esperarElemento;

public class CrearProductoPage {
    private AppiumDriver driver;
    public CrearProductoPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Crear Producto')]")
    private MobileElement tituloVisibleCrearProducto;

    @AndroidFindBy(id= "com.rodrigo.registro:id/nombre_producto")
    private MobileElement ingresarNombre_Producto;

    @AndroidFindBy(id= "com.rodrigo.registro:id/precio")
    private MobileElement ingresarPrecio;

    @AndroidFindBy(id= "com.rodrigo.registro:id/confirmar")
    private MobileElement botonConfirmar;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'PRODUCTOS')]")
    private MobileElement producto;

    public void validarVistaDesplegada(){
        if(esperarElemento(tituloVisibleCrearProducto,5)){
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            addStep("Valida vista Crear Producto desplegada",true, Status.PASSED,false);

        }else {
            addStep("No se Desplego vista  Crear Producto ",true, Status.PASSED,false);
        }

    }

    public void ingresarProducto(String nombreProducto, String precio){
        ingresarNombre_Producto.click();
        ingresarNombre_Producto.setValue(nombreProducto);
        addStep("Nombre Producto: "+ nombreProducto,true, Status.PASSED,false);
        this.driver.hideKeyboard();

        ingresarPrecio.click();
        ingresarPrecio.setValue(precio);
        addStep("Precio: "+ precio,true, Status.PASSED,false);
        this.driver.hideKeyboard();

    }
    public void tabBotonConfirmar(){
        botonConfirmar.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public void tabBotonProducto(){
        producto.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

}
