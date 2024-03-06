package newTestCaseAlmosaferWeb;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	
	WebDriver driver =new ChromeDriver();
	String[] myUrl= {"https://www.almosafer.com/ar/","https://www.almosafer.com/en"};
	Random rand = new Random();
	int index=rand.nextInt(myUrl.length);

	@BeforeTest
	public void beforeTest() {
		driver.get(myUrl[index]);
		driver.manage().window().maximize();
		
		WebElement welcomeScreen=driver.findElement(By.className("cta__saudi"));
		welcomeScreen.click();
		
	}
	@Test()
	public void myTest() throws InterruptedException
	{
		Thread.sleep(20000);
		List<WebElement> originAndDestinationCity=driver.findElements(By.className("sc-ifAKCX"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		originAndDestinationCity.get(0).click();
		
        Thread.sleep(4000);
        
		WebElement citiesList=driver.findElement(By.cssSelector(".sc-gzVnrw.jIeOgV.AutoComplete__List"));
		List<WebElement> allCities=citiesList.findElements(By.tagName("li"));
		int randomIndex=rand.nextInt(1,allCities.size());
		
		allCities.get(randomIndex).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		originAndDestinationCity.get(1).click();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement allTheCities=driver.findElement(By.cssSelector(".sc-gzVnrw.jIeOgV.AutoComplete__List"));
		List<WebElement> theCities=allTheCities.findElements(By.tagName("li"));
		int randIndex=rand.nextInt(1,theCities.size());
		
		theCities.get(randIndex).click();
		
		Thread.sleep(4000);
		
		WebElement departureDate=driver.findElement(By.className("sc-kqlzXE"));
		departureDate.click();
		
		
		List<WebElement> allDates=driver.findElements(By.className("DayPicker-Day"));
		allDates.get(20).click();
		
		Thread.sleep(2000);
		
		allDates.get(30).click();
		
		WebElement element=driver.findElement(By.xpath("//div[@class='sc-fAJaQT kxzgEA']"));
		element.click();
		
		
		WebElement theListContainer=driver.findElement(By.className("sc-eAudoH"));
		theListContainer.click();
		
		Thread.sleep(3000);
				
		WebElement SearchButton=driver.findElement(By.cssSelector("div[class='sc-hizQCF yTOfA d-none d-md-block'] button[type='button']"));
		SearchButton.click();
		
	}
	@AfterTest
	public void postTest()
	{}

}
