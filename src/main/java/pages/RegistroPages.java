package pages;

import driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static reports.ReportAllure.addStep;
import static utils.Utils.esperarElemento;

public class RegistroPages {
    private AppiumDriver driver;

    public RegistroPages(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Registro')]")
    private MobileElement tituloVisibleRegistro;

    @AndroidFindBy(id= "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement menuBoton;

    @AndroidFindBy(id= "com.rodrigo.registro:id/action_cliente")
    private MobileElement crearCliente;

    @AndroidFindBy(id= "com.rodrigo.registro:id/action_producto")
    private MobileElement crearProducto;

    public void validarVistaDesplegada(){
        if(esperarElemento(tituloVisibleRegistro,5)){
            addStep("Valida vista Registro desplegada",true, Status.PASSED,false);

        }else {
            addStep("No se Desplego vista Registro ",true, Status.FAILED,true);
        }

    }
        public void tabBoton() {
        menuBoton.click();
        }
        public void tabBtnCliente(){
            crearCliente.click();
        }
        public void tabBtnProducto(){
            crearProducto.click();
        }


}

