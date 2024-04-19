package TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.onlinebanking.creditcoin.objectrepsitory.Homepage;
import com.onlinebanking.creditcoin.objectrepsitory.Staffloginpage;

public class dataProviderForLoginTest {
	
	@Test(dataProviderClass = dataProviderTest.class,dataProvider = "loginpage")
			
	public void getData(String username, String pwd)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/staff_login.php");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Homepage homepage = new Homepage(driver);
		homepage.staffidtxtf(username);
		homepage.passwordtxtf(pwd);
	}
}
