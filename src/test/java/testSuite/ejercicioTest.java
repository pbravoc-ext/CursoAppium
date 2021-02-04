package testSuite;

import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testCases.CPA_BorrarCliente;
import testCases.CPA_CrearCliente;
import testCases.CPA_CrearProducto;
import static driver.DriverContext.quitDriver;
import static driver.DriverContext.setUp;
import static reports.ReportAllure.addStep;

public class ejercicioTest {

    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setUP(){
        System.out.println("Inicio de Suite");
        setUp("emuladorPablo","Android","D:\\Curso Appium\\registroDeUsuarios.apk","emuladorPablo", true);
        addStep("Inicio Dispositivo",true, Status.PASSED,false);
    }
    @AfterMethod
     public void quitTest(){
        addStep("Termino de Test",true, Status.PASSED,false);
        System.out.println("Termino de Test");
    }
    @Test (priority = 1, description = "Crear Cliente")
    public void CPA_CrearCliente(){
        CPA_CrearCliente cpa = new CPA_CrearCliente();
        System.out.println("Crear Cliente");
        cpa.flujoIngresoCliente();
    }

    @Test (priority = 2, description = "Ingresar Producto")
    public void CPA_CrearProducto(){
        CPA_CrearProducto cpa = new CPA_CrearProducto();
        System.out.println("Ingresar Producto");
        cpa.flujoIngresoProducto();


    }

    @Test (priority = 3, description = "Borrar Cliente")
    public void CPA_BorrarCliente(){
        CPA_BorrarCliente cpa = new CPA_BorrarCliente();
        System.out.println("Borrar Cliente");
        cpa.flujoBorrarCliente();

    }

    @AfterSuite
    public void quit(){
        addStep("Termino de Test",true, Status.PASSED,false);
        System.out.println("Termino de Test");
        quitDriver();
    }


}
