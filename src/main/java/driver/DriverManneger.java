package driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManneger {

    private AppiumDriver driver;
    private URL server= null;
    private DesiredCapabilities cap = new DesiredCapabilities();

    protected void setUp(String nombreDispositivo, String sistemaOperativo, String rutaApp, String udID, boolean emulador){
        cap.setCapability("deviceName",nombreDispositivo);
        cap.setCapability("platformName",sistemaOperativo);
        cap.setCapability("app", rutaApp);
        if (!emulador){
            cap.setCapability("udId",udID);
        }


        try {
            server= new URL("http://127.0.0.1:4723/wd/hub");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver(server,cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    protected AppiumDriver getDriver(){
        return driver;
    }
}
