package week3.day1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.Base64;

public class Screenshot {

	@Test
	public void screenshot() {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(
				new BrowserType.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));
		
		 BrowserContext context = browser.newContext(new Browser.NewContextOptions()
			        .setDeviceScaleFactor(2)
			        .setHasTouch(true)
			        .setIsMobile(true)
			        .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1")
			        .setViewportSize(414, 715));
		

		// Open page and load URL
		Page page = context.newPage();
		
		// Load the page with URL
		page.navigate("https://redbus.in");
		
		page.screenshot(
				new Page.ScreenshotOptions()
				.setFullPage(true)
				.setPath(Paths.get("snaps/lg_page.png")));
		
		/*
		page.locator("#message").screenshot(
				new Locator.ScreenshotOptions()
				.setPath(Paths.get("snaps/lg_element.png"))
				); */
		
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		byte[] screenshot = page.screenshot();
		byte[] encode = Base64.getEncoder().encode(screenshot);
		System.out.println(new String(encode));
		

	}

}
