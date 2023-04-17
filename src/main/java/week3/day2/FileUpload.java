package week3.day2;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUpload {
	
	@Test
	public void file_upload() throws InterruptedException {
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType
				.LaunchOptions()
				.setChannel("chrome")
				.setHeadless(false));

		Page page = browser.newPage();
		
		
		page.navigate("https://leafground.com/file.xhtml");
		
		page.locator("(//h5[text()='Basic Upload']/following::input)[2]")
		.setInputFiles(Paths.get("login_leaftaps.json"));
		
		Download download = page.waitForDownload(() ->{
			page.locator("(//h5[text()='Basic Download']/following::span)[2]").click();
		});
		
		
		String url = download.url();
		
		System.out.println(url);
		
		Path path = download.path();
		
		System.out.println(path);
		
		Thread.sleep(5000);
		
	}

}
