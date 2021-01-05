package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\halis\\Desenvolvimento\\drivers\\chromedriver_87.exe");
		driver = new ChromeDriver();
	}
	
	@Given("O usuario acessa o site webmotors e aciona a opcao Entrar")
	public void o_usuario_acessa_o_site_webmotors_e_aciona_a_opcao_entrar(){		
		driver.get("https://www.webmotors.com.br/");	
		driver.findElement(By.id("userLoginRegister")).isDisplayed();		
	}

	@When("O usuario digita email valido e senha valida e aciona a opcao Entrar")
	public void o_usuario_digita_email_valido_e_senha_valida_e_aciona_a_opcao_entrar(){
		driver.get("https://login.webmotors.com.br/?&r=https://www.webmotors.com.br&inst=header:webmotors::logar-ou-cadastrar");
		driver.findElement(By.id("email")).sendKeys("ribeirovitorino.bernardo@gmail.com");
	    driver.findElement(By.id("senha")).sendKeys("Passaporte1");	    
	    driver.findElement(By.id("btnEntrar")).sendKeys(Keys.ENTER);
	}

	@Then("O site apresenta a tela de Consulta ao usuario")
	public void o_site_apresenta_a_tela_de_consulta_ao_usuario() throws InterruptedException {
		Thread.sleep(5000);	
	    driver.findElement(By.xpath("//*[@id=\"searchBar\"]")).isDisplayed();
	}
	
	@After
	public void fecha_browser() {
		driver.quit();
	}
	
}
