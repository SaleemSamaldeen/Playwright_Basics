package week2.day2;

import java.util.function.Consumer;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlerts {

	@Test
	public void handle_alerts() throws InterruptedException {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();		
		page.navigate("http://leafground.com/alert.xhtml");		
		
		
		//Code for on dialog
		Consumer<Dialog> onDialogAction = new Consumer<Dialog>() {
			@Override
			public void accept(Dialog dialog) {
				String message = dialog.message();
				System.out.println("On Dialog "+message);
				dialog.accept();
			}
		};
		
		//Once Dialog
		page.onceDialog(dialog->{
			String message = dialog.message();
			System.out.println("Once Dialog "+message);
			dialog.accept();
		});	
		
		page.locator("//h5[text()=' Alert (Simple Dialog)']/following::span[2]").click();
		
		//On dialog 
		page.onDialog(onDialogAction);
		
		
		page.locator("//h5[text()=' Alert (Confirm Dialog)']/following::span[2]").click();
		
		//Off dialog 
		page.offDialog(onDialogAction);
		
		//OnceDialog
		page.onceDialog(dialog->{
			String message = dialog.message();
			System.out.println("Once Dialog "+message);
			dialog.accept();
		});		
		
		page.locator("//h5[text()=' Alert (Simple Dialog)']/following::span[2]").click();
					
		page.close();
		browser.close();
		pw.close();
	}

}
