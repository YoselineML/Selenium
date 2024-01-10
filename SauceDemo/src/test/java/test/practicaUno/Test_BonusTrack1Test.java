package test.practicaUno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Test_BonusTrack1Test {

	@Test
	void test() throws Exception {
		fail("Not yet implemented");
		String url = "https://www.saucedemo.com/";
		String username = "user-name";
		String password = "password";
		String loginButton = "login-button";
		
		
		WebDriver browser = new ChromeDriver ();
		
		try {
		
		browser.get(url);
		browser.manage().window().maximize();
		browser.findElement(By.id(username)).sendKeys("yoseline");
		browser.findElement(By.id(password)).sendKeys("12345ym");
		browser.findElement(By.id(loginButton)).click();
		Thread.sleep(3000);
	
		
		}finally {
			browser.quit();
		}
		
		

	}

}
