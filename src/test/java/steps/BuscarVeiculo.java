package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuscarVeiculo {

	private WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\halis\\Desenvolvimento\\drivers\\chromedriver_87.exe");
		driver = new ChromeDriver();
	}

	@Given("O usuario logado no site webmotors")
	public void o_usuario_logado_no_site_webmotors() {
		driver.get("https://www.webmotors.com.br/");
	}

	@When("O usuario escolhe {string} do veiculo")
	public void o_usuario_escolhe_do_veiculo(String marca_modelo) throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@id=\"searchBar\"]")).sendKeys(marca_modelo);
	    Thread.sleep(5000);
	    driver.findElement(By.className("SearchBar__results__result__name")).click();	    
	}

	@Then("Validar {string} da consulta do veiculo escolhido")
	public void validar_da_consulta_do_veiculo_escolhido(String resultado) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[3]/h1")).getText().toString().contains(resultado);
		String qtdEstoque = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[3]/div[1]/p/strong\n")).getText();
		System.out.println("Existem " + qtdEstoque + " veiculo selecionado em estoque");
	}

	@After
	public void fecha_browser() {
		driver.quit();
	}

}
