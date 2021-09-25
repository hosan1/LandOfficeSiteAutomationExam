package com.bat.LandTraningSeleniumAutomation.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bat.LandTraningSeleniumAutomation.DTO.LoginDTO;
import com.bat.LandTraningSeleniumAutomation.DataProvider.LoginDataProvider;
import com.bat.LandTraningSeleniumAutomation.Utils.DriverManager;
import com.bat.LandTraningSeleniumAutomation.Utils.TestNGReporting;
import com.bat.LandTraningSeleniumAutomation.Utils.PathUtils;

@Listeners(TestNGReporting.class)
public class OfficeRegistrationTest {

	private WebDriver driver = null;

	@Test
	public void dashboardToOffRegistrationPage() throws InterruptedException {

		driver = DriverManager.driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PathUtils.Variabls.সেটিংস)));
		System.out.println("Office Registration start");
		Thread.sleep(3000);
		driver.findElement(By.xpath(PathUtils.Variabls.সেটিংস)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.সেটিংস)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.অফিস_ব্যবস্থাপনা)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.অফিস_তালিকা)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.নতুন_অফিস)).click();
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "dashboardToOffRegistrationPage")
	public void newOffRegistration() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PathUtils.Variabls.সংরক্ষণ)));
		System.out.println("In new user registration page...");

		driver = DriverManager.driver;

		Select off = new Select(driver.findElement(By.id(PathUtils.Variabls.লেভেল)));
		off.selectByVisibleText("উপজেলা");
		Thread.sleep(1000);

		Select d = new Select(driver.findElement(By.id("division_id")));
		d.selectByVisibleText("চট্টগ্রাম");
		Thread.sleep(1000);

		Select dis = new Select(driver.findElement(By.id("district_id")));
		dis.selectByVisibleText("রাঙ্গামাটি");
		Thread.sleep(1000);

		Select u = new Select(driver.findElement(By.id("upazila_id")));
		u.selectByVisibleText("বরকল");
		Thread.sleep(1000);

		driver.findElement(By.id("title-bn")).clear();
		driver.findElement(By.id("title-bn")).sendKeys(PathUtils.Variabls.off_name);
		
		driver.findElement(By.id("title-en")).clear();
		driver.findElement(By.id("title-en")).sendKeys("Upozila vumi office");
		
		driver.findElement(By.id("office-code")).clear();
		driver.findElement(By.id("office-code")).sendKeys("125");
		
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("address");
		
		driver.findElement(By.id("web-url")).clear();
		driver.findElement(By.id("web-url")).sendKeys("hello.com");
		
		driver.findElement(By.id("about-info")).clear();
		driver.findElement(By.id("about-info")).sendKeys("about");

		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("01717569832");

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("a@a.com");
		
		driver.findElement(By.id("fax")).clear();
		driver.findElement(By.id("fax")).sendKeys("fax");  
		
		Select s = new Select(driver.findElement(By.id("status")));
		s.selectByVisibleText("সক্রিয়");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[1]/div[2]/form/div[3]/div/div/button[1]")).click();Thread.sleep(5000);
		// driver.findElement(By.xpath(PathUtils.Variabls.রিসেট)).click();
		
		// Edit Office
		driver = DriverManager.driver;
		
		Select de = new Select(driver.findElement(By.id("division-id")));
		de.selectByVisibleText("চট্টগ্রাম");
		Thread.sleep(3000);

		Select dise = new Select(driver.findElement(By.id("district-id")));
		dise.selectByVisibleText("রাঙ্গামাটি");
		Thread.sleep(3000);

		Select ue = new Select(driver.findElement(By.id("upazila-id")));
		ue.selectByVisibleText("বরকল");
		Thread.sleep(3000);
		
		Select o = new Select(driver.findElement(By.id("office-id")));
		o.selectByVisibleText(PathUtils.Variabls.off_name);
		Thread.sleep(2000);
		
		driver.findElement(By.id("search_btn")).click(); 
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/table/tbody/tr/td[8]/a[1]")).click();Thread.sleep(2000); 
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/form/div[3]/div/div/button[1]")).click();Thread.sleep(1000);

	}

}
