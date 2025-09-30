package day1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class date
{
	public int currentMonth;
	public int MonthToSetp;  
	public String MonthToSetpStr;  
    public date(int currentMonth, int MonthToSetp) 
    {
        this.currentMonth = currentMonth;
        this.MonthToSetp = MonthToSetp;
    }
}

public class datepicker {
	
	public static void sleep(int t) 
	{
		try {
			  Thread.sleep(t * 1000);
			} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
			}
	}
	
	public enum MyMonth {January, February, March, April, May, June, July, August, September, October, November, December}

		
	public static boolean checkifsearchForwardaAndUpdateMydate(WebDriver driver,String date, date mydate) 
	{
		WebElement currentMonthWebElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		WebElement currentYearWebElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));

		int currentYear = Integer.parseInt(currentYearWebElement.getText());
		int yearToSet = Integer.parseInt(date.substring(6,10)); 
		int monthToSet = Integer.parseInt(date.substring(3,5)); 

		MyMonth currentmonth = MyMonth.valueOf(currentMonthWebElement.getText());
		int curretMonth =  currentmonth.ordinal();
		
		mydate.currentMonth = curretMonth;
		mydate.MonthToSetp = monthToSet;
		mydate.MonthToSetpStr= MyMonth.values()[monthToSet].toString();
		
		if(currentYear != yearToSet) 
		{
			//System.out.println(currentYear);
			//System.out.println(yearToSet);
			return (currentYear < yearToSet) ? true : false;
		}
		else 
		{
			//System.out.println(curretMontch);
			//System.out.println(monthToSet);
			return (curretMonth < monthToSet) ? true : false;
		}
	
	}
	
	public static String getCurrentMontchFromWebPage(WebDriver driver) 
	{
		WebElement currentMonthWebElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		String currentmonth=currentMonthWebElement.getText();
		return currentmonth; 
	}
	
	public static String getCurrentYearFromWebPage(WebDriver driver) 
	{
		WebElement currentyearWebElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
		String currentYear=currentyearWebElement.getText();
		return currentYear; 
	}
	
	public static void main(String[] args) {

	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://jqueryui.com/datepicker/");
	//driver.manage().window().maximize();
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	
	
	String dayToSet = "30";
	String monthToSet = "08"; //months below 10 must be provided as e.g. January 01, February 02, 11 December e.t.c
	String yearToSet = "2025";
	String date = dayToSet +"/"+monthToSet+"/"+yearToSet;
	
	date mydateValue = new date(0,0);
	
	
	boolean  forward = checkifsearchForwardaAndUpdateMydate(driver, date, mydateValue);
	
	
	String a1 = getCurrentMontchFromWebPage(driver);
	String getCurrentYearFromWebPagee = getCurrentYearFromWebPage(driver);
	
	System.out.println("currentMonth ? "+mydateValue.currentMonth);
	System.out.println("MonthToSet ? "+mydateValue.MonthToSetp);
	System.out.println("yearToSet ? "+yearToSet);
	System.out.println("getCurrentYearFromWebPagee ? "+Integer.parseInt(getCurrentYearFromWebPagee));
	System.out.println("yearToSet ? "+Integer.parseInt(yearToSet));
	System.out.println("yearToSet < getCurrentYearFromWebPagee? "+ (Integer.parseInt(yearToSet)<Integer.parseInt(getCurrentYearFromWebPagee)));
	System.out.println("forward search ? "+forward+"\n");

	//sleep(1);

	
	
	while(!(a1.equals(mydateValue.MonthToSetpStr)) || !((Integer.parseInt(yearToSet) == Integer.parseInt(getCurrentYearFromWebPagee))))
	{
		//sleep(1);
		System.out.println("xx");
		//System.out.println("getCurrentMontchFromWebPage |" + getCurrentMontchFromWebPage(driver)+"|");
		//System.out.println("date  |" + mydateValue.MonthToSetpStr+"|");
		
		if(forward)
		{
			System.out.println("forward");
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		else 
		{
			System.out.println("backward");
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		a1 = getCurrentMontchFromWebPage(driver);
		getCurrentYearFromWebPagee = getCurrentYearFromWebPage(driver);
		System.out.println("getCurrentYearFromWebPagee ? "+Integer.parseInt(getCurrentYearFromWebPagee));
		System.out.println("yearToSet ? "+Integer.parseInt(yearToSet));
		System.out.println("yearToSet <getCurrentYearFromWebPagee? "+ (Integer.parseInt(yearToSet)<Integer.parseInt(getCurrentYearFromWebPagee))+"\n");
	}
	
	
	//WebElement zbc = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
	//WebElement zbc2 = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
	//sleep(5);
	//driver.close();
	
	System.out.println("end");
	
	
	}
}
