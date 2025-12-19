package codenboxautomationlabPractice;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	@Test(enabled = false)
	public void Switch_To_Alert_Example() {
		WebElement NameInputFeild = driver.findElement(By.id("name"));
		NameInputFeild.sendKeys("zaina");
		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();
		driver.switchTo().alert().accept();
//		WebElement ConfirmButton = driver.findElement(By.id("confirmbtn"));
//		ConfirmButton.click();
//		driver.switchTo().alert().dismiss();
//		String ExpectedResult="Hello zaina, share this practice page who love to learn automation";
//		Assert.assertEquals(driver.switchTo().alert().getText(), ExpectedResult);
		
	}
	@Test(enabled = false)
	public void Web_Table_Example() {
		WebElement TheTable = driver.findElement(By.id("product"));
		List<WebElement> AllRows = TheTable.findElements(By.tagName("tr"));
//		//To get all data as Rows From the table
//		for(int i = 0 ;i<AllRows.size();i++) {
//			System.out.println(AllRows.get(i).getText());
//		}
		
		
//		//To get all Data Without The Header 
//		for(int i =1;i<AllRows.size();i++) {
//			System.out.println(AllRows.get(i).getText());
//		}
		
//		

		
//		//Colomns
//		//The First Colomn 
//		for(int i=1;i<AllRows.size();i++) {
//			System.out.println(AllRows.get(i).findElements(By.tagName("td")).get(1).getText());
//		}
		
		//The Header Only
		//WayOne
//		System.out.println(AllRows.get(0).getText());
//		System.out.println(AllRows.get(0).findElements(By.tagName("th")).get(0).getText());
		
		
	}
	
	@Test(enabled = false)
	public void Element_Displayed_Example() throws InterruptedException {
		WebElement HideBtn = driver.findElement(By.id("hide-textbox"));
		HideBtn.click();
		WebElement TheBox = driver.findElement(By.xpath("//input[@id='displayed-text']"));
		boolean ExpectedResult = false;
		Assert.assertEquals(TheBox.isDisplayed(), ExpectedResult);
		Thread.sleep(3000);
		WebElement ShowBtn = driver.findElement(By.id("show-textbox"));
		ShowBtn.click();
		boolean ExpectedResult2 = true;
		Assert.assertEquals(TheBox.isDisplayed(), ExpectedResult2);
	}
	
	@Test(enabled = false)
	public void Enabled_Disabled_Example () throws InterruptedException {
		
		
		WebElement InputFeild = driver.findElement(By.id("enabled-example-input"));
		
		Thread.sleep(5000);
		WebElement DisabledBtn = driver.findElement(By.id("disabled-button"));
		DisabledBtn.click();

		boolean expectedResult = false;
		Assert.assertEquals(InputFeild.isEnabled(), expectedResult);
		
		WebElement EnableBtn = driver.findElement(By.id("enabled-button"));
		EnableBtn.click();
		boolean Expected2 =true;
		Assert.assertEquals(InputFeild.isEnabled(), Expected2);
		InputFeild.sendKeys("123");
	}
	
	@Test(enabled = false)
	public void Mouse_Hover_Example() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,2000)");
		Thread.sleep(3000);
		WebElement hoverBox = driver.findElement(By.id("mousehover"));
		Actions myAction = new Actions(driver);
		myAction.moveToElement(hoverBox).build().perform();
		driver.findElement(By.linkText("Top")).click();
		
	}
	@Test(enabled = false)
	public void Calendar_Example() {
		WebElement calenderLink = driver.findElement(By.linkText("Booking Calendar"));
		calenderLink.click();
		//ft7at new Tab 
		Set<String> handels = driver.getWindowHandles();
		List<String> allTabs = new ArrayList<>(handels);
		driver.switchTo().window(allTabs.get(1));
		
		//kef bde a5le to book appointment
		//driver.findElement(By.linkText("6")).click();
//		WebElement TheTable = driver.findElement(By.cssSelector(".datepick.wpbc_calendar"));
//		List<WebElement> allDates = TheTable.findElements(By.tagName("td"));
//		System.out.println(allDates.get(0).getText());
		
//		LocalDate MyDate =LocalDate.now();
//		String today = Integer.toString(MyDate.getDayOfMonth());
//		driver.findElement(By.linkText(today)).click();
		
		//There is an Bug Becouse its start from one not TodayDate
	}
	
	@Test (enabled = false)
	public void iFrame_Example() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,2500)");
		driver.switchTo().frame("courses-iframe");
		
	driver.findElement(By.cssSelector(".ct-mobile-meta-item.btn-nav-mobile.open-menu")).click();;
	
		
	}
	
	@Test
	public void Downloadfiletotest() {
		driver.findElement(By.linkText("Download Apk files")).click();
	}	
	@AfterTest
	public void AfterFinishedTheTest() {}
}
