import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://selenium-blog.herokuapp.com/");
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com")) {

            System.out.println("Correct Webpage");
        }
        else {
            System.out.println("Wrong Webpage");
        }

        Thread.sleep(5000);

        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

    }

    @Test(priority = 0)
    public void positiveSignup() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("4orces");

        driver.findElement(By.id("user_email")).sendKeys("kadrijunior@yahoo.com");

        driver.findElement(By.id("user_password")).sendKeys("admin");

        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void clickUser1Item() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();

        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Correct Webpage");
        }
        else {
            System.out.println("Wrong Webpage");
        }
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl)) {
            System.out.println("Correct User1 Page");
        }
        else {
            System.out.println("Wrong User1 Page");
        }
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void logoutSuccessfully() {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contains(actualTitle)) {
            System.out.println("Correct Webpage");
        }
        else {
            System.out.println("Wrong Webpage");
        }
    }

    @Test(priority = 4)
    public void negativeSignup() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("user_username")).sendKeys("ce");
        driver.findElement(By.id("user_email")).sendKeys("kadridamilola2@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}
