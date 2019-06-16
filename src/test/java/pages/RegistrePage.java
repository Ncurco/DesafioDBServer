package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrePage {
	WebDriver driver;
	WebDriverWait espera;
	public RegistrePage(WebDriver d) {
		this.driver = d;
		espera = new WebDriverWait(driver, 40);
	}
	
	public void login() {
		WebElement email = espera.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		email = driver.findElement(By.id("email"));
		email.sendKeys("desafioDB@mail.com");
		WebElement pass = driver.findElement(By.id("passwd"));
		pass.sendKeys("12345");
		WebElement bLogin = driver.findElement(By.id("SubmitLogin"));
		bLogin.click();
	}
	
	public void newLogin() {
		WebElement txtEmail = espera.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));
		txtEmail = driver.findElement(By.id("email_create"));
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
		txtEmail.sendKeys("desafioDB"+ formatter.format(d).toString().replaceAll("-", "").replaceAll(":", "")+"@mail.com");
		WebElement bCad = driver.findElement(By.cssSelector(".button.button-medium.exclusive"));
		bCad.click();
		WebElement txtFNameCustomer = espera.until(ExpectedConditions.elementToBeClickable(By.id("customer_firstname")));
		txtFNameCustomer = driver.findElement(By.id("customer_firstname"));
		txtFNameCustomer.sendKeys("Nicolas");
		WebElement txtLNameCustomer = driver.findElement(By.id("customer_lastname"));
		txtLNameCustomer.sendKeys("Curço");
		WebElement txtPass = espera.until(ExpectedConditions.elementToBeClickable(By.id("passwd")));
		txtPass = driver.findElement(By.id("passwd"));
		txtPass.sendKeys("12345");
		WebElement txtAddress = driver.findElement(By.id("address1"));
		txtAddress.sendKeys("Street A");
		WebElement txtCity = driver.findElement(By.id("city"));
		txtCity.sendKeys("New York City");
		Select selState = new Select(driver.findElement(By.id("id_state")));
		selState.selectByValue("32");
		WebElement txtZip = driver.findElement(By.id("postcode"));
		txtZip.sendKeys("10024");
		WebElement txtMobilePhone = driver.findElement(By.id("phone_mobile"));
		txtMobilePhone.sendKeys("1 212-310-6600");
		WebElement txtAlias = driver.findElement(By.id("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Street B");
		WebElement bSubmitCustomer = driver.findElement(By.id("submitAccount"));
		bSubmitCustomer.click();
	}
}
