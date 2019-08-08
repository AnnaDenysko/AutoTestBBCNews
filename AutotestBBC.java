import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutotestBBC {
    public WebDriver driver;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bbc.com/news");
    }

    @Test
    public void BBCNewsSearch() throws InterruptedException {
        driver.findElement(By.id("orb-search-q")).sendKeys("Art");
        Thread.sleep(2000);
        driver.findElement(By.id("orb-search-q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        Assert.assertNotNull(driver.findElement(By.className("se-searchbox__input__field")));
        System.out.println("Search successful");
    }

    @Test
    public void BBCloginTest() throws InterruptedException {
        driver.findElement(By.id("idcta-link")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("user-identifier-input")).sendKeys("iguanastarka@gmail.com");
        driver.findElement(By.id("password-input")).sendKeys("38461991ka");
        driver.findElement(By.id("password-input")).sendKeys(Keys.ENTER);
        Assert.assertNotNull(driver.findElement(By.id("idcta-username")));
        Thread.sleep(2000);
        System.out.println("Login successful");
    }
    @After
    public void exit() {
        driver.quit();
    }
}