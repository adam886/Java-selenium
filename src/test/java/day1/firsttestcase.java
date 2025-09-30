package day1;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class firsttestcase {
	public static void sleep(int t) 
	{
		try {
			  Thread.sleep(t * 1000);
			} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
			}
	}
	
	public static void main(String[] args) {


		if(false) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");

		// tag id                tag#id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		//css selector    tag.classname
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-shirts");
		//tag attribute 
		//driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("T-shirts");
		//tag class attribute
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("T-shirts");
		sleep(1);
		driver.findElement(By.cssSelector ("button[type='submit']")).click();
		sleep(2);

		

		driver.findElement(By.cssSelector("#advs")).click();
		sleep(1);
		//driver.findElement(By.cssSelector("#cid")).click();
		driver.findElement(By.cssSelector("select[id='cid'] option[value='2']")).click();
		sleep(3);
		driver.findElement(By.xpath("//button[@class='button-1 search-button']")).click();
		//multiple
		////input[@name='q'][@placeholder='Search store']
		/////input[@name='q' and @placeholder='Search store']
		sleep(1);
		driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).click();
		sleep(1);
		driver.findElement(By.xpath("//img[@title='Show details for Apple MacBook Pro']")).click();
		sleep(1);
		driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).click();
		sleep(1);
		
		//System.out.println( driver.findElement(By.cssSelector("div[class='product-grid home-page-product-grid'] strong")).getText());
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("abc");
		//driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("abc");
		//chained xpath //div[@id='logo']/a/img
		
		System.out.println(driver.findElement(By.xpath("//div[@id='header-logo']/a/img")).isDisplayed());
		
		
		sleep(20);
		}
		
		
		WebDriver driver=new EdgeDriver();
		sleep(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sleep(1);
		driver.get("https://testautomationpractice.blogspot.com/");
		sleep(1);
		driver.manage().window().maximize();
		
		
		WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");

		WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		
		//
		driver.close();
	}

}
