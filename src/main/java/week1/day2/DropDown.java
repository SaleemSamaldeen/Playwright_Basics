package week1.day2;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Video;
import com.microsoft.playwright.options.SelectOption;

public class DropDown {

	@Test
	public void dropdown() throws InterruptedException {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		//BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("login_leaftaps.json")));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		Page page = context.newPage();
		Video video = page.video();
		//		page.navigate("http://www.amazon.in");
		page.navigate("http://leaftaps.com/opentaps");
		Locator locator = page.locator("id=username");
		locator.type("democsr");
		page.locator("#password").type("crmsfa");
		page.locator(".decorativeSubmit").click();
		page.locator("text=CRM/SFA").click();
		//		Thread.sleep(2000);
		//		page.screenshot(new Page.ScreenshotOptions()
		//				.setFullPage(true)
		//				.setPath(Paths.get("snaps/screenshot1.png")));
		page.locator("role=link[name='Leads']").click();
		page.locator("//a[text()='Create Lead']").click();
		page.type("#createLeadForm_companyName", "TL Industries");
		page.locator("#createLeadForm_firstName").type("Sooraj");
		page.locator("#createLeadForm_lastName").type("Krishna");
		Locator sourceDD = page.locator("#createLeadForm_dataSourceId");
		Locator sourceOptions = sourceDD.locator("option");
		sourceDD.selectOption("LEAD_TRADESHOW");

		sourceDD.selectOption(new SelectOption().setIndex(3));
		sourceDD.selectOption(new SelectOption().setLabel("Partner"));
		//		Thread.sleep(10000);

		page.click(".smallSubmit");

		String textContent = page.locator("#viewLead_firstName_sp").textContent();

		System.out.println(textContent);

		page.close();
		video.saveAs(Paths.get("videos/createlead1"+System.currentTimeMillis()+".webm"));
		video.delete();
		context.close();
		browser.close();
		pw.close();

	}

}
