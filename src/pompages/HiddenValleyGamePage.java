package pompages;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class pom class for HIDDEN VALLEY game. It has all the web elements
 * present in HIDDEN VALLEY game.
 * 
 * @author user
 *
 */

public class HiddenValleyGamePage {

	@FindBy(xpath = "//span[@class='btn desktop-link js-play-game']")
	WebElement playButton;

	@FindBy(xpath = "//iframe[contains(@src,'partnerid=quickspin')]")
	WebElement frameForGame;

	@FindBy(xpath = "//span[@id='continuebutton_label']")
	WebElement continueButton;

	@FindBy(xpath = "//button[@id='MenuButton']")
	WebElement menuButton;

	@FindBy(xpath = "//*[@id='GameRulesMenuButton']")
	WebElement gameRuleButton;

	@FindBy(xpath = "//*[@id='CloseMenuButton']")
	WebElement closeGameRuleButton;

	@FindBy(xpath = "//button[@id='TotalBetButton']")
	WebElement totalBetButton;

	@FindBy(xpath = "//*[@id='DefaultSpinButton']")
	WebElement spinButton;

	@FindBy(xpath = "//span[@id='balancefield_number']")
	WebElement balanceAmount;

	@FindBy(xpath = "//span[@id='winfield_number']")
	WebElement winAmount;

	public HiddenValleyGamePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method click on PLAY BUTTON when HIDDEN VALLEY game is page is launched
	 * from QUICKSPIN home page.
	 */
	public void clickOnPlayButton() {
		playButton.click();

	}

	/**
	 * This method click on CONTINUE BUTTON which appears once the play button is
	 * clicked After this method we get the actual video slot which we can play and
	 * win money.
	 * 
	 * @param driver
	 */
	public void clickOnContinueButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.switchTo().frame(frameForGame);
		WebElement continueButtonVisible = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", continueButtonVisible);
	}

	/**
	 * This method play video slot which appears after continue button.
	 * The method actually play 3 bet rounds by incrementing from bet arrow.
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */

	public void playGame(WebDriver driver) throws InterruptedException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(7000);
		WebElement betFor3 = driver.findElement(By.xpath("//div[@id='BetStepperField']/button[@class='next']"));
		

		Thread.sleep(7000);
		jse.executeScript("arguments[0].click();", betFor3);
		jse.executeScript("arguments[0].click();", spinButton);
		Thread.sleep(7000);
		jse.executeScript("arguments[0].click();", betFor3);
		jse.executeScript("arguments[0].click();", spinButton);
		Thread.sleep(7000);
		jse.executeScript("arguments[0].click();", betFor3);
		jse.executeScript("arguments[0].click();", betFor3);
		jse.executeScript("arguments[0].click();", betFor3);
		jse.executeScript("arguments[0].click();", betFor3);
		jse.executeScript("arguments[0].click();", spinButton);

	}
	
	/**
	 * This method is to press ">>" from the keypad control
	 * Java Robot class capabilities are used to press the different key combination.
	 */

	public void clickFastPlayButton() {

		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_PERIOD);
			r.keyRelease(KeyEvent.VK_PERIOD);
			r.keyPress(KeyEvent.VK_PERIOD);
			r.keyRelease(KeyEvent.VK_PERIOD);
			r.keyRelease(KeyEvent.VK_SHIFT);
		} catch (AWTException e) {

			System.out.println(e.toString());
		}

	}

	
	/**
	 * This method open the game rule from the menu button of the video slot.
	 * @param driver
	 */
	public void openGameRules(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", menuButton);
		jse.executeScript("arguments[0].click();", gameRuleButton);
	}

	
	/**
	 * This method close the game rule which was opened.
	 * @param driver
	 */
	public void closeGameRules(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", closeGameRuleButton);
	}

	
	/**
	 * This method checks the balance which is displayed in the Balance field adding it with amount in WIN field of video slot.
	 * 
	 */
	public void checkBalance() {
		String winTotalAmount = null;
		String totalBalance = balanceAmount.getText();

		winTotalAmount = winAmount.getAttribute("text");

		if (winTotalAmount != null) {

			float balance = Float.valueOf(totalBalance);
			float win = Float.valueOf(winTotalAmount);
			float totalAddedBalance = balance + win;
			totalBalance = Float.toString(totalAddedBalance);
		}

		else {
			winTotalAmount = "0.00";
		}

		System.out.println("Balance after replay is  : " + totalBalance);
		System.out.println("Win Amount is: " + winTotalAmount);

	}

}
