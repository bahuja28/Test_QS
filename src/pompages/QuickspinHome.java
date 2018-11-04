package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickspinHome {
	
	
	@FindBy(xpath="//a[@class='top-logo']")
		WebElement quickspinLogo;
		
	
	@FindBy(xpath="//div[@class='slots-grid clearfix']//a[contains(@href,'hidden-valley')]")
	WebElement hiddenValley;
	
	
	
	public QuickspinHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public boolean checkQuickSpinLogoPresent() {
		return (quickspinLogo.isDisplayed());
		
	}
	
	public void clickOnHiddenValley() {
		hiddenValley.click();
	}
	
	
}

