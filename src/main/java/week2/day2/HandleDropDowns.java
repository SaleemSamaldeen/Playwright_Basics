package week2.day2;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class HandleDropDowns {
	
	@Test
	public void browser_actions() throws InterruptedException {
		Playwright pw = Playwright.create();
		
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("http://leaftaps.com/opentaps");
		
		Locator locator = page.locator("id=username");
		locator.type("demosalesmanager");
		page.locator("#password").type("crmsfa");
		page.locator(".decorativeSubmit").click();
		page.locator("text=CRM/SFA").click();
		page.locator("role=link[name='Leads']").click();
		page.locator("//a[text()='Create Lead']").click();
		page.type("#createLeadForm_companyName", "TL Industries");
		page.locator("#createLeadForm_firstName").type("Sooraj");
		page.locator("#createLeadForm_lastName").type("Krishna");
		//page.locator("#createLeadForm_dataSourceId").selectOption("LEAD_EXISTCUST");
		
//		Locator sourceDD = page.locator("#createLeadForm_dataSourceId");
//		
//		Locator optionsDD = sourceDD.locator("option");
//		
//		List<String> allInnerTexts = optionsDD.allInnerTexts();
//		
//		for (String string : allInnerTexts) {
//			System.out.println(string);
//		}
		
		page.locator("#createLeadForm_dataSourceId")
		.selectOption(new SelectOption().setIndex(3));
		page.click(".smallSubmit");
		
		Thread.sleep(3000);
		
		String textContent = page.locator("#viewLead_firstName_sp").textContent();
		
		System.out.println(textContent);
		
		pw.close();
		
	}

}
