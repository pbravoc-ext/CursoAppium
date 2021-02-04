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
import static utils.Utils.swipeAbajo;

public class BorrarClientePage {

    private AppiumDriver driver;
    public BorrarClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Jose Pizarro')]")
    private MobileElement tituloVisibleNombreCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement eliminarCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement clickInput;

    @AndroidFindBy(id =  "android:id/button1")
    private MobileElement clickBotonOk;

    @AndroidFindBy(id =  "android:id/button2")
    private MobileElement clickBotonCancelar;

    @AndroidFindBy(id = "Navegar hacia arriba")
    private MobileElement flechaArriba;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'CLIENTES')]")
    private MobileElement cliente;

    public void validarVistaDesplegada(){
        if(esperarElemento(tituloVisibleNombreCliente,5)){
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            addStep("Cliente Encontrado" ,true, Status.PASSED,false);

        }else {
            addStep("Cliente No Encontrado ",true, Status.PASSED,false);
        }

    }

    public void seleccionarCliente(){
        tituloVisibleNombreCliente.click();
    }

    public void encontrarBtn(){
        boolean btnEncontrar = false;
        do{
            if (esperarElemento(eliminarCliente,1)){
                addStep("Boton Encontrado ",true, Status.PASSED,false);
                btnEncontrar= true;
            }else{
                swipeAbajo();
            }

        }while (btnEncontrar = false);


    }

    public void borrarCliente(String borrar){
        eliminarCliente.click();
        clickInput.click();
        clickInput.setValue(borrar);
        clickBotonOk.click();

    }
    public void tabBotonCliente(){
        cliente.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }


}
