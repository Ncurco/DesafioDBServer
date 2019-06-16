package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver d) {
		this.driver = d;
	}	

	public List<String> CartProducts(){
		List<String> carrinho = new ArrayList<String>();
		List<WebElement> linhas = driver.findElements(By.tagName("tbody"));
		for(WebElement c: linhas) {
			carrinho.add(c.findElement(By.cssSelector("#cart_summary tbody td.cart_description")).getText().split("SKU")[0].trim());
		}
		return carrinho;		
	}
	
	public double getValor() {
		WebElement valor = driver.findElement(By.id("total_price"));
		valor = driver.findElement(By.id("total_price_container"));
		return Double.parseDouble(valor.getText().replace("$", " "));
	}
	
	public void goCheckout() {
		WebElement bCheckout = driver.findElement(By.cssSelector(".cart_navigation .button.button-medium "));
		bCheckout.click();
	}
}
