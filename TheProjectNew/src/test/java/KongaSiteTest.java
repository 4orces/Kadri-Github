import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaSiteTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        driver = new ChromeDriver();
        //get the website url
        driver.get("https://www.konga.com/");
        //verify the website
        if(driver.getCurrentUrl().contains("https://www.konga.com/"))
            System.out.println("Correct Webpage");
        else
            System.out.println(("Wrong Webpage"));
        Thread.sleep(5000);
        //maximize the window
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //click on the signIn/signUp button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void login() throws InterruptedException {
        //input username
        driver.findElement(By.id("username")).sendKeys("kadridamilola2@gmail.com");
        //input password
        driver.findElement(By.id("password")).sendKeys("damilola");
        //click Login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 1)
    public void addToCart() throws InterruptedException {
        //click on Computers and Accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //click on laptop
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a")).click();

        Thread.sleep(5000);
        //click on macbook
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label")).click();
        Thread.sleep(5000);
        //click Add To Cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[3]/form/div[2]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void checkOut() throws InterruptedException {
        //click My Cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        Thread.sleep(5000);
        //click CheckOut
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 3)
    public void paymentOptions() throws InterruptedException {
        //select payment options (Pay Now)
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/section[1]/div[2]/section[1]/main[1]/div[1]/form[1]/div[1]/div[1]/section[2]/div[1]/div[2]/div[1]/div[1]/span[1]/input[1]")).click();
        Thread.sleep(8000);
        //click Continue to Payment
        driver.findElement(By.name("placeOrder")).click();
        Thread.sleep(12000);
    }

    @Test (priority = 4)
    public void paymentMethod() throws InterruptedException {
        //switch the iframe
        WebElement payment = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(8000);
        //select payment method (Card)
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
        Thread.sleep(8000);
    }

    @Test (priority = 5)
    public void cardDetails() throws InterruptedException {
        //enter card details (Card Number)
        driver.findElement(By.id("card-number")).sendKeys("4233 2434 1654 1652");
        Thread.sleep(5000);
        //input date
        driver.findElement(By.id("expiry")).sendKeys("05/25");
        Thread.sleep(5000);
        //input CVV
        driver.findElement(By.id("cvv")).sendKeys("698");
        Thread.sleep(5000);
        //click Pay Now
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(8000);
    }

    @Test (priority = 6)
    public void printErrorMessage() throws InterruptedException {
        //print out the error message: Invalid card number
        WebElement message = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]"));
        System.out.println(message.getText());
        Thread.sleep(5000);
    }

    @Test (priority = 7)
    public void exitIframe() throws InterruptedException {
        //close the iframe that displays the input card mode
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 8)
    public void switchToBrowser() throws InterruptedException {
        //switch to default browser
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @AfterTest
    public void quitBrowser() {
        //quit the browser
        driver.quit();

    }

}
