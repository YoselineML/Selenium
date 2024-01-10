package org.educacionit.cursoSelenium.ClaseCinco;

import java.util.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AutomationTestWithPom {
	String url = "http://www.automationpractice.pl/index.php";

	@Test
	public void testSingInEmptyEmail() throws Exception {
		WebDriver browser = new ChromeDriver();

		HomePage Home = new HomePage(browser);
		try {
			Home.open();
			SignInPage signIn = Home.clickSignInLink();
			signIn.createAccountWithEmail("");
			Thread.sleep(500); // Le pongo una mini espera para darle tiempo a la pagina de mostrar el mensaje
			Assert.assertEquals("Invalid Email Address", signIn.getCreateAccountErrorText());
		} finally {
			browser.quit();
		}

	}

	@Test
	public void testSingIn() throws Exception {
		WebDriver browser = new ChromeDriver();
		//WebDriver browser = new FirefoxDriver();

		HomePage Home = new HomePage(browser);
		try {
			Home.open();
			SignInPage signIn = Home.clickSignInLink();
			signIn.createAccountWithEmail("pepe1234@gmail.com");
			signIn.completeCreateAccountForm(false, "Yoseline", "Marquez", "12345ym", 01, 5, 1997);
			Thread.sleep(5000); // Le pongo una mini espera para darle tiempo a la pagina de mostrar el mensaje

		} finally {
			browser.quit();
		}
		
	}

	@Test
	public void testSingInDuplicateEmail() throws Exception {
		WebDriver browser = new ChromeDriver();

		HomePage Home = new HomePage(browser);
		try {
			Home.open();
			SignInPage signIn = Home.clickSignInLink();
			signIn.createAccountWithEmail("pepe@gmail.com");
			Thread.sleep(1000); // Le pongo una mini espera para darle tiempo a la pagina de mostrar el mensaje
			Assert.assertEquals(
					"An account using this email address has already been registered. Please enter a valid password or request a new one.",
					signIn.getCreateAccountErrorText());
		} finally {
			browser.quit();
		}

	}

	@DataProvider(name = "nombres")
	public Object[][] getNombres() {
		return new Object[][] { { "Mr", "Conrado" }, { "Ms", "Adriana" }, { "Ms", "Yoseline" } };
	}

	@Test(dataProvider = "nombres")
	public void testConParametros(String pref, String nombre) {
		System.out.println(pref + " " + nombre);
	}

	@DataProvider(name = "invalid-emails")
	public Object[][] getInvalidEmails() {
		return new Object[][] { { "", "Invalid email address." }, { "pepe@gmail.com",
				"An account using this email address has already been registered. Please enter a valid password or request a new one." } };
	}

	@Test(dataProvider = "invalid-emails")
	public void testSingInInvalidEmail(String email, String response) throws Exception {
		WebDriver browser = new ChromeDriver();

		HomePage Home = new HomePage(browser);
		try {
			Home.open();
			SignInPage signIn = Home.clickSignInLink();
			signIn.createAccountWithEmail(email);
			Thread.sleep(1000); // Le pongo una mini espera para darle tiempo a la pagina de mostrar el mensaje
			Assert.assertEquals(response, signIn.getCreateAccountErrorText());
		} finally {
			browser.quit();
		}
	}
	
	@Test
	public void testAlerta() throws Exception{
		ChromeOptions options = new ChromeOptions ();
		//incognito, start-maximized, headless, disable-extensions
		options.addArguments("incognito","start-maximixed");
		  //file:///C:/Cursos/TestingSelenium/Material/Alerta.html
			WebDriver browser = new ChromeDriver(options);
			try {
				browser.get("file:///C:/prueba/Alerta.html");
				Alert alert = browser.switchTo().alert();
				Thread.sleep(1000);
				alert.accept();
				Thread.sleep(3000);

			}finally {
				browser.quit();
			}	  
	  }
	@Test
	  public void testTabla() throws Exception{
			WebDriver browser = new ChromeDriver();
			try {
				browser.get("file:///C:/prueba/Tabla.html");
		//	System.out.println(browser.findElement(By.xpath("//*[@id=\"tabla\"]/tbody/tr[3]/td[2]")).getText());
				List<WebElement> elements = browser.findElement(By.id("tabla")).findElements(By.tagName("td"));
				for(WebElement element : elements) {
					System.out.println(element.getText());
				}
				Thread.sleep(3000);

			} finally {
				browser.quit();
			}
	  }
}