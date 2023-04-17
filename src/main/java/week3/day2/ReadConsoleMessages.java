package week3.day2;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReadConsoleMessages {
	
	@Test
	public void read_console_messages() throws InterruptedException {
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType
				.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		Page page = browser.newPage();
		
		page.onConsoleMessage(handler -> {
			String text = handler.text();
			String type = handler.type();
			String url = page.url();
			
			if(type.equals("log")) {
			System.out.println("url is : "+ url);	
			System.out.println(type+"::::::::::::"+text);
			}
			
		});
		
		page.navigate("https://www.redbus.in/");
		
		page.navigate("https://www.geeksforgeeks.org/");
		
		
		Thread.sleep(5000);
		
	}

}
