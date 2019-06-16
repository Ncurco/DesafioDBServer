package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objects.Address;

public class AddressPage {
	WebDriver driver;
	public AddressPage( WebDriver d) {
		this.driver =d;
	}
	
	public Address add() {
		
		WebElement webElement = driver.findElement(By.cssSelector(".address li.address_firstname"));
		String name = webElement.getText();
		webElement = driver.findElement(By.cssSelector(".address li.address_address1 "));
		String add = webElement.getText();
		webElement = driver.findElement(By.cssSelector(".address li.address_city"));   
		String city = webElement.getText().split(",")[0];
		String statePostal = webElement.getText().split(",")[1].trim();
		webElement = driver.findElement(By.cssSelector(".address li.address_country_name"));
		String country = webElement.getText();
		webElement = driver.findElement(By.cssSelector(".address li.address_phone_mobile"));
		String phone = webElement.getText();
		Address address = new Address(name, add,city,statePostal,country,phone);
		return address;	
	}
	
	public void goCheckout() {
		WebElement bAddress = driver.findElement(By.name("processAddress"));
		bAddress.click();
	}
}
