package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import generic.BaseTest;
import pompages.HiddenValleyGamePage;
import pompages.QuickspinHome;

public class TestHomePage  extends BaseTest{
	
	
	//This method check the existence of QuickSpin Logo
	@Test(priority=0)
	public void clickOnHomePageLogo() throws InterruptedException {
		
		QuickspinHome home=new QuickspinHome(driver);
		Boolean checkLogoExistence=home.checkQuickSpinLogoPresent();
		Assert.assertTrue(checkLogoExistence);
		}
		
	
	
	@Test(priority=1)
	public void launchAndPlayHiddenValleyGame() throws InterruptedException {
		
	   QuickspinHome home=new QuickspinHome(driver);	
       HiddenValleyGamePage gamePage=new HiddenValleyGamePage(driver);
	   
		home.clickOnHiddenValley();
		gamePage.clickOnPlayButton();
		Thread.sleep(5000);
		gamePage.clickOnContinueButton(driver);
		
		Thread.sleep(6000);
		gamePage.playGame(driver);
		Thread.sleep(3000);
		gamePage.openGameRules(driver);
		Thread.sleep(3000);
		gamePage.closeGameRules(driver);
		Thread.sleep(3000);
		gamePage.clickFastPlayButton();
		Thread.sleep(4000);
		gamePage.checkBalance();
		
		
	}
	
	

		
		
		
		
		
	}


