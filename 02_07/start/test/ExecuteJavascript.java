import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class ExecuteJavascript {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/Bratty/Downloads/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/modal");

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();

        WebElement closeButton = driver.findElement(By.id("close-button"));
        WebElement openButton = driver.findElement(By.id("ok-button"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("s:arguments[0].click();",openButton);
        System.out.println("Start Time: " + new Date());

        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        System.out.println("End Time: " + new Date());

        js.executeScript("s:arguments[0].click();",closeButton);


        driver.quit();
    }
}
