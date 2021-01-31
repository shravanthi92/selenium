package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sakhi\\Desktop\\testing_sravs\\chromedriver_win32\\chromedriver.exe");// setting the chrome
		try {
			
			// creating web driver class
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			// calling the end point url
			driver.get("http://aa.com");
			
			System.out.println(driver.getTitle());
			//explicit wait
			wait = new WebDriverWait(driver, 30);
			
			//clicking on round trip
			clickElement(By.xpath("//*[text()='One way']"));
			clickElement(By.xpath("//*[text()='Round trip']"));
			
			
			// find the From airport elements
			clickElement(By.xpath("//*[@id=\"reservationFlightSearchForm.originAirport\"]"));
			clickElement(By.xpath("//*[@id=\'reservationFlightSearchForm\']/div[3]/div[1]/div/a/span[1]"));
			
			//driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm.originAirport\"]")).click();
			//driver.findElement(By.xpath("//*[@id=\'reservationFlightSearchForm\']/div[3]/div[1]/div/a/span[1]")).click();
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='countryCode']")));
			dropdown.selectByValue("US");
			Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\'stateCode\']")));
			dropdown1.selectByValue("MO");
			
			// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\'airport_MCI\']/span[1]")).click();

			// finding the Destination airport elements
			driver.findElement(By.xpath("//*[@id='reservationFlightSearchForm.destinationAirport']")).click();
			driver.findElement(By.xpath("//*[@id=\'reservationFlightSearchForm\']/div[3]/div[2]/div/a/span[1]")).click();
			Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\'countryCode\']")));
			dropdown2.selectByValue("US");
			Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id=\'stateCode\']")));
			dropdown3.selectByValue("TX");
			
			clickElement(By.xpath("//*[@id='airport_AMA']"));
			//changing the number of passengers
			Select passengers = new Select(driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount")));
			passengers.selectByValue("6");
			//finding dates
			driver.findElement(By.xpath("//*[@id=\'aa-leavingOn\']")).sendKeys("02/07/2021");
			driver.findElement(By.xpath("//*[@id=\'aa-returningFrom\']")).sendKeys("02/11/2021");
			//clicking search
			clickElement(By.xpath("//*[@id='flightSearchForm.button.reSubmit']"));
			
			
			
			//Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//driver.quit();
		}

	}

	public static void clickElement(By by) throws InterruptedException {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();

	}

}
