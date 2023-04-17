package week1.day2;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DeleteLead {

	@Test
	public void deleteLead() throws InterruptedException {
		
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int width = screenSize.width;
//		int height = screenSize.height;
		
		
//		GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//		int width = defaultScreenDevice.getDisplayMode().getWidth();
//		int height = defaultScreenDevice.getDisplayMode().getHeight();
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		//BrowserContext context = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "testleaf"));
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("login_leaftaps.json")));
		Page page = context.newPage();
		
		//page.setViewportSize(width, height);
		
		//page.navigate("https://leafground.com/auth.xhtml");
		
		//page.click("//span[text()='Basic Auth']");

		// navigate to --> http://leaftaps.com/opentaps
		page.navigate("http://leaftaps.com/opentaps");
//		// Type Username
//		page.locator("#username").type("demosalesmanager");
//		// Type Password
//		page.locator("#password").type("crmsfa");
//		// Click on Login
//		page.locator(".decorativeSubmit").click();
//		// Click on CRM/SFA
//		
//		context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("login_leaftaps.json")));
		page.locator("text=CRM/SFA").click();
		// Click on Leads 
		
		page.goBack();
		
		String title = page.title();
		System.out.println("Page Title is: "+title);
		
		String url = page.url();
		System.out.println("Page url is: "+url);
		
		
		page.goForward();
		
		
		// Click on Leads 
		page.locator("//a[text()='Leads']").click();
		// Click on Find Leads - Left Nav bar 
		page.locator("//a[text()='Find Leads']").click();
		// Click on Phone 
		page.locator("//span[text()='Phone']").click();
		// Type Phone Number 
		page.locator("[name='phoneCountryCode']").fill("");
		page.locator("[name='phoneCountryCode']").type("91");
		// Click on FInd leads Button
		page.locator("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		// Get the First lead id name 
		Locator leadId = page.locator("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		int count = leadId.count();
		
		List<String> allInnerTexts = leadId.allInnerTexts();
		
		for (String string : allInnerTexts) {
			System.out.println(string);
		}
		
		String leadIdText = leadId.first().innerText();
		// Click on first lead id 
		leadId.first().click();
		// Click on Delete lead button in the view lead page 
		page.locator(".subMenuButtonDangerous").click();
		// Click on Find Leads - Left Nav bar 
		page.locator("//a[text()='Find Leads']").click();
		// Type lead Id 
		page.locator("//label[text()='Lead ID:']/../div/input").type(leadIdText);
		// Click on Find Leads 
		page.locator("//button[text()='Find Leads']").click();
		// Confirm that you got "No records to display" message in the result
		String innerText = page.locator(".x-paging-info").innerText();
		System.out.println(innerText);

	}

}
