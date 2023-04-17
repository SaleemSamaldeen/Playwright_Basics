package week3.day1;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.DragToOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.BoundingBox;

public class LearnDragAndDrop {
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		
		
		Playwright pw = Playwright.create();

		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		Page page = browser.newPage();
		
//		page.navigate("https://jqueryui.com/droppable/");
//		
//		FrameLocator frame = page.frameLocator(".demo-frame");
//		
//		Locator draggable = frame.locator("#draggable");
//		Locator droppable = frame.locator("#droppable");
//		
//		draggable.dragTo(droppable);
//		
//		BoundingBox bound = draggable.boundingBox();
//		
//		System.out.println(bound.x);
//		System.out.println(bound.y);
		
		
		page.navigate("https://jqueryui.com/draggable/");
		FrameLocator frame = page.frameLocator(".demo-frame");
		Locator draggable = frame.locator("#draggable");
		
		DragToOptions setTargetPosition = new Locator.DragToOptions().setTargetPosition(50, 50);
		
		draggable.dragTo(draggable, setTargetPosition);
		
		Thread.sleep(5000);
		
	}

}
