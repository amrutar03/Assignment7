package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1 {

	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver =new ChromeDriver(opt);
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    // Click on the login button
	    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	    loginButton.click();
        // Verify required fields for userName and password
	    WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
	    WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));

	    if (usernameField.isDisplayed() && passwordField.isDisplayed()) {
	         System.out.println("Required fields for username and password are present.");
	        } else {
	          System.out.println("Required fields for username and password are not present.");
	        }

	     // Verify the border width of userName and password fields
	    String usernameBorder = usernameField.getCssValue("border-width");
	    System.out.println(usernameBorder);
        String passwordBorder = passwordField.getCssValue("border-width");
        System.out.println(usernameBorder);
	      if (usernameBorder.equals("1px") && passwordBorder.equals("1px")) {
            System.out.println("Username and password fields have a border of 1px.");
            } else {
	         System.out.println("Username and password fields do not have a border of 1px.");
	        }

	   // Close the browser
	      driver.quit();
	        }

	}


