package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import javax.swing.*;

public class TestRunner {
    public static void main(String[] args) {

        WebDriver driver = DriverManager.getInstance().getDriver();
        String currentTabName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver");
        driver.close();

        driver.switchTo().window(currentTabName);
        driver.get("https://apple.stackexchange.com/questions/338898/how-to-copy-path-of-a-file-in-mac-os");
        driver.quit();

        System.out.println("The test is finished and driver is closed");
    }
}