
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testAddNewCustomer {
    WebDriver driver;

    public static void main(String[] args) {

    }

    @BeforeTest
    public void openURL() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.demo.guru99.com/V4/");
    }


    @Test(priority = 0)
    public void addcstTC01() throws InterruptedException {
        // input all field with wrong date

        // to reset all fields before writing
        driver.findElement(By.name("res")).click();


         driver.findElement(By.name("name")).sendKeys("Ahmad");

        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
        driver.findElement(By.name("dob")).sendKeys("0102"); //wrong date


        driver.findElement(By.name("addr")).sendKeys("16 october");
        driver.findElement(By.name("city")).sendKeys("giza");
        driver.findElement(By.name("state")).sendKeys("Single");
         driver.findElement(By.name("pinno")).sendKeys("123456");
        driver.findElement(By.name("telephoneno")).sendKeys("01125487963");
        driver.findElement(By.name("emailid")).sendKeys("abdallah35@gmail.com");
        driver.findElement(By.name("password")).sendKeys("hyvaqyz12");
        driver.findElement(By.name("sub")).click();

            Thread.sleep(10000);
        WebElement wrongDateMess = driver.findElement(By.id("message24"));
        Assert.assertTrue(wrongDateMess.isDisplayed());


    }



    @Test (priority = 1 )
    public void addCustomer_TC02() throws InterruptedException {
        //Wronge pin number
        // to reset all fields before writing
         driver.findElement(By.name("res")).click();


         driver.findElement(By.name("name")).sendKeys("Nada");

         driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")).click();
         driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
         driver.findElement(By.name("dob")).sendKeys("09012004");


         driver.findElement(By.name("addr")).sendKeys("16 metro Hellwan");
         driver.findElement(By.name("city")).sendKeys("cairo");
         driver.findElement(By.name("state")).sendKeys("Single");
        driver.findElement(By.name("pinno")).sendKeys("1232");
        driver.findElement(By.name("telephoneno")).sendKeys("0102652478");
         driver.findElement(By.name("emailid")).sendKeys("Nada1@gmail.com");
        driver.findElement(By.name("password")).sendKeys("hyvaqyz12");
        driver.findElement(By.name("sub")).click();

        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();

    }
    @Test (priority = 2 )
    public void addCustomer_TC03() {
        //empty address
        // to reset all fields before writing
        driver.findElement(By.name("res")).click();


        driver.findElement(By.name("name")).sendKeys("Nada");

        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
        driver.findElement(By.name("dob")).sendKeys("09012004");


        driver.findElement(By.name("addr")).sendKeys("");
        driver.findElement(By.name("city")).sendKeys("cairo");
        driver.findElement(By.name("state")).sendKeys("Single");
        driver.findElement(By.name("pinno")).sendKeys("12345"); //wrong pin number
        driver.findElement(By.name("telephoneno")).sendKeys("0102652478");
        driver.findElement(By.name("emailid")).sendKeys("Nada1@gmail.com");
        driver.findElement(By.name("password")).sendKeys("hyvaqyz12");
        WebElement btnCstSubmit = driver.findElement(By.name("sub"));
        //Thread.sleep(5000);
        btnCstSubmit.click();
        // Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();

        String alerttxt = alert.getText();

        Assert.assertEquals("please fill all fields",alerttxt);
        alert.accept();

    }
    @AfterTest
public void endsession(){
    driver.quit();
    }
}