package com.testMaven.AmazonMavenAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ModulesAmazonTest extends ReUsableMethodTest{

	//Module for Launch application
	public static void launchApp(WebDriver driver,String baseUrl) throws Exception{

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("MyFirefox");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	//Prime Option in all results
	public static void primeOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement PrimeOptIsDisplayed = driver.findElement(By.xpath("//div[@id='refinements']/h2[1]"));
		validateText(PrimeOptIsDisplayed, "Amazon Prime", "Amazon Prime Option");
		WebElement primeChkBox = driver.findElement(By.xpath("//*[@id='ref_2470954011']/li/a/img[1]"));
		isDeSelected(primeChkBox, "Prime Option");
	}

	//Free Shipping option in all results
	public static void freeShippingOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement freeShippingIsDisplayed = driver.findElement(By.xpath("//div[@id='refinements']/h2[2]"));
		validateText(freeShippingIsDisplayed, "Eligible for Free Shipping", "Eligible for Free Shipping Option");
		WebElement shippingChkBox = driver.findElement(By.xpath("//*[@id='ref_2661623011']/li/a/img"));
		isDeSelected(shippingChkBox, "Shipping Option");
	}

	//Brand option in all results
	public static void brandOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement brandIsDisplayed = driver.findElement(By.xpath("//*[@id='refinements']/h2[3]"));
		validateText(brandIsDisplayed, "Brand", "Brand Option");
		WebElement appleChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[1]/a/img"));
		isDeSelected(appleChkBox, "Apple Option");
		WebElement customChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[2]/a/img"));
		isDeSelected(customChkBox, "CustomI Option");
		WebElement iPhoneChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[3]/a/img"));
		isDeSelected(iPhoneChkBox, "iPhone Option");
		WebElement iPhonChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[4]/a/img"));
		isDeSelected(iPhonChkBox, "iPhon Option");
		WebElement hyChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[5]/a/img"));
		isDeSelected(hyChkBox, "Hyperion Option");
		WebElement amOnlineChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[6]/a/img"));
		isDeSelected(amOnlineChkBox, "amOnline Shop Option");
		WebElement rinChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[7]/a/img"));
		isDeSelected(rinChkBox, "Rinbers Option");
		WebElement buyeeChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[8]/a/img"));
		isDeSelected(buyeeChkBox, "Buyee Option");
		WebElement grantChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[9]/a/img"));
		isDeSelected(grantChkBox, "Grantwood Technology Option");
		WebElement energenChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[10]/a/img"));
		isDeSelected(energenChkBox, "Energen Option");
		WebElement rcoChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[11]/a/img"));
		isDeSelected(rcoChkBox, "RCO Option");
		WebElement kinglakeChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[12]/a/img"));
		isDeSelected(kinglakeChkBox, "KingLake Option");
		WebElement unuChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[13]/a/img"));
		isDeSelected(unuChkBox, "UNU Option");
		WebElement cellArmorChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[14]/a/img"));
		isDeSelected(cellArmorChkBox, "Cell Armor Option");
		WebElement maxboostChkBox = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[15]/a/img"));
		isDeSelected(maxboostChkBox, "Maxboost Option");

	}


	//cell phone internal option in all results
	public static void internalMemoryOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement memoryIsDisplayed = driver.findElement(By.xpath("//*[@id='refinements']/h2[4]"));
		validateText(memoryIsDisplayed, "Cell Phone Internal Memory", "Internal Memory Option");

		WebElement gb4ChkBox = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[1]/span/img"));
		//System.out.println("is enabled"+ gb4ChkBox.isEnabled());
		isDeactivated(gb4ChkBox, "4GB Option");
		WebElement gb8ChkBox = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[2]/a/img"));
		isDeSelected(gb8ChkBox, "8GB Option");
		//System.out.println("is enabled"+ gb8ChkBox.isEnabled());
		WebElement gb16ChkBox = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[3]/a/img"));
		isDeSelected(gb16ChkBox, "16GB Option");
		WebElement gb32ChkBox = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[4]/a/img"));
		isDeSelected(gb32ChkBox, "32GB Option");
		WebElement gb64ChkBox = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[5]/a/img"));
		isDeSelected(gb64ChkBox, "64GB Option");
	}

	//cell phone display Size option in all results
	public static void displaySizeOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement sizeIsDisplayed = driver.findElement(By.xpath("//*[@id='refinements']/h2[5]"));
		validateText(sizeIsDisplayed, "Cell Phone Display Size", "Phone Display Size Option");
		WebElement inches3ChkBox = driver.findElement(By.xpath("//*[@id='ref_6215726011']/li[1]/a/img"));
		isDeSelected(inches3ChkBox, "3.9 inches Option");
		WebElement inches40ChkBox = driver.findElement(By.xpath("//*[@id='ref_6215726011']/li[2]/a/img"));
		isDeSelected(inches40ChkBox, "4.0 - 4.4  inches Option");
		WebElement inches45ChkBox = driver.findElement(By.xpath("//*[@id='ref_6215726011']/li[3]/a/img"));
		isDeSelected(inches45ChkBox, "4.5 - 4.9 inches Option");
		WebElement inches50ChkBox = driver.findElement(By.xpath("//*[@id='ref_6215726011']/li[4]/a/img"));
		isDeSelected(inches50ChkBox, "5.0 - 5.4 inches Option");
		WebElement inches55ChkBox = driver.findElement(By.xpath("//*[@id='ref_6215726011']/li[5]/a/img"));
		isDeSelected(inches55ChkBox, "5.5 inches Option");	

	}
	//cell phone feature option in all results
	public static void featureOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement featureIsDisplayed = driver.findElement(By.xpath("//*[@id='refinements']/h2[6]"));
		validateText(featureIsDisplayed, "Cell Phone Features", "Cell Phone Features Option");
		WebElement smartPhChkBox = driver.findElement(By.xpath("//*[@id='refinements']/ul[6]/li[1]/a/img"));
		isDeSelected(smartPhChkBox, "smartphone Option");
		WebElement bluetoothChkBox = driver.findElement(By.xpath("//*[@id='refinements']/ul[6]/li[2]/a/img"));
		isDeSelected(bluetoothChkBox, "bluetooth Option");
		WebElement touchChkBox = driver.findElement(By.xpath("//*[@id='refinements']/ul[6]/li[3]/a/img"));
		isDeSelected(touchChkBox, "TouchScreen Option");
		WebElement dualCamChkBox = driver.findElement(By.xpath("//*[@id='refinements']/ul[6]/li[4]/a/img"));
		isDeSelected(dualCamChkBox, "Dual camera Option");
		WebElement builtinGPSChkBox = driver.findElement(By.xpath("//*[@id='refinements']/ul[6]/li[5]/a/img"));
		isDeSelected(builtinGPSChkBox, "builtinGPS Option");
		WebElement cameraChkBox = driver.findElement(By.xpath("//*[@id='refinements']/ul[6]/li[6]/a/img"));
		isDeSelected(cameraChkBox, "camera Option");

	}

	//Cell Phone Compatibility option in all results
	public static void compatibilityOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement compatibilityIsDisplayed = driver.findElement(By.xpath("//*[@id='refinements']/h2[7]"));
		validateText(compatibilityIsDisplayed, "Cell Phone Compatibility", "Cell Phone Features Option");
		WebElement iPhone6_6sChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[1]/a/img"));
		isDeSelected(iPhone6_6sChkBox, "iPhone6_6s Option");
		WebElement iPhone6_6splusChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[2]/a/img"));
		isDeSelected(iPhone6_6splusChkBox, "iPhone6_6splusChkBox Option");
		WebElement iPhone55s5seChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[3]/a/img"));
		isDeSelected(iPhone55s5seChkBox, "iPhone55s5se Option");
		WebElement iPhone5cChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[4]/a/img"));
		isDeSelected(iPhone5cChkBox, "iPhone5c Option");
		WebElement iPhone44sChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[5]/a/img"));
		isDeSelected(iPhone44sChkBox, "iPhone44s Option");
		//		WebElement galS7ChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[6]/a/img"));
		//		isDeSelected(galS7ChkBox, "Samsung Galaxy S7 Option");
		//		WebElement galS7EgChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[7]/a/img"));
		//		isDeSelected(galS7EgChkBox, "Samsung Galaxy S7 Edge Option");
		WebElement galS6ChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[8]/a/img"));
		isDeSelected(galS6ChkBox, "Samsung Galaxy S6 Option");
		WebElement galS6edgChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[9]/a/img"));
		isDeSelected(galS6edgChkBox, "Samsung Galaxy S6 Edge Option");
		WebElement galS5ChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[10]/a/img"));
		isDeSelected(galS5ChkBox, "Samsung Galaxy S5 Option");
		WebElement galS4ChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[11]/a/img"));
		isDeSelected(galS4ChkBox, "Samsung Galaxy S4 Option");
		WebElement galNote4ChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[12]/a/img"));
		isDeSelected(galNote4ChkBox, "Samsung Galaxy Note 4 Edge Option");
		WebElement lgG3ChkBox = driver.findElement(By.xpath("//*[@id='ref_2488708011']/li[13]/a/img"));
		isDeSelected(lgG3ChkBox, "LG G3 Option");	
	}
	//Avg. Customer Review in all results
	public static void reviewOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement reviewIsDisplayed = driver.findElement(By.xpath("//*[@id='refinements']/h2[9]"));
		validateText(reviewIsDisplayed, "Avg. Customer Review", "Cell Phone Features Option");
		WebElement star4Review = driver.findElement(By.xpath("//*[@id='ref_2661617011']/li[1]/a/i"));
		isDisplayed(star4Review, "4Star", "4 star & up Option");
		WebElement star3Review = driver.findElement(By.xpath("//*[@id='ref_2661617011']/li[2]/a/i"));
		isDisplayed(star3Review, "3Star", "3 star & up Option");
		WebElement star2Review = driver.findElement(By.xpath("//*[@id='ref_2661617011']/li[3]/a/i"));
		isDisplayed(star2Review, "2Star", "2 star & up Option");
		WebElement star1Review = driver.findElement(By.xpath("//*[@id='ref_2661617011']/li[4]/a/i"));
		isDisplayed(star1Review, "1Star", "1 star & up Option");

	}

	//International Shipping option in all results
	public static void globalShippingOption(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement globalShippingIsDisplayed = driver.findElement(By.xpath("//div[@id='refinements']/h2[10]"));
		validateText(globalShippingIsDisplayed, "International Shipping", "International Shipping Option");
		WebElement shippingChkBox = driver.findElement(By.xpath("//*[@id='ref_2944662011']/li/a/img"));
		isDeSelected(shippingChkBox, "Amazon Global Eligible Option");
	}
	//International Shipping option in all results
	public static void checkHrLinks(WebDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement signIn = driver.findElement(By.xpath("//*[@id='nav-signin-tooltip']/a/span"));
		validateText(signIn, "Sign in", "Sign in Link");

		WebElement departments = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
		validateText(departments, "Departments", "shop departments");
		WebElement yourAmzLink = driver.findElement(By.xpath("//*[@id='nav-your-amazon']"));
		validateText(yourAmzLink, "Your Amazon.com", "Your Amazon Link");
		WebElement todayDealLink = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[2]"));
		validateText(todayDealLink, "Today's Deals", "Today's Deals Link");
		WebElement giftCardRegistryLink = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[3]"));
		validateText(giftCardRegistryLink, "Gift Cards & Registry", "Gift Cards & Registry Link");
		WebElement sellLink = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[4]"));
		validateText(sellLink, "Sell", "Sell Link");
		WebElement helpLink = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[5]"));
		validateText(helpLink, "Help", "Help Link");
		WebElement helloLink = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']/span[1]"));
		validateText(helloLink, "Hello. Sign in", "Hello. Sign in Link");
		mouseOver(driver, helloLink, "dropDownhelloLink");
		WebElement yourAccLink = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']/span[2]"));
		validateText(yourAccLink, "Your Account", "Your Account Link");
		WebElement tryPrimeLink = driver.findElement(By.xpath("//*[@id='nav-link-prime']/span[2]"));
		validateText(tryPrimeLink, "Try Prime", "Try Prime Link");
		WebElement listsLink = driver.findElement(By.xpath("//*[@id='nav-link-wishlist']/span[2]"));
		validateText(listsLink, "Lists", "Lists Link");
		WebElement cartLink = driver.findElement(By.xpath("//*[@id='nav-cart']/span[2]"));
		validateText(cartLink, "Cart", "Cart Link");
	}
}
