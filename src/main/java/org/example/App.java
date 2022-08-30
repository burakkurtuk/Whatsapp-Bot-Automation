package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class App {

    WebDriver driver;

    String BASE_URL = "https://web.whatsapp.com/";

    By imgLocator = By.xpath("(//div/img[@class='_8hzr9 M0JmA i0jNr'])[1]");
    By searchLocator = By.cssSelector("div[data-testid='chat-list-search']");
    By messageLocator = By.cssSelector("div[class='fd365im1 to2l77zo bbv8nyr4 mwp4sxku gfz4du6o ag5g9lrv']");


    public App(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public void findPerson(String toWhom) {
        waitFor(imgLocator);
        driver.findElement(searchLocator).sendKeys(toWhom);
        driver.findElement(searchLocator).click();
        driver.findElement(searchLocator).sendKeys(Keys.ENTER);
    }

    public void sendMessage(String text){
        driver.findElement(messageLocator).sendKeys(text);
        driver.findElement(messageLocator).sendKeys(Keys.ENTER);
    }



    private void waitFor(By locator){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}


}
