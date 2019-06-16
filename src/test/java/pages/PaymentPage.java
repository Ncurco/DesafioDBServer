package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
	WebDriver driver;
	public PaymentPage( WebDriver d) {
		this.driver =d;
	}
	
	public void shipping() {
		WebElement bCGV = driver.findElement(By.name("cgv"));
		bCGV.click();
		WebElement processCarrier = driver.findElement(By.name("processCarrier"));
		processCarrier.click();
	}
	public double getValor() {
		WebElement valor = driver.findElement(By.id("total_price"));
		return Double.parseDouble(valor.getText().replace("$", " "));
	}
	public void pay() {
		WebElement bCGV = driver.findElement(By.className("cheque"));
		bCGV.click();
		WebElement processCarrier = driver.findElement(By.cssSelector(".cart_navigation .button-medium"));
		processCarrier.click();
	}
}
