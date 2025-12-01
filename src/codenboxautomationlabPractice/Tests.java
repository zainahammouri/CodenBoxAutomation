package codenboxautomationlabPractice;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests {

	String TheURL="https://codenboxautomationlab.com/practice/";
	WebDriver driver = new ChromeDriver();
	Random rand = new Random ();
	@BeforeTest
	public void SetUp() {
		driver.get(TheURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	
	@Test(enabled = false)
	public void RadioButtonTest() {
		WebElement divRadio = driver.findElement(By.id("radio-btn-example"));
		List<WebElement> AllRadioButtons =driver.findElements(By.tagName("input"));
		int RandomRadio= rand.nextInt(divRadio.findElements(By.tagName("input")).size());
		AllRadioButtons.get(RandomRadio).click();
		
	boolean ActualResult = AllRadioButtons.get(RandomRadio).isSelected();
	Assert.assertEquals(ActualResult, true,"This result for Radio Button ");
		
		}
	@Test(enabled = false)
	public void Dynamic_DropDown() throws InterruptedException {
		String [] countries= {"Jo","United","co"};
		WebElement AutoComplete =driver.findElement(By.id("autocomplete"));
		int RandomCountry = rand.nextInt(countries.length);
		AutoComplete.sendKeys(countries[RandomCountry]);
		Thread.sleep(3000);
		AutoComplete.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
		//Assert with API ***************
	}
	@Test(enabled = false)
	public void Static_Dropdown_Example() {
		WebElement MySelector = driver.findElement(By.id("dropdown-class-example"));
		Select selectt=new Select(MySelector);
		List<WebElement> optionsofSelect=MySelector.findElements(By.tagName("option"));
		int RandomSelect=rand.nextInt(1,optionsofSelect.size());
		selectt.selectByIndex(RandomSelect);
		
		
	}
	
	@Test(enabled = false)
	public void Checkbox_Example() {
		WebElement CheckBoxDiv=driver.findElement(By.id("checkbox-example"));
		List<WebElement> AllOptioins= CheckBoxDiv.findElements(By.tagName("input"));
	
		for(int i=0;i<AllOptioins.size();i++) {
			if(i==0 || i==1) {
//				continue;
//				break;
			}
			
			AllOptioins.get(i).click();
			Boolean ExpectedResult = true;
			Assert.assertEquals(AllOptioins.get(i).isSelected(), ExpectedResult);
		}
	}
	@Test(enabled = false)
	public void Switch_Window_Example() {
		WebElement OpenButten = driver.findElement(By.id("openwindow"));
		OpenButten.click();
		Set<String> handels = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList<>(handels);
		driver.switchTo().window(AllTabs.get(1));
		driver.findElement(By.xpath("//li[@id='menu-item-9947']//span[@class='ct-menu-item'][normalize-space()='BLOG']")).click();
		driver.switchTo().window(AllTabs.get(0));
		Checkbox_Example();
		driver.switchTo().window(AllTabs.get(1));
//		driver.findElement(By.xpath("//*[@id=\"menu-item-9680\"]/a")).click();
		
		
		String ExpectedResult ="Codenbox – IT Solution & Services" ;
		Assert.assertEquals(driver.getTitle(), ExpectedResult);
	}
	@Test(enabled = false)
	public void SwitchTab_Example() throws InterruptedException {
		WebElement OpenTab = driver.findElement(By.id("opentab"));
		OpenTab.click();
		Set<String> handels = driver.getWindowHandles();
		List<String> allTabs = new ArrayList<>(handels);
		driver.switchTo().window(allTabs.get(1));
		Thread.sleep(3000);
		String ExpectedTitle = "Codenbox AutomationLab - YouTube";
		String ExpectedURL = "https://www.youtube.com/@CodenboxAutomationLab";
		Assert.assertEquals(driver.getTitle(), ExpectedTitle);
		Assert.assertEquals(driver.getCurrentUrl(), ExpectedURL);
		
	}
	@Test
	public void Switch_To_Alert_Example() {
		WebElement NameInputFeild = driver.findElement(By.id("name"));
		NameInputFeild.sendKeys("zaina");
		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();
//		driver.switchTo().alert().accept();
//		WebElement ConfirmButton = driver.findElement(By.id("confirmbtn"));
//		ConfirmButton.click();
//		driver.switchTo().alert().dismiss();
		String ExpectedResult="Hello zaina, share this practice page who love to learn automation";
		Assert.assertEquals(driver.switchTo().alert().getText(), ExpectedResult);
		
	}
	
	@AfterTest
	public void AfterFinishedTheTest() {}
}
