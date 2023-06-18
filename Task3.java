package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task3 {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver =new ChromeDriver(opt);
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
	    usernameField.sendKeys("Admin");
	    WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
	    passwordField.sendKeys("mukesh");
	    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	    loginButton.click();
	    
	    WebElement errormsg=driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
	    String msg=errormsg.getText();
	    System.out.println(msg);
	    
	    if(msg.contains("Invalid credentials"))
	    {
	    	System.out.println("Error message contains 'Invalid credentials'.");
	    }else
	    {
	    	System.out.println("Error message DoesNot contains 'Invalid credentials'.");
	    }
	    
	    
	    
	    

	}

}
