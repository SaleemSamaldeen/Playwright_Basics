package week2.day1;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DeleteLead {
	
	@Test
	public void deleteLead() throws InterruptedException {
		//Delete Lead 
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		
//		int height = (int)screenSize.getHeight();
//		int width = (int)screenSize.getWidth();
		Playwright pw = Playwright.create();
		
		GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		int width = defaultScreenDevice.getDisplayMode().getWidth();
		int height = defaultScreenDevice.getDisplayMode().getHeight();
		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("chrome")
				.setHeadless(false)
				);
		
		//playwright connection -> browser -> page
		
		Page page = browser.newPage();
		
		page.setViewportSize(width, height);
		
		
		page.navigate("http://leaftaps.com/opentaps");
		// Type Username
		page.locator("#username").type("demosalesmanager");
		// Type Password
		page.locator("#password").type("crmsfa");
		// Click on Login
		page.locator(".decorativeSubmit").click();
		// Click on CRM/SFA
		page.locator("text=CRM/SFA").click();
		// Click on Leads 
		page.locator("//a[text()='Leads']").click();
		// Click on Find Leads - Left Nav bar 
		page.locator("//a[text()='Find Leads']").click();
		// Click on Phone 
		page.click("//span[text()='Name and ID']");
		//input[@name='phoneCountryCode']
		Locator firstName = page.locator("(//input[@name='firstName'])[3]");
		firstName.type("Hari");
		
		Locator locator = page.locator("//button[text()='Find Leads']");
		
		locator.click();
		
		Thread.sleep(2000);
		
		Locator leadId = page.locator("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		
		String leadIdText = leadId.textContent();
		
		leadId.click();
		
//		int count = leadIds.count();
//		
//		System.out.println("count is "+count);
//		
//		leadIds.first().click();
//		
//		List<String> allInnerTexts = leadIds.allInnerTexts();
		
		
		page.click(".subMenuButtonDangerous");
		
		page.locator("//a[text()='Find Leads']").click();
		
		page.type("//input[@name='id']", leadIdText);
		page.locator("//button[text()='Find Leads']").click();
		
		
		String innerText = page.locator(".x-paging-info").innerText();
		
		System.out.println(innerText);
		
		page.close();
		browser.close();
		pw.close();
		
		
		
		
		
		
				
				
				
				
				// Type Phone Number 
				// Click on FInd leads Button
				// Get the First lead id name 
				// Click on first lead id 
				// Click on Delete lead button in the view lead page 
				// Click on Find Leads - Left Nav bar 
				// Type lead Id 
				// Click on Find Leads 
				// Confirm that you got "No records to display" message in the result
	}

}
