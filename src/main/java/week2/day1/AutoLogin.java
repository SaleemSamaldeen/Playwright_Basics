package week2.day1;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoLogin {
	
	@Test
	public void auto_login() {
		
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(false));
		
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions()
				.setStorageStatePath(Paths.get("login_leaftaps.json"))
				);
		Page page = context.newPage();
		
		page.navigate("http://leaftaps.com/opentaps");
		page.locator("text=CRM/SFA").click();
		page.locator("role=link[name='Leads']").click();
		page.locator("//a[text()='Create Lead']").click();
		page.type("#createLeadForm_companyName", "TL Industries");
		page.locator("#createLeadForm_firstName").type("Sooraj");
		page.locator("#createLeadForm_lastName").type("Krishna");
		page.click(".smallSubmit");
		
		String textContent = page.locator("#viewLead_firstName_sp").textContent();
		
		System.out.println(textContent);
		
		pw.close();
		
	}

}
