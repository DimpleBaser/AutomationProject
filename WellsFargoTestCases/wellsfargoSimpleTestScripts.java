package com.WellsFargoTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class wellsfargoSimpleTestScripts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		String URL = "http://www.WellsFargo.com";
		driver = new FirefoxDriver();
		driver.get(URL);
		System.out.println("WellsFargo application is launched");
		System.out.println("Opened page Title is: "+driver.getTitle());
		driver.findElement(By.xpath("//div[@id='headerTools']/nav/ul/li[2]/a")).click();
		System.out.println("Clicked on 'About Wells Fargo' link ");
		System.out.println("Opened page Title is: " + driver.getTitle());
		driver.navigate().back();
		System.out.println("Navigate to back Page Personal Tab: "+driver.getTitle());
		driver.findElement(By.linkText("Insurance")).click();
		System.out.println("Clicked on 'Isurence Tab'");
		driver.findElement(By.linkText("Homeowners Insurance")).click();
		System.out.println("Clicked on 'Homeowners Insurance' link");
		Thread.sleep(5000);
		WebElement zipInput = driver.findElement(By.xpath("//input[@id='zipCode']"));
		zipInput.sendKeys("94087");
		System.out.println("ZipCode '94087' is entered in text box");
		driver.findElement(By.xpath("//input[@id='c28lastFocusable']")).click();
		System.out.println("Clicked on Continue");
		
		
	}

}
