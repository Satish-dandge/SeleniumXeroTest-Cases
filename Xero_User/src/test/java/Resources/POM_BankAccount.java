package Resources;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public  class POM_BankAccount {
	
	 WebDriver driver;

	    By Accounting_List = By.xpath("//*[@id=\"header\"]/header/div/ol[1]/li[3]/button");

	    By BankAccount_Link = By.xpath("//*[@id=\"header\"]/header/div/ol[1]/li[3]/div/div[2]/div/ol[1]/li[1]/a");

	    
	    public void Login(WebDriver driver){

	        this.driver = driver;

	    }

	    public void Accounting_List(){

	        driver.findElement(Accounting_List).click();;

	    }

	    public void BankAccount_Link(){

	         driver.findElement(BankAccount_Link).click();

	    }
	    
	    
}
