package week2.day2;

import java.util.concurrent.LinkedBlockingQueue;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleFrames {
	
	@Test
	public void handle_frames() throws InterruptedException {
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://leafground.com/frame.xhtml");
		
		FrameLocator frame = page.frameLocator("//h5[text()=' Click Me (Inside frame)']/following::iframe[1]");
		frame.locator("//button[text()='Click Me']").click();
		
		
		//parent iframe 
		//h5[text()=' Click Me (Inside Nested frame)']/following::iframe
		
		//child iframe
		//#frame2
		
		FrameLocator parentFrame = page.frameLocator("//h5[text()=' Click Me (Inside Nested frame)']/following::iframe");
		FrameLocator childFrame = parentFrame.frameLocator("#frame2");
		childFrame.locator("//button[text()='Click Me']").click();
		
		
		Thread.sleep(5000);
		
	}

}
