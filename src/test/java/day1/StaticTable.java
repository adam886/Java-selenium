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



public class StaticTable {
	public static void sleep(int t) 
	{
		try {
			  Thread.sleep(t * 1000);
			} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
			}
	}
	
	public static void main(String[] args) {


		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		List<WebElement> clickbuttons = driver.findElements(By.xpath("//ul[@id='pagination']/*"));
		int clickbuttonsSize= clickbuttons.size();
		System.out.println("clickbuttons " + clickbuttonsSize);
		
		List<WebElement> nrOfrows = driver.findElements(By.xpath("//table[@id='productTable']//tr/td[*]"));
		System.out.println("nrOfrows " + nrOfrows.size());
		
		List<WebElement> nrOfcols = driver.findElements(By.xpath("//table[@id='productTable']//tr"));
		System.out.println("nrOfcols " + nrOfcols.size()+"\n");
		//WebElement clickbutton=driver.findElement(By.xpath("//div[@class='main-outer']//li[1]"));
		//System.out.println(myElement.getText());
		
		//ul[@id='pagination']/li[text(),contains(),"1"]
		
		for(int k = 2;k<=clickbuttonsSize+1;k++)
		{
			for(int i = 1;i<nrOfrows.size()+1;i++)
			{
				for(int j = 2;j<nrOfcols.size()-2;j++)
				{
					WebElement myEl=driver.findElement(By.xpath("//table[@id='productTable']//tr["+i+"]//td["+j+"]"));
					System.out.println(myEl.getText());
				}
				System.out.println("---------------------");
			}
			if(k<5)
				{
				WebElement el = driver.findElement(By.xpath("//div[@class='main-outer']//li["+k+"]"));
				el.click();
				System.out.println("*----------------------*"+el.getText());
				}
			
			
			sleep(1);
		}
		
		sleep(3);
		driver.close();
	}

}
