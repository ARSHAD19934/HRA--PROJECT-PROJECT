package xpathsession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathTestPrice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> mobilelist = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for(int i=0; i<mobilelist.size(); i++)
		{
			try {
				String name = mobilelist.get(i).getText();
				name=name.replace(",","");
				Integer n=Integer.valueOf(name);
				if(n<70000)
				{
					System.out.println(n);
				}
			}
			catch(Exception e)
			{
				
				}
			}
		}
	}


