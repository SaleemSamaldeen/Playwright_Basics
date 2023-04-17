package week3.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NetworkData {

	@Test
	public void get_network_data() throws InterruptedException {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType
				.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();

		Page page = context.newPage();

		page.onRequest(handler ->{
			String method = handler.method();

			String url = handler.url();
			
			String postData = handler.postData();

			//System.out.println(url+"::::::::::"+method);

			if(url.contains("createRecord=1")) {
				System.out.println(url+"::::::::::"+
			    method+":::::::"+postData+"::::::"+handler.response().status());
			}
		});
		
//		page.onResponse(handler ->{
//			String url = handler.url();
//			int status = handler.status();
//			String statusText = handler.statusText();
//			if(url.contains("createRecord=1")) {
//				System.out.println(status+":::::"+statusText);
//			}
//		});

		page.navigate("https://login.salesforce.com");

		page.type("#username", "soorajlearn@gmail.com");
		page.type("#password", "Password#123");
		page.click("#Login");
		page.click(".slds-icon-waffle");
		page.click("//p[text()='Service']");
		page.click("//span[text()='Accounts']");
		page.click("//div[@title='New']");
		page.type("(//input[@class='slds-input'])[2]", "Sooraj");
		page.click("//button[text()='Save']");


		Thread.sleep(5000);







		Thread.sleep(5000);

	}

}
