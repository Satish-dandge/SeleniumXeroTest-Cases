package Xero.Xero_User;

 
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import Resources.Homepage;
import Resources.POM_AddAccount;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import Resources.POM_BankAccount;
import Resources.POM_Login;


public class Add_Bank_Account extends Homepage{

	public WebDriver driver;
	
	@BeforeMethod
	
	@Parameters("browser")
	public void setup(String browser) {
		

			  if(browser.equalsIgnoreCase("firefox")) {
				 
				  System.setProperty("webdriver.gecko.driver", "C:\\Users\\satis\\eclipse-workspace\\Xero\\geckodriver.exe");
				  driver = new FirefoxDriver();	  

			  }else if (browser.equalsIgnoreCase("chrome")) { 

				  
				  System.setProperty("webdriver.chrome.driver", "C:\\Users\\satis\\eclipse-workspace\\Xero\\chromedriver.exe");
				  driver = new ChromeDriver();

			  } 
		
  }
 

WebDriverWait wait;	
POM_BankAccount pb = new POM_BankAccount();
POM_AddAccount  pa = new POM_AddAccount();
POM_Login p = new POM_Login();

//Verify the Login is successful and user is navigated to home page
@Test
     public void Hompage() throws InterruptedException {

	  Homepage_Login(driver);
	  String header= driver.findElement(By.xpath("//*[@id=\"xero-main-dashboard\"]/div/div[1]/div/div/div/div[2]/div[2]/h3/span")).getText();
      Assert.assertEquals("Hi, let’s get set up", header);

}
 
//Verify that the Add Account page is populated successfully 
@Test
    public void BankAccount() throws InterruptedException {	
	Homepage_Login(driver);
	pb.Login(driver);
	pb.Accounting_List();
	pb.BankAccount_Link();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gettingStarted\"]/div/p[1]")));
	String Bankheader= driver.findElement(By.xpath("//*[@id=\"gettingStarted\"]/div/p[1]")).getText();
	Assert.assertEquals("Connect your bank account to Xero so transactions flow in automatically", Bankheader);
}
 
//Verify the Invalid data on Bank Details page
@Test
public void BankAccount_InvalidData() throws InterruptedException {	
Homepage_Login(driver);
pb.Login(driver);
pb.Accounting_List();
pb.BankAccount_Link();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gettingStarted\"]/div/p[1]")));
String Bankheader= driver.findElement(By.xpath("//*[@id=\"gettingStarted\"]/div/p[1]")).getText();
Assert.assertEquals("Connect your bank account to Xero so transactions flow in automatically", Bankheader);
}

//Verify that the account details added successfully for user 
@Test
    public void AddBankAccount() throws InterruptedException {
	pa.driver_util(driver);
	BankAccount();	
	pa.AddBank_Account_Button();
	//driver.findElement(By.xpath("//form[@id='frmMain']/div/div[1]/div[2]/a[@href='/app/!S36p8/bank-search']/span[@class='text']")).click();	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shell-app-root']/article[@class='bank-search-ui-SharedLayout']/main[@role='main']/article[@class='bank-search-ui-IndexRoute']/div/div/div[3]/a[@href='/Banking/Account/#add/direct/21aa230b-ad51-4756-949d-19028adbb0bd']//span[@class='bank-search-normal-text']")));
	driver.findElement(By.xpath("//div[@id='shell-app-root']/article[@class='bank-search-ui-SharedLayout']/main[@role='main']/article[@class='bank-search-ui-IndexRoute']/div/div/div[3]/a[@href='/Banking/Account/#add/direct/21aa230b-ad51-4756-949d-19028adbb0bd']//span[@class='bank-search-normal-text']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[@id='view']//section/div[1]/div[@role='presentation']/div[@role='presentation']/div/div[@role='presentation']/div[@role='presentation']/div[2]//input[@role='textbox']")).sendKeys("DemoBank12");
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div[1]/div/div/div/div/div/div[4]/div[1]/div/div[1]/input")).click();           
	Thread.sleep(500);
    driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"accountnumber-1056-inputEl\"]")).sendKeys("011211212128");
	driver.findElement(By.xpath("//*[@id=\"common-button-submit-1015-btnInnerEl\"]")).click();
	Thread.sleep(4000);
	String s = driver.getPageSource();
	System.out.println(s);
	Thread.sleep(4000);
	Assert.assertTrue(driver.getPageSource().contains("Connect with bank"));		
}

//Verify that the Add Account page is populated successfully 
@Test
  public void Login_Unsuccessful_Password() throws InterruptedException {	
	p.Login(driver);
	p.URL("https://login.xero.com/identity/user/login");
	p.setUserName("Satish@gmail.com");
	p.Loginbutton();
	Assert.assertTrue(driver.getPageSource().contains("Please enter your password"));
}


  @AfterMethod
  public void afterClass() {
  driver.quit();
  }
 
}