package org.edicacionit.cursoSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundo Maven");
		WebDriver driver = new ChromeDriver();
		try {
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		} finally {
		driver.quit();
		}
		
	}

}
