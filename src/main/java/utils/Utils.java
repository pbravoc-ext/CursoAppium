package utils;

import driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static boolean esperarElemento(MobileElement element,int seconds){
        try {
            System.out.println("[Utils = esperarElemento] Se espera Elemento: " +element);
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), seconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return  true;

        }catch (Exception e){
            System.out.println("[Utils = esperarElemento] Elemento: "+ element + " No se Encontro");
            return false;
        }

    }

    public static void swipeAbajo(){
        int ancho = (int) ((double)DriverContext.getDriver().manage().window().getSize().width * 0.08D);
        int startPoint = (int) ((double)DriverContext.getDriver().manage().window().getSize().height * 0.9D);
        int endPoint = (int) ((double)DriverContext.getDriver().manage().window().getSize().width * 0.65D);
        TouchAction touchAction = new TouchAction(DriverContext.getDriver());
        touchAction.press(PointOption.point(ancho,startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500L))).moveTo(PointOption.point(ancho,endPoint)).release().perform();
        System.out.println("Se Hace Swipe Abajo");

    }

}
