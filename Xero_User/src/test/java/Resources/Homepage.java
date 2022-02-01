package Resources;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class Homepage {
	
	public void Homepage_Login(WebDriver driver) throws InterruptedException {
		
		
	POM_Login p = new POM_Login();
	p.Login(driver);
	driver.get("https://login.xero.com/identity/user/login");
	driver.manage().window().maximize();
	p.setUserName("Satishdandge30@gmail.com");
	p.setPassword("S@tish007");
	p.Loginbutton();
    p.BackupMethod();
    p.Security();
	Thread.sleep(2000);
	String sq=p.Security_question();


	if (sq.contains("dream car")){
		
		driver.findElement(By.xpath("/html//div[@id='auth-splashpage']//form/div[1]/div/input")).sendKeys("Polo");
	}
	else if(sq.contains("fictional"))
			{
		
		driver.findElement(By.xpath("/html//div[@id='auth-splashpage']//form/div[1]/div/input")).sendKeys("Harry");
	} else {
		
		driver.findElement(By.xpath("/html//div[@id='auth-splashpage']//form/div[1]/div/input")).sendKeys("Xero");
	}
	
	String sq2=p.Security_question2();
	if (sq2.contains("dream car")){
		
		driver.findElement(By.xpath("/html//div[@id='auth-splashpage']//form/div[2]/div/input")).sendKeys("Polo");
	}
	else if(sq2.contains("fictional"))
			{
		
		driver.findElement(By.xpath("/html//div[@id='auth-splashpage']//form/div[2]/div/input")).sendKeys("Harry");
	} else {
		
		driver.findElement(By.xpath("/html//div[@id='auth-splashpage']//form/div[2]/div/input")).sendKeys("Xero");
	}
			
	driver.findElement(By.xpath("//*[@id=\"auth-splashpage\"]/div/div/form/button[1]")).click();
	Thread.sleep(4000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"xero-main-dashboard\"]/div/div[1]/div/div/div/div[2]/div[2]/h3/span")));
	
}
}
