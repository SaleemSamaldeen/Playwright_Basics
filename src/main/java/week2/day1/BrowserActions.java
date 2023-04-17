package week2.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserActions {
	
	@Test
	public void browser_actions() {
		
		//Initialise the playwright
		
		//Interface ---> Concrete class (Interface name +Impl)
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		Page page = browser.newPage();
		page.setViewportSize(1920, 1200);
		
	
		
		page.navigate("http://leaftaps.com/opentaps");
		
		Locator locator = page.locator("id=username");
		locator.type("demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.locator(".decorativeSubmit").click();
		page.locator("text=CRM/SFA").click();
		
		page.goBack();
		
		String title = page.title();
		
		System.out.println(title);
		
		String url = page.url();
		
		System.out.println(url);
		
		page.goForward();
		
		
		page.locator("role=link[name='Leads']").click();
		page.locator("//a[text()='Create Lead']").click();
		page.type("#createLeadForm_companyName", "TL Industries");
		page.locator("#createLeadForm_firstName").type("Sooraj");
		String inputValue = page.locator("#createLeadForm_firstName").inputValue();
		System.out.println(inputValue);
		page.locator("#createLeadForm_lastName").type("Krishna");
		page.click(".smallSubmit");
		
		String textContent = page.locator("#viewLead_firstName_sp").textContent();
		
		System.out.println(textContent);
		
		pw.close();
		
	}

}
