package week2.day2;

import java.util.function.Consumer;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlerts2 {

	@Test
	public void handle_alerts() throws InterruptedException {

		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
				.setChannel("chrome").setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://leafground.com/alert.xhtml");
		
		Consumer<Dialog> alert = new Consumer<Dialog>() {

			@Override
			public void accept(Dialog dialog) {
				String message = dialog.message();
				System.out.println(message);
				dialog.accept(message);
				page.offDialog(this);
			}
			
		};
		
		page.onDialog(alert);

//		page.onDialog(dialog -> {
//			String message = dialog.message();
//			System.out.println(message);
//			dialog.accept(message);
//		});

		page.locator("(//h5[text()=' Alert (Simple Dialog)']/following::span)[2]").click();

		page.locator("//h5[text()=' Alert (Confirm Dialog)']/following::span[2]").click();


		Thread.sleep(5000);

	}

}
