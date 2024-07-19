import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebsiteTest {
    private WebDriver driver;
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        //access Konga url
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //maximize the window
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //click signi/signout button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);

    }


    @Test(priority = 0)
    public void login() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("kadridamilola2@gmail.com");
        driver.findElement(By.id("password")).sendKeys("damilola");
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void addToCart() throws InterruptedException {
        //Click the categories and accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //click laptop
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(5000);
        //select macbook
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label")).click();
        Thread.sleep(5000);
        //click add to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[3]/form/div[2]/button")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 2)
    public void checkOut() throws InterruptedException {
        //click open cart
        driver.findElement((By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]"))).click();
        Thread.sleep(5000);
        //click continue to checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 3)
    public void confirmPaymentInfo() throws InterruptedException {
        driver.findElement(By.id("card-number")).sendKeys("4233 2434 1654 1652");
        driver.findElement(By.id("expiry")).sendKeys("05/25");
        driver.findElement(By.id("cvv")).sendKeys("698");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
