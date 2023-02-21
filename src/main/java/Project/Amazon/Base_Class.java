package Project.Amazon;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {
	
	public static WebDriver driver;

	public static WebDriver browser_Launch(String a) {

		if (a.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\Naveenproject\\src\\com\\navin\\Maven_Project\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (a.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\Naveenproject\\src\\com\\navin\\Maven_Project\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (a.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\Naveenproject\\src\\com\\navin\\Maven_Project\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static void get(String url) {
		driver.get(url);

	}

	public static void maximize_The_Window() {
		driver.manage().window().maximize();
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void navigate_To(String url) {
		driver.navigate().to(url);
	}

	public static void navigate_Forward() {
		driver.navigate().forward();
	}

	public static void navigate_Back() {
		driver.navigate().back();
	}

	public static void navigate_Refresh() {
		driver.navigate().refresh();
	}

	public static void alert(String condition) {

		if (condition.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (condition.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		} else if (condition.equalsIgnoreCase("get_Text")) {
			driver.switchTo().alert().getText();
		}
	}

	public static void alert_Sendkeys(String input) {
		driver.switchTo().alert().sendKeys(input);

	}

	public static void action(WebElement element, String s) {

		Actions act = new Actions(driver);
		if (s.equalsIgnoreCase("contextclick")) {
			act.contextClick(element).build().perform();
		} else if (s.equalsIgnoreCase("doubleclick")) {
			act.doubleClick(element).build().perform();
		} else if (s.equalsIgnoreCase("clickandhold")) {
			act.clickAndHold(element).build().perform();
		} else if (s.equalsIgnoreCase("release")) {
			act.release(element).build().perform();
		} else if (s.equalsIgnoreCase("movetoelement")) {
			act.moveToElement(element).build().perform();
		}
	}

	public static void drag_And_Drop(WebElement source, WebElement destination) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).build().perform();
	}

	public static void drop_Down(WebElement element, String select, String input) {
		Select s = new Select(element);

		if (select.equalsIgnoreCase("visibletext")) {
			s.selectByVisibleText(input);
		} else if (select.equalsIgnoreCase("value")) {
			s.selectByValue(input);
		} else if (select.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(input));
		}
	}

	public static void takeScreenShot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"C:\\Users\\ELCOT\\eclipse-workspace\\Naveenproject\\src\\com\\navin\\Maven_Project\\Project_Screenshot\\"
						+ filename + ".jpeg");
		FileUtils.copyFile(src, des);
	}

	public static void is_Enable(WebElement element) {
		element.isEnabled();
		if (element.isEnabled()) {
			System.out.println("Enabled :" + element.isEnabled());
		} else {
			System.out.println("Not Enabled :" + element.isEnabled());
		}
	}

	public static void is_Display(WebElement element) {
		element.isDisplayed();
		if (element.isDisplayed()) {
			System.out.println("Displayed :" + element.isDisplayed());
		} else {
			System.out.println("Not Displayed :" + element.isDisplayed());
		}
	}

	public static void is_Selected(WebElement element) {
		element.isSelected();
		if (element.isSelected()) {
			System.out.println("Selected :" + element.isSelected());
		} else {
			System.out.println("Not Selected :" + element.isSelected());
		}
	}

	public static void hold() throws Throwable {
		Thread.sleep(2000);
	}

	public static void get_Title() {
		System.out.println("Page title is :" + driver.getTitle());
	}

	public static void get_Currenturl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void get_Attribute(WebElement element, String input) {
		System.out.println("Attribute is :" + element.getAttribute(input));

	}

	public static void sendKeys(WebElement element, String input) {
		element.sendKeys(input);
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void scrollUsingElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollUsingCoOrdinates(String width, String height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.scrollTo(" + width + "," + height + ")");
	}

	public static void scrollToTopOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}

	public static void scrollToBottomOfThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public static void scrollAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click();", element);
	}

	public static void get_First_SelectedOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println("getFirstSelectedOption is :" + text);
	}

	public static void get_All_Selected_Option(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		int size = options.size();
		for (int i = 0; i < size; i++) {
			String text = options.get(i).getText();
			System.out.println(text);
		}
	}

}
