package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objects.Address;
import objects.Product;
import pages.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DesafioDB {
	
	static WebDriver driver;
	List<Product> carrinho= new ArrayList<Product>();
	
	public static void main(String args[]) {
		  JUnitCore junit = new JUnitCore();
		  junit.addListener(new TextListener(System.out));
		  Result result = junit.run(DesafioDB.class); 
		  if (result.getFailureCount() > 0) {
		    System.out.println("Test failed.");
		    System.exit(1);
		  } else {
		    System.out.println("Test finished successfully.");
		    System.exit(0);
		  }
		}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		//1.Acessar o site: www.automationpractice.com.
		driver.get("http://automationpractice.com/index.php?");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validaCarrinhotest() throws InterruptedException {
		/*2.Escolha um produto qualquer na loja.
		  3.Adicione o produto escolhido ao carrinho.*/
		HomePage homePage = new HomePage(driver);
		carrinho.add(homePage.addPrimeiroItem());
		//4.Prossiga para o checkout.
		homePage.goCheckout();
		Thread.sleep(4000);
		CartPage cartPage = new CartPage(driver);
		Thread.sleep(2000);
		List<String> c = new ArrayList<String>();
		for(Product p: carrinho) {
			c.add(p.description);		
			}
		//5.Valide se o produto foi corretamente adicionado ao carrinho e prossiga caso esteja tudo certo.
		assertThat(c, CoreMatchers.equalTo(cartPage.CartProducts()));
		
	}

	@Test
	public void validaEnderecotest() throws InterruptedException {
		CartPage cartPage = new CartPage(driver);
		cartPage.goCheckout();
		//6.Realize o cadastro do cliente preenchendo todos os campos obrigatórios dos formulários.
		RegistrePage cad = new RegistrePage(driver);
		//cad.login();
		cad.newLogin();
		Address add = new Address("Nicolas Curço", "Street A", "New York City","New York 10024","United States","1 212-310-6600");
		AddressPage end = new AddressPage(driver);
		assertTrue(add.equals(end.add()));
	}
	
	@Test
	public void validaValor() throws InterruptedException {
		AddressPage end = new AddressPage(driver);
		end.goCheckout();
		PaymentPage pay = new PaymentPage(driver);
		pay.shipping();
		Double valor = pay.getValor();
		Double valorEsperado = 18.51;
		pay.pay();
		assertEquals(valor, valorEsperado);
	
	}
}
