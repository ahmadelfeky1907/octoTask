

 import  io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



    public class Testlogin {
        WebDriver driver;


        @BeforeTest
        public void openURL(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://www.demo.guru99.com/V4/");
        }
        @Test
        public void userCanLoginTestCase1(){
            driver.findElement(By.name("uid")).sendKeys("mngr466753");
             driver.findElement(By.name("password")).sendKeys("hyvaqyx"); // Wrong password

            driver.findElement(By.name("btnLogin")).click();
            Alert alert = driver.switchTo().alert();

            String alerttxt = alert.getText();

            Assert.assertEquals("User or Password is not valid",alerttxt);
            alert.accept();
        }

        @Test
        public void userCanLoginTestCase2() {
            driver.findElement(By.name("uid")).sendKeys("mngr466752"); // wrong UserId
            driver.findElement(By.name("password")).sendKeys("hyvaqyz");

            driver.findElement(By.name("btnLogin")).click();
            Alert alert = driver.switchTo().alert();

            String alerttxt = alert.getText();

            Assert.assertEquals("User or Password is not valid", alerttxt);
            alert.accept();
        }

        @Test
        public void userCanLoginTestCase3() {
            driver.findElement(By.name("uid")).sendKeys("");
            driver.findElement(By.name("password")).sendKeys("");

             driver.findElement(By.name("btnLogin")).click();
            Alert alert = driver.switchTo().alert();

            String alerttxt = alert.getText();

            Assert.assertEquals("User and Password must be not blank", alerttxt);

            alert.accept();
        }


        @AfterTest
        public void closeWebBros(){
            driver.quit();
        }
    }


