package com.testMaven.AmazonMavenAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class AutomationScriptTest extends  ReUsableMethodTest{

	static WebDriver driver;
	static String baseURL ="https://www.amazon.com";

	//Test Case 1 ---> Launch Amazon application
	public static void launchAmzApp() throws Exception{
		startReport("launchApp", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		ModulesAmazonTest.launchApp(driver, baseURL);
		Update_Report("Pass", "Launch application", baseURL + " is launched");
		bw.close();
		driver.close();

	}

	//Test Case 2 ---> Verify Drop Down Option after Iphone  is Typedin Search  
	public static void verifyDropDownInSearch() throws Exception{
		startReport("verifyDropDownInSearch", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("MyFirefox");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		enterText(searchBox, "IPhone", "iphone in search box");

		WebElement dropdown0 = driver.findElement(By.xpath("//div[@id='issDiv0']"));
		isDisplayed(dropdown0, "1st", "search option");

		WebElement dropdown1 = driver.findElement(By.xpath("//div[@id='issDiv1']"));
		isDisplayed(dropdown1, "2nd", "search option");

		WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='issDiv2']"));
		isDisplayed(dropdown2, "3rd", "search option");
		bw.close();

	}

	//Test Case 3 ---> Click on Search Button after "Ipone " is entered 
	public static void searchItem() throws Exception{
		startReport("searchItem", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("MyFirefox");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		enterText(searchBox, "IPhone", "iphone in search box");
		WebElement searchImg = driver.findElement(By.xpath("//input[@class = 'nav-input' and @value = 'Go']"));
		clickButton(searchImg, "Search");
		bw.close();
		driver.close();

	}

	//Test Case 4 ---> Verify Show results for Column  on the left -"Cell Phones & Accessories "Header 
	public static void verifyColorForOption() throws Exception{
		startReport("verifyColorForOption", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		String baseUr = "https://www.amazon.com/gp/search/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468627744";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUr);
		WebElement cellPhones = driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[1]/a/span"));
		changeColorMouseOver(driver,cellPhones, "cell Phones" );
		WebElement unloakedCellPhones= driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[2]/a/span"));
		changeColorMouseOver(driver, unloakedCellPhones, "unloaked Cell Phones");
		WebElement cellPhoneAccessories = driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[4]/a/span"));
		changeColorMouseOver(driver, cellPhoneAccessories, "Cell Phone Accessories");
		WebElement cellPhoneCases = driver.findElement(By.xpath("//div[@id='refinements']/div[2]/ul[1]/li/ul[1]/li[5]/a/span"));
		changeColorMouseOver(driver, cellPhoneCases, "Cell Phone Cases Link");
		WebElement seeMoreLink = driver.findElement(By.xpath("//ul[@id='seeMoreRefinementValuesClosed1']/li/span/a/span[2]"));
		changeColorMouseOver(driver, seeMoreLink, "See More Link");
		driver.close();
		bw.close();
	}

	//Test Case 5 ---> Verify Show results for Column  on the left -" Computers & Accessories "Header  
	public static void computerComponents() throws Exception{
		startReport("computerComponents", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		String baseUr = "https://www.amazon.com/s/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468660093";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUr);
		WebElement allDeptLink = driver.findElement(By.xpath("//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		clickButton(allDeptLink, "all department link");
		WebElement comComponents = driver.findElement(By.xpath("//*[@id='seeAllDepartmentOpen1']/li[1]/ul/li/a/span"));
		changeColorMouseOver(driver, comComponents, "Computer component link");

		driver.close();
		bw.close();


	}


	//Test Case 6 ---> Verify Show results for Column  on the left -"Cell Phones & Accessories "Header 
	public static void electronicsHeader() throws Exception{
		startReport("electronicsHeader", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		String baseUr = "https://www.amazon.com/s/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468660093";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUr);
		WebElement allDeptLink = driver.findElement(By.xpath("//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		clickButton(allDeptLink, "all department link");

		WebElement electronicsLink = driver.findElement(By.xpath("//*[@id='seeAllDepartmentOpen1']/li[2]/a/span[1]"));
		mouseOver(driver, electronicsLink, "Electronics");

		WebElement smartWatches = driver.findElement(By.xpath("//*[@id='seeAllDepartmentOpen1']/li[2]/ul/li[1]/a/span"));
		mouseOver(driver, smartWatches, "Smart Watches Link");
		Thread.sleep(5000);
		WebElement portableSpeaker = driver.findElement(By.xpath("//ul[@id='seeAllDepartmentOpen1']/li[2]/ul/li[2]/a/span"));
		mouseOver(driver, portableSpeaker, "Portable Bluetooth Speaker");

		driver.quit();
		bw.close();
	}

	//Test Case 7 ----> Verify Show results for Column  on the left -"  Refine by "Header 
	public static void verifyAllResults() throws Exception{
		String baseUrl="https://www.amazon.com/s/ref=sr_ex_n_0?rh=i%3Aaps%2Ck%3Aiphone&keywords=iphone&ie=UTF8&qid=1468640781";
		startReport("verifyAllResults", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("MyFirefox");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);

		ModulesAmazonTest.primeOption(driver);
		ModulesAmazonTest.freeShippingOption(driver);
		ModulesAmazonTest.brandOption(driver);
		ModulesAmazonTest.internalMemoryOption(driver);
		ModulesAmazonTest.displaySizeOption(driver);
		ModulesAmazonTest.featureOption(driver);
		ModulesAmazonTest.compatibilityOption(driver);
		ModulesAmazonTest.reviewOption(driver);
		ModulesAmazonTest.globalShippingOption(driver);
		driver.quit();
		bw.close();

	}

	//Test Case 8 ---> Check all the lists in <Main Tab> available in the Page
	public static void chkLinksOnMainPage() throws Exception{
		String baseUrl="https://www.amazon.com";
		startReport("chkLinksOnMainPage", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		ModulesAmazonTest.checkHrLinks(driver);
		bw.close();
		driver.quit();
	}
	//Test Case 9 ---> Validate the Dropdown list in <Department> Tab
	public static void validateDepartmentDropDown() throws Exception{
		String[] expMenuItemes = {"Amazon Video","Digital & Prime Music", "Appstore for Android","Amazon Photos & Drive", "Kindle E-readers & Books", "Fire Tablets", "Fire TV", "Echo & Alexa", "Books & Audible", "Movies, Music & Games",
				"Electronics & Computers", "Home, Garden & Tools", "Beauty, Health & Grocery", "Toys, Kids & Baby", "Clothing, Shoes & Jewelry", "Sports & Outdoors", "Automotive & Industrial", "Handmade",
				"Home Services", "Credit & Payment Products", "Full Store Directory"};	
		String baseUrl="https://www.amazon.com";
		startReport("validateDepartmentDropDown", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		WebElement departments = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
		mouseOver(driver, departments, "Department DropDown");
		WebElement dropDownList = driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]"));
		validateTextInDropdn(dropDownList, expMenuItemes, "DropDown Department List");
		bw.close();
		driver.close();

	}
	//Test Case 10 ---> Validate the Dropdown list in <Your Account> Tab
	public static void validateMyAccDropDown() throws Exception{
		String[] expMenuItemes = {"Sign in","New customer? Start here.", "Your Account","Your Orders", "Your Lists", "Your Recommendations", "Your Subscribe & Save Items", "Your Digital Subscriptions", "Your Service Requests", "Your Prime Membership",
				"Your Garage", "Register for a Business Account", "Your Amazon Credit Card Accounts", "Manage Your Content and Devices", "Your Video Subscriptions", "Your Prime Music", "Your Music Library", "Your Amazon Drive",
				"Your Prime Video", "Your Kindle Unlimited", "Your Watchlist", "Your Video Library", "Your Android Apps & Devices"};	
		String baseUrl="https://www.amazon.com";
		startReport("validateMyAccDropDown", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Thread.sleep(5000);
		WebElement yourAccTab = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
		mouseOver(driver, yourAccTab, "Your Account dropDown");
		WebElement dropDownList = driver.findElement(By.xpath("//*[@id='nav-flyout-yourAccount']"));
		validateTextInDropdn(dropDownList, expMenuItemes, "Sign in Dropdown");
		driver.close();
		bw.close();
	}
	//Test Case 11 ---> Validate the Dropdown list in <Try prime> Tab
	public static void validateTryPrimeDropDown() throws Exception{
		String[] expMenuItemes = {"Start your free trial and join millions of Amazon Prime members who enjoy:", "Prime Video", "Watch thousands of movies and TV episodes on your favorite device", 
				"Free Two-Day Shipping", "Get fast, free shipping on over 20 million items", "Over a Million Songs, Ad-Free", "With Prime Playlists, listen to over a million songs, playlists and stations – all ad-free",
				"Kindle Owners' Lending Library", "Borrow from over 800,000 titles for free", "> Try Prime"};	
		String baseUrl="https://www.amazon.com";
		startReport("validateTryPrimeDropDown", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("MyFirefox");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Thread.sleep(5000);
		WebElement tryPrimeTab = driver.findElement(By.xpath("//*[@id='nav-link-prime']"));
		mouseOver(driver, tryPrimeTab, "Try prime dropDown");
		Thread.sleep(5000);
		//Thread.sleep(5000);
		WebElement dropDownList = driver.findElement(By.xpath("//*[@id='nav-flyout-prime']"));
		validateTextInDropdn(dropDownList, expMenuItemes, "Try Prime Drop Down");

		System.out.println(dropDownList.isDisplayed());
		String txt = dropDownList.getText().trim();
		System.out.println(txt);
		String[] actualtxt = dropDownList.getText().split("[\\r\\n]+");
		//for(int i =0; i < expMenuItemes.length; i++){
		//System.out.println(actualtxt[i]);
		//System.out.println(expMenuItemes[i]);
		//}
		driver.close();
		bw.close();
	}

	//Test Case 12 ---> Validate the whish List list in <Try prime> Tab
	public static void validateListDropDown() throws Exception{
		String[] expMenuItemes = {"Create a List", "Find a List or Registry", "Find a Gift", "Save Items from the Web", "Install Amazon Assistant", "Wedding Registry", "Baby Registry",
				"Kids' Birthdays", "School Lists", "Friends & Family Gifting", "Pantry Lists", "Your Hearts (in Fashion)"};	
		String baseUrl="https://www.amazon.com";
		startReport("validateListDropDown", "/Users/dimple/Desktop/AmazonTestReports/TestReport");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("MyFirefox");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Thread.sleep(5000);
		WebElement listTab = driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']"));
		mouseOver(driver, listTab, "List dropDown");
		WebElement dropDownList = driver.findElement(By.xpath("//*[@id='nav-flyout-wishlist']"));
		validateTextInDropdn(dropDownList, expMenuItemes, "List Drop Down");
		driver.close();
		bw.close();

	}

}
