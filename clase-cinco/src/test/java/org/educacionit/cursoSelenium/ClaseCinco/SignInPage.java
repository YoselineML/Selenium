package org.educacionit.cursoSelenium.ClaseCinco;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {
	
	WebDriver browser;
	
	public SignInPage(WebDriver browser) {
		this.browser = browser;
	}
	public void createAccountWithEmail(String email) {
		String xpathBotonCreateAccount = "//*[@id=\"SubmitCreate\"]/span";
		String xpathTxtEmail = "//*[@id=\"email_create\"]";


		WebDriverWait waiter = new WebDriverWait(browser, Duration.ofSeconds(10));
		WebElement txtEmail =  waiter.until( ExpectedConditions.elementToBeClickable(By.xpath(xpathTxtEmail)));
		txtEmail.sendKeys(email);
		
		//Hacer click luego en el boton Create Account
		browser.findElement(By.xpath(xpathBotonCreateAccount)).click();
	}
	
	public String getCreateAccountErrorText() {
		WebElement divCreateAccountError = this.browser.findElement(By.cssSelector("#create_account_error"));
		return divCreateAccountError.getText();
	}
	
	public void completeCreateAccountForm(
			boolean isMister,
			String firstName,
			String lastName,
			String password,
			int diaNacimiento,
			int mesNacimiento,
			int añoNacimiento) {
		
		WebDriverWait waiter = new WebDriverWait(browser, Duration.ofSeconds(10));
		waiter.until(ExpectedConditions.elementToBeClickable(By.id("customer_firstname")));
		
		if (isMister) {
			browser.findElement(By.id("id_gender1")).click();
		} else {
			browser.findElement(By.id("id_gender2")).click();
		}
		
		browser.findElement(By.id("customer_firstname")).sendKeys(firstName);
		browser.findElement(By.id("customer_lastname")).sendKeys(lastName);
		//browser.findElement(By.id("email")).sendKeys(email);
		browser.findElement(By.id("passwd")).sendKeys(password);
		
		Select selectDia = new Select(browser.findElement(By.id("days")));
		selectDia.selectByValue(Integer.toString(diaNacimiento));
		
		Select selectMes = new Select(browser.findElement(By.id("months")));
		selectMes.selectByValue(Integer.toString(mesNacimiento));
		
		Select selectYear = new Select(browser.findElement(By.id("years")));
		selectYear.selectByValue(Integer.toString(añoNacimiento));

	}
}
