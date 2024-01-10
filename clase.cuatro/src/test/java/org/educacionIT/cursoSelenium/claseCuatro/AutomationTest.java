package org.educacionIT.cursoSelenium.claseCuatro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutomationTest {

	String url = "http://www.automationpractice.pl/index.php";

	@Test
  public void testSignIn() throws InterruptedException {
		String xpathBotonSignIn = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a";
		String xpathTxtEmail = "//*[@id=\"email_create\"]";
		String xpathBotonCreateAccount = "//*[@id=\"SubmitCreate\"]/span";
		String email = "mailPrueba@gmail.com";
				
	  WebDriver browser = new ChromeDriver ();
		WebDriverWait waiter = new WebDriverWait(browser, Duration.ofSeconds(10));
	  try {
		  browser.get(url);
		  WebElement SignInButton = browser.findElement(By.xpath(xpathBotonSignIn));
		  SignInButton.click();
		  
		  WebElement txtEmail =  waiter.until( ExpectedConditions.elementToBeClickable(By.xpath(xpathTxtEmail)));
		  txtEmail.sendKeys(email);
		  
		  browser.findElement(By.xpath(xpathBotonCreateAccount)).click();
		  
		  waiter.until(ExpectedCondition.elementToBeClickeable(By.xpath(xpathTxtEmail)));
		   txtEmail.sendKeys(email);
	  
		 browser.findElement(By.xpath(xpathBotonCreateAccount)).click();
		 browser.findElement(By.id("costumer_firstname")).sendKeys("Yoseline");
		 browser.findElement(By.id("costumer_lastname")).sendKeys("Marquez");
		 browser.findElement(By.id("email")).sendKeys(email);
		 browser.findElement(By.id("passwd")).sendKeys("1234");
		  
		  Thread.sleep(3000);
	  }finally {
	  }
	  
  }
}
