package testSuite;


import io.appium.java_client.AppiumDriver;
import io.qameta.allure.model.Status;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import reports.ReportAllure;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static driver.DriverContext.setUp;

public class ejercicioTest {

    private AppiumDriver driver;
    private URL server= null;
    private DesiredCapabilities cap = new DesiredCapabilities();

    @BeforeSuite
    public void metodo1(){
        System.out.println("Inicio de Suite");
    }
    @BeforeMethod
    public void metodo2(){
        System.out.println("Inicio de Test");
    setUp("emuladorPablo","Android","D:\\Curso Appium\\registroDeUsuarios.apk","emuladorPablo", true);
        ReportAllure.addStep("Inicio Dispositivo",true, Status.PASSED,false);

    }
    @Test (priority = 1)
    public void metodo3(){
        System.out.println("Test 1");
    }
    @Test (priority = 2)
    public void metodo4(){
        System.out.println("Test 2");
    }
    @AfterMethod
    public void metodo5(){
        System.out.println("Termino de Test");
    }
}
