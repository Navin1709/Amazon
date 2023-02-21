package Project.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Amazon extends Base_Class {
	
	public static void main(String[] args) throws Throwable {

		browser_Launch("chrome");
		get("https://www.amazon.in/?ext_vrnc=hi&tag=googhydrabk1-21&ref=nav_custrec_signin&adgrpid=60571832564&hvpone=&hvptwo=&hvadid=486387378181&hvpos=&hvnetw=g&hvrand=6432633785036360672&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007809&hvtargid=kwd-296458789801&hydadcr=14452_2154371&gclid=CjwKCAiAh9qdBhAOEiwAvxIok4p3jrPrLbCdgd8Y6zENlI1OZZSX7_ndTOgQ96dL0ITFAQYxgvbltRoCkfQQAvD_BwE");
		maximize_The_Window();
		hold();

		WebElement sign_in = driver.findElement(By.id("nav-link-accountList"));
		click(sign_in);
		WebElement email = driver.findElement(By.id("ap_email"));
		sendKeys(email, "naveenkumar17099@gmail.com");

		WebElement click = driver.findElement(By.id("continue"));
		click(click);

		WebElement password = driver.findElement(By.id("ap_password"));
		sendKeys(password, "navin1709");

		WebElement login = driver.findElement(By.id("signInSubmit"));
		click(login);

		WebElement dropDown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
		drop_Down(dropDown, "visibletext", "Electronics");

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		sendKeys(search, "wierd earphone");

		WebElement search_Click = driver.findElement(By.xpath("//input[@value='Go']"));
		click(search_Click);

		hold();

		get("https://www.amazon.in/boAt-BassHeads-100-Headphones-Black/dp/B071Z8M4KX/ref=sr_1_1_sspa?crid=5Q0KNFWTZFWN&keywords=wired+earphones&qid=1675950413&s=electronics&sprefix=wire%2Celectronics%2C288&sr=1-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");

		WebElement add_To_Cart = driver.findElement(By.id("add-to-cart-button"));
		click(add_To_Cart);

		WebElement cart = driver.findElement(By.id("nav-cart"));
		click(cart);

		WebElement check_Out = driver.findElement(By.name("proceedToRetailCheckout"));
		click(check_Out);

		WebElement address = driver.findElement(By.xpath("//input[@data-testid='Address_selectShipToThisAddress']"));
		click(address);

		WebElement radio_Button = driver.findElement(By.xpath("(//input[@name='ppw-instrumentRowSelection'])[5]"));
		click(radio_Button);

		WebElement payment = driver.findElement(By.name("ppw-widgetEvent:SetPaymentPlanSelectContinueEvent"));
		click(payment);

		WebElement order_Placed = driver.findElement(By.name("placeYourOrder1"));
		click(order_Placed);

		hold();

		takeScreenShot("orderPlaced");

	}
	

}
