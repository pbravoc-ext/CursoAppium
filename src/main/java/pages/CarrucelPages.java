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

public class CarrucelPages {
    private AppiumDriver driver;

    public CarrucelPages(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id= "com.rodrigo.registro:id/next")
    private MobileElement flechNext;

    @AndroidFindBy(id= "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement permitir;

    @AndroidFindBy(id= "com.rodrigo.registro:id/done")
    private MobileElement hecho;

    public void flujoCarrucel(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        flechNext.click();
        addStep("Flecha Next 1",true, Status.PASSED,false);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        flechNext.click();
        addStep("Flecha Next 2",true, Status.PASSED,false);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        flechNext.click();
        addStep("Permitir ",true, Status.PASSED,false);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        permitir.click();
        addStep("Hecho",true, Status.PASSED,false);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        hecho.click();

    }

}
