package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task4 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		ChromeDriver driver =new ChromeDriver(opt);
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
	    WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
	    usernameField.sendKeys("Admin");
	    WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
	    passwordField.sendKeys("admin123");
	    // Click on the login button
	    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	    loginButton.click();
	    // Capture the URL
        String currentUrl = driver.getCurrentUrl();
         System.out.println("Current URL Is::+currentUrl");
        // Verify that the URL contains "dashboard"
        if (currentUrl.contains("dashboard")) {
            System.out.println("URL contains 'dashboard'.");
        } else {
            System.out.println("URL does not contain 'dashboard'.");
        }
        Thread.sleep(2000);

        // Click on the image
        WebElement image = driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']"));
        image.click();
        Thread.sleep(2000);
        // Click on Logout
        WebElement logoutButton = driver.findElement(By.xpath("//a[contains(@href,'auth')]"));
        logoutButton.click();
        System.out.println("Logout");
        Thread.sleep(2000);
        // Verify if user is able to navigate to the login page
        String currentUrlafter = driver.getCurrentUrl();
        System.out.println(currentUrlafter);
        if (currentUrlafter.equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
            System.out.println("User is able to navigate to the login page after logout.");
        } else {
            System.out.println("User is not able to navigate to the login page after logout.");
        }
        
        // Close the browser
        driver.quit();

	}

}
