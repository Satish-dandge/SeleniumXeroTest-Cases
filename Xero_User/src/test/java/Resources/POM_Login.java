package Resources;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public  class POM_Login {
	
	 WebDriver driver;
	 
	    String URL = "https://login.xero.com/identity/user/login";
        
	    By Username = By.name("Username");

	    By Password = By.id("xl-form-password");

	    By Login_button = By.xpath("/html//button[@id='xl-form-submit']");   
	    
	    By Backup_Method = By.xpath("/html//div[@id='auth-splashpage']//button[@type='submit']");
	    
	    By Security= By.xpath("/html//div[@id='auth-splashpage']/div[@class='auth-panel']/div//div[@class='auth-panel-layout-inner']/div/div[2]/button[@type='button']");
	    
	    By Security_question1= By.xpath("/html/body/div/div/div/div/form/div[1]/label");
	    
	    By Security_question2= By.xpath("/html/body/div/div/div/div/form/div[2]/label");
	    
	    public void Login(WebDriver driver){

	        this.driver = driver;

	    }

	    public void setUserName(String strUserName){

	        driver.findElement(Username).sendKeys(strUserName);

	    }

	    public void setPassword(String strPassword){

	         driver.findElement(Password).sendKeys(strPassword);

	    }
	    
	    public void URL(String URL){

	         driver.get(URL);

	    }
	    
	    public void Loginbutton(){

	         driver.findElement(Login_button).click();;

	    }
	    
	    public void BackupMethod(){

	         driver.findElement(Backup_Method).click();;

	    }

	    public void Security(){

	         driver.findElement(Security).click();;

	    }
	    public String Security_question(){

	        String question= driver.findElement(Security_question1).getText();
	        return question;

	    }
	    public String Security_question2(){

	        String question= driver.findElement(Security_question2).getText();
	        return question;

	    }
}
