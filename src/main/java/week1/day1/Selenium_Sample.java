package week1.day1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Selenium_Sample {
	
	@Test
	public void test1() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//*[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[text()='Advanced']/following::input)[2]")).sendKeys("Babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-col x-grid3-cell')]//div/a)[1]")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.name("submitButton")).click();
		String innerText = driver.findElement(By.cssSelector("#viewLead_companyName_sp")).getText();
		System.out.println(innerText);
		driver.quit();
		
	}

}
