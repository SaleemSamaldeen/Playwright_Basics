package week3.day2;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScreenshotOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType
				.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		BrowserContext context = browser.newContext();
		
		Page page = context.newPage();
		
		page.navigate("https://www.amazon.in/");
		
		byte[] screenshot = page.screenshot( new Page.ScreenshotOptions()
				.setFullPage(true)
				.setPath(Paths.get("snaps/amazon_page.png")));
		
//		page.locator("#message").screenshot(new Locator.ScreenshotOptions()
//				.setPath(Paths.get("snaps/lg_element.png")));
		
		
		byte[] encode = Base64.getEncoder().encode(screenshot);
		System.out.println(new String(encode));
		
		
		
		
		page.close();
		context.close();
		browser.close();
		pw.close();

	}

}
