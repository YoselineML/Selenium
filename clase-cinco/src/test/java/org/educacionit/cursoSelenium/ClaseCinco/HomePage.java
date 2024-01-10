package org.educacionit.cursoSelenium.ClaseCinco;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver browser;
	final String BASE_URL = "http://www.automationpractice.pl/index.php";
	
	//El constructor de la clase HomePage
	public HomePage(WebDriver browser) {
		this.browser = browser;
	}
	
	//Este metodo no devuelve nada
	public void open() {
		this.browser.get(BASE_URL);
	}
	
	//Hace click en el boton de SignIn y devuelve la pagina de SignIn
	public SignInPage clickSignInLink() {
		String xpathBotonSignIn = "/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a";
		WebElement signInButton = browser.findElement(By.xpath(xpathBotonSignIn));
		signInButton.click();
		
		//Para mejorar este codigo puedo esperar a estar seguro que la pagina de signIn se me muestre
		//Pero por ahora como se que va rapido lo devuelvo directamente
		
		SignInPage signIn = new SignInPage(browser);
		return signIn;
	
	}
}
