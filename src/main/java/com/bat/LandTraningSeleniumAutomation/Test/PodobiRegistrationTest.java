package com.bat.LandTraningSeleniumAutomation.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class PodobiRegistrationTest {

	private WebDriver driver = null;

	@Test
	public void dashboardToPodobiRegistrationPage() throws InterruptedException {

		driver = DriverManager.driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PathUtils.Variabls.সেটিংস)));
		System.out.println("Setting Button Present");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.সেটিংস)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.সেটিংস)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.অফিস_ব্যবস্থাপনা)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.পদবি_তালিকা)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.নতুন_পদবি)).click();
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "dashboardToPodobiRegistrationPage")
	public void newPodobiRegistration() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/form/div[3]/div/div/button[1]")));
		System.out.println("In new podobi registration page...");

		driver = DriverManager.driver;

		Select d = new Select(driver.findElement(By.id("division-id")));
		d.selectByVisibleText("চট্টগ্রাম");
		Thread.sleep(2000);

		Select dis = new Select(driver.findElement(By.id("district-id")));
		dis.selectByVisibleText("রাঙ্গামাটি");
		Thread.sleep(2000);

		Select u = new Select(driver.findElement(By.id("upazila-id")));
		u.selectByVisibleText("বরকল");
		Thread.sleep(5000);

		Select o = new Select(driver.findElement(By.id("office-id")));
		o.selectByVisibleText(PathUtils.Variabls.off_name);
		Thread.sleep(1000);
		
		driver.findElement(By.id("name-bn")).clear();
		driver.findElement(By.id("name-bn")).sendKeys(PathUtils.Variabls.podobiB); 
		
		driver.findElement(By.id("name-en")).clear();
		driver.findElement(By.id("name-en")).sendKeys(PathUtils.Variabls.podobi);
		
		driver.findElement(By.id("level")).clear();
		driver.findElement(By.id("level")).sendKeys("125");
		
		driver.findElement(By.id("number")).clear();
		driver.findElement(By.id("number")).sendKeys("45");

		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys("Description");
		
		Select s = new Select(driver.findElement(By.id("status")));
		s.selectByVisibleText("সক্রিয়");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/form/div[3]/div/div/button[1]")).click();Thread.sleep(5000);
		// driver.findElement(By.xpath(PathUtils.Variabls.রিসেট)).click();
		
		// Edit podobi
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
		
		Select oe = new Select(driver.findElement(By.id("office-id")));
		oe.selectByVisibleText(PathUtils.Variabls.off_name);
		Thread.sleep(2000);
		
		driver.findElement(By.id("search_btn")).click(); 
		Thread.sleep(5000);
				
		 WebElement table = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/div[3]/table/tbody"));
		    List<WebElement> allRows = table.findElements(By.tagName("tr"));
		    for (WebElement row : allRows) {	    	
		        List<WebElement> rowCells = row.findElements(By.tagName("td"));
		        String podobi=rowCells.get(0).getText();		       
		            if (podobi.equals(PathUtils.Variabls.podobiB)) {          	
		            	  List<WebElement> rowItem = rowCells.get(3).findElements(By.tagName("a"));
		            	  String som=rowItem.get(0).getText();
		            	  if(som.equals("সম্পাদন")) {
		            		  rowItem.get(0).click();
		            	  }	            	
		        }	       
		    }
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div[2]/form/div[3]/div/div/button[1]")).click();Thread.sleep(2000);

	}

}
