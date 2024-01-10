package org.educacionit.cursoSelenium.clase.dos;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class program {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido clase dos");
		WebDriver WebBrowser = new ChromeDriver();
		try {
			WebBrowser.get("http://www.automationpractice.pl/index.php");
			// Busco un elemento por ID
			//// opcion 1 - guardo lo que me devuelve el metodo en una variable
			//// WebElement inputSearch = WebBrowser.findElement(By.id("search_query_top"));
			//// inputSearch.sendKeys("shrit");

			//// Opcion 2
			WebBrowser.findElement(By.id("search_query_top")).sendKeys("shrit");

			// Busco un elemento por name
			
			//// OPCION 1: encuentro el elemento
			 WebElement botonBuscar = WebBrowser.findElement(By.name("submit_search"));
			 botonBuscar.click();

			//// Opcion 2 : que pasa si el elemento no existe
			////String nombreBotonBuscar = "submit_search_noexiste";
			////try {
			////WebElement botonBuscar = WebBrowser.findElement(By.name(nombreBotonBuscar));
			////botonBuscar.click();
			////}catch (Exception ex) {
			////	System.out.println("el elemento" + nombreBotonBuscar + "no existe");
			////}
			 
			 Thread.sleep(3000);
			 WebElement spamSearchResults = WebBrowser.findElement(By.className("heading-counter")); 
			 //System.out.println(spamSearchResults.getText());
			 String textoEsperado = "1 results has been found.";
			 if (spamSearchResults.getText().equals(textoEsperado)) {
					 System.out.println("obtuve el resultado esperado");
		} else {
			System.out.println("la pagina no me devolvio lo que queria");
		}
			// Espero antes de cerrar el buscador
			Thread.sleep(7000);
		} finally {
			WebBrowser.quit();

		}
	}

}
