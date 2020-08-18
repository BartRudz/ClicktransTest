package registationForm;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FillRegistationForm {

	public static void main(String[] args) throws InterruptedException {
		//Initializing Chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://dev-1.clicktrans.pl/register-test/courier");
		//Filling all of the required fields
		WebElement companyName = driver.findElement(By.id("user_register_company_name"));
		companyName.sendKeys("My Awesome Company Limited");
		WebElement email = driver.findElement(By.id("user_register_email"));
		email.sendKeys("ceo@awesomecompany.com");
		WebElement name = driver.findElement(By.id("user_register_name"));
		name.sendKeys("Bartholomew Rudsky");
		WebElement phoneCode = driver.findElement(By.id("user_register_phoneCode"));
		Select selectCode = new Select(phoneCode);
		selectCode.selectByValue("1");
		WebElement phone = driver.findElement(By.id("user_register_phone"));
		phone.sendKeys("555666777");
		WebElement password = driver.findElement(By.id("user_register_plainPassword"));
		password.sendKeys("admin123");
		//Selecting agreements
		WebElement checkBox1 = driver.findElement(By.id("user_register_settings_agreementRegulations"));
		checkBox1.click();
		WebElement checkBox2 = driver.findElement(By.id("user_register_settings_agreementPersonalData"));
		checkBox2.click();
		WebElement checkBox3 = driver.findElement(By.id("user_register_settings_agreementMarketing"));
		checkBox3.click();
		//Submitting the form
		WebElement submitBtn = driver.findElement(By.id("user_register_submit"));
		submitBtn.click();
		//Asserting registering of the form
		try {
			WebElement confirm = driver.findElement(By.xpath("//div[@class='ui success message']"));
			confirm.isDisplayed();
			System.out.println("Registration Completed Successfully");
		} catch (Exception e) {
			System.out.println("Registration failed");
		}
		//Quitting the browser
		Thread.sleep(1000);
		driver.quit();
	}
}
