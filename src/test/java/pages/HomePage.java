package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import objects.Product;

public class HomePage {
	static WebDriver driver;
	WebDriverWait espera;

	public HomePage(WebDriver d) {
		driver = d;
		espera = new WebDriverWait(driver, 40);
	}
	
	public Product addPrimeiroItem() {
		WebElement bAddCarrinho = driver.findElement(By.cssSelector(".button.ajax_add_to_cart_button"));//layer_cart_product_title
		bAddCarrinho.click();
		WebElement itemNome = espera.until(ExpectedConditions.elementToBeClickable(By.id("layer_cart_product_title")));
		itemNome = driver.findElement(By.id("layer_cart_product_title"));
		WebElement itemValor = driver.findElement(By.id("layer_cart_product_price"));
		Product p = new Product(itemNome.getText().toString(), Double.parseDouble(itemValor.getText().replace("$","").trim()));
		return p;
	}
	
	public void goCheckout() {
		WebElement bCheckout = driver.findElement(By.cssSelector("#layer_cart .layer_cart_cart .button-container .button.button-medium"));
		bCheckout.click();
	}
}
