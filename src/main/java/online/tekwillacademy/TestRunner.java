package online.tekwillacademy;

import online.tekwillacademy.managers.DataGeneratorManager;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.*;

import javax.swing.*;

public class TestRunner {
    public static void main(String[] args) {

        WebDriver driver = DriverManager.getInstance().getDriver();
        String currentTabName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.tekwillacademy-opencart.online/");
        System.out.println("The current url is: "+driver.getCurrentUrl());
        System.out.println("The page title is: "+driver.getTitle());
        WebElement userDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        userDropDownIcon.click();

        WebElement registredOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registredOption.click();
        System.out.println("The current url is: "+driver.getCurrentUrl());
        System.out.println("The page title is: "+driver.getTitle());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("Gabriel");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Turcan");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = DataGeneratorManager.getRandomEmail();
        emailInput.sendKeys(emailData);
        System.out.println("Email: +" +emailInput);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("12345678!");

        WebElement siteAgreement = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ScrollManager.scrollToElement(siteAgreement);siteAgreement.click();



        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The current url is: "+driver.getCurrentUrl());
        System.out.println("The page title is: "+driver.getTitle());




        /*driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver");*/
        driver.close();

        driver.switchTo().window(currentTabName);
        driver.get("https://www.tekwillacademy-opencart.online/");
        driver.quit();

        System.out.println("The test is finished and driver is closed");
    }
}