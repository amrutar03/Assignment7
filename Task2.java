package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task2 {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver =new ChromeDriver(opt);
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
	    uname .sendKeys("Admin");
	    
	    // Click on the login button
	    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	    loginButton.click();
	    
	    // Verify password field for the required message
	    WebElement pwdField=driver.findElement(By.xpath("//input[@type='password']"));
	    WebElement pwdFieldRequired=driver.findElement(By.xpath("//span[text()='Required']"));
	     System.out.println("PWD Error Msg:: "+pwdFieldRequired.getText());
	    
          if(pwdField.isDisplayed() && pwdFieldRequired.isDisplayed())
          {
        	  System.out.println("Password field is showing the required message.");
          }else
          {
        	  System.out.println("Password field is Not showing the required message.");  
          }
	
	
	driver.quit();
	
	}

}
