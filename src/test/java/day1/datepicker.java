package day1;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class datepicker {
	
	public static void sleep(int t) 
	{
		try {
			  Thread.sleep(t * 1000);
			} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
			}
	}
	
	public static void searchForwardOrBackward() 
	{
		
	}
	
	public static void main(String[] args) {

	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	
	
	String dayToSet = "20";
	String monthToSet = "12";
	String yearToSet = "2026";
	String date = dayToSet +"/"+monthToSet+"/"+yearToSet;
	
	
	WebElement currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
	System.out.println(currentMonth.getText());
	WebElement currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
	System.out.println(currentYear.getText());
	
	
	//sleep(4);
	
	//driver.close();
	
	
	}
}
