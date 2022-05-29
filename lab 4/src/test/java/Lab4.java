import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lab4 {
    static WebDriver driver;
    static  final String WEBSITE="http://formy-project.herokuapp.com/form";
    @BeforeAll
    public  static  void  initSelenium(){
        WebDriverManager.chromedriver().setup();

    }
    @Nested
    @DisplayName("Testing on Chrome Browser")
    public  class ChromeTesting{
        @BeforeAll
        public static void initChrome(){
            driver = new ChromeDriver();
        }
        @Test
        public void runLab(){
            driver.get(WEBSITE);
            WebElement firstname = driver.findElement(By.id("first-name"));
            firstname.sendKeys("mahmoud");
            WebElement lastname = driver.findElement(By.id("last-name"));
            lastname.sendKeys("elkhashab");
            WebElement jobtitle = driver.findElement(By.id("job-title"));
            jobtitle.sendKeys("student");
            WebElement radiobutton = driver.findElement(By.id("radio-button-2"));
            radiobutton.click();
            WebElement checkbox = driver.findElement(By.id("checkbox-1"));
            checkbox.click();
            WebElement butn = driver.findElement(By.className("btn"));
            butn.click();

        }

    }

}
