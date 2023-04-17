package week3.day2;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class LearnTraceViewer {

	@Test
	public void get_network_data() throws InterruptedException {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType
				.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		BrowserContext context = browser.newContext();
		
		context.tracing().start(new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true));

		Page page = context.newPage();

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
		
		context.tracing().stop(new Tracing.StopOptions()
				.setPath(Paths.get("trace.zip")));

		/* To Open trace viewer */
		/* Go to trace.zip folder and run below cmd */
		/*  mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip" */
		
		
		page.close();
		context.close();
		browser.close();
		pw.close();



	}

}
