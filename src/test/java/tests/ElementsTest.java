package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementsTest {
    private final String DELETE_BUTTON = "//button[text()='Delete']";
    private ChromeDriver driver;


    @BeforeClass
    public void preconditions(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");

    }

    @Test
    public void verifyAddingAndRemovingElements(){
        driver.findElement(By.xpath("//a[@href='/add_remove_elements/']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath(DELETE_BUTTON)).click();
        int quantityDeleteButtons = driver.findElements(By.xpath(DELETE_BUTTON)).size();
        Assert.assertEquals(quantityDeleteButtons, 1);
    }
}
