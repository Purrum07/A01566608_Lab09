package mx.tec.lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@SpringBootTest
class TestHtml2ApplicationTests {
	private static WebDriver driver;
	
	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mario\\Desktop\\Escuela\\Sexto Semestre\\Quality en Testing\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
	@Disabled
	@Test
	public void givenAClient_whenEnteringAutomationPractice_thenPageTitleIsCorrect() throws Exception {
		//When
		driver.get("http://automationpractice.com/index.php");
		String title = driver.getTitle();
		
		//Then 
		assertEquals("My Store", title);
	}
	@Disabled
	@Test
	public void givenAClient_whenEnteringLoginCredentials_thenAccountPageIsDisplayed() throws Exception {
		// When 
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("marioalex20007@hotmail.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("loco2");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		String title = driver.getTitle();
		
		//Then
		assertEquals("My account - My Store", title);	
		
	}
	@Disabled
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenAuthenticationPageIsDisplayed() throws Exception {
		// When 
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("marioalex2007@hotmail.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("loco");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		String title = driver.getTitle();
				
		//Then
		assertEquals("Login - My Store", title);	
		//fail("Test not yet implemented");
	}
	@Disabled
	@Test
	public void givenAClient_whenEnteringWrongLoginCredentials_thenErrorMessageIsDisplayed() throws Exception {
		// When 
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("marioalex27@hotmail.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("loco2");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		
		List<WebElement> alertMessage = driver.findElements(By.xpath("//div[@class='alert alert-danger']/ol/li"));
		String alertMessageText = alertMessage.get(0).getText();
		//Then
		assertEquals("Authentication failed.", alertMessageText);
		//fail("Test not yet implemented");
	}
	@Disabled
	@Test
	public void givenAClient_whenSearchingNotExistingProduct_thenNoResultIsDisplayed() throws Exception {
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("marioalex20007@hotmail.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("loco2");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		
		// When 
		WebElement searchInput = driver.findElement(By.id("search_query_top"));
		searchInput.sendKeys("pantalon");
		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();
				
		WebElement noResultMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
		String noResultMessageText = noResultMessage.getText();
								
		//Then
		assertEquals("No results were found for your search \"pantalon\"", noResultMessageText);
		//fail("Test not yet implemented");
		
	}
	@Disabled
	@Test
	public void givenAClient_whenSearchingEmptyString_thenPleaseEnterDisplayed() throws Exception {
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("marioalex20007@hotmail.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("loco2");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		
		// When 
		WebElement searchInput = driver.findElement(By.id("search_query_top"));
		searchInput.sendKeys("");
		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();
				
		WebElement pleaseEnterMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
		String pleaseEnterMessageText = pleaseEnterMessage.getText();
		//Then
		assertEquals("Please enter a search keyword", pleaseEnterMessageText);
		//fail("Test not yet implemented");
	}

	@Test
	public void givenAClient_whenSigningOut_thenAuthenticationPageIsDisplayed() throws Exception {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("marioalex20007@hotmail.com");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("loco2");
		WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
		submitButton.click();
		
		// When 
		WebElement signOutButton = driver.findElement(By.xpath("//a[@class='logout']"));
		signOutButton.click();
		String title = driver.getTitle();
								
		//Then
		assertEquals("Login - My Store", title);
		//fail("Test not yet implemented");
	}

}
