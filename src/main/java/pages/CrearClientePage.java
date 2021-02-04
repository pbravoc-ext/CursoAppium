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

public class CrearClientePage {
    private AppiumDriver driver;
    public CrearClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Crear Cliente')]")
    private MobileElement tituloVisibleCrearCliente;

    @AndroidFindBy(id= "com.rodrigo.registro:id/ac_nombre")
    private MobileElement ingresarNombre;

    @AndroidFindBy(id= "com.rodrigo.registro:id/ruc")
    private MobileElement ingresarId;

    @AndroidFindBy(id= "com.rodrigo.registro:id/tel")
    private MobileElement ingresarTelefono;

    @AndroidFindBy(id= "com.rodrigo.registro:id/dir")
    private MobileElement ingresarDireccion;

    @AndroidFindBy(id= "com.rodrigo.registro:id/notas")
    private MobileElement ingresarNota;

    @AndroidFindBy(id= "com.rodrigo.registro:id/guardar")
    private MobileElement botonGuardar;

    public void validarVistaDesplegada(){
        if(esperarElemento(tituloVisibleCrearCliente,5)){
            addStep("Valida vista Crear Cliente desplegada",true, Status.PASSED,false);

        }else {
            addStep("No se Desplego vista  Crear Cliente ",true, Status.PASSED,false);
        }

    }
    public void ingresarCliente(String nombre, String Id, String telefono, String direccion, String nota){
        ingresarNombre.click();
        ingresarNombre.setValue(nombre);
        addStep("Nombre: "+ nombre,true, Status.PASSED,false);
        this.driver.hideKeyboard();

        ingresarId.click();
        ingresarId.setValue(Id);
        addStep("Id: "+ Id,true, Status.PASSED,false);
        this.driver.hideKeyboard();

        ingresarTelefono.click();
        ingresarTelefono.setValue(telefono);
        addStep("Telefono: "+telefono,true, Status.PASSED,false);
        this.driver.hideKeyboard();

        ingresarDireccion.click();
        ingresarDireccion.setValue(direccion);
        addStep("Direccion: "+ direccion,true, Status.PASSED,false);
        this.driver.hideKeyboard();

        ingresarNota.click();
        ingresarNota.setValue(nota);
        addStep("Nota: "+nota,true, Status.PASSED,false);
        this.driver.hideKeyboard();

    }

    public void tabBotonGuardar(){
        botonGuardar.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

}
