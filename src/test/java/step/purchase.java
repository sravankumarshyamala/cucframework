package step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class purchase 

{
	public static WebDriver driver;
	String str;
	
	@Given("i opened url {string}")
	public void i_opened_url(String url)
	{
		System.setProperty("Webdriver.chromedriver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	   
	}
	@When("i enter my username {string}")
	public void i_enter_my_username(String name) throws InterruptedException 
	{
	    driver.findElement(By.id("username")).clear();
	    Thread.sleep(3000);
	    driver.findElement(By.id("username")).sendKeys(name);
	    
	}
	@When("i enter my password {string}")
	public void i_enter_my_password(String pass) throws InterruptedException 
	{
		driver.findElement(By.id("password")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(pass);
	    
	}
	@When("i click on login button")
	public void i_click_on_login_button() 
	{
	    driver.findElement(By.id("btnsubmit")).click();
	}
	@When("i click on purchases link")
	public void i_click_on_purchases_link() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(By.linkText("Purchases")).click();
	    
	}
	@When("i click on add icon")
	public void i_click_on_add_icon()
	{
	    driver.findElement(By.xpath("(//span[@class=\"glyphicon glyphicon-plus ewIcon\"])[1]")).click();
	}
	@When("i capature purchase number")
	public void i_capature_purchase_number() 
	{
	   str =driver.findElement(By.xpath("//input[@id=\"x_Purchase_Number\"]")).getAttribute("value");
	  System.out.println(str);
	}
	@When("i capature purchase date")
	public void i_capature_purchase_date() 
	{
	    String str1=driver.findElement(By.xpath("//input[@id=\"x_Purchase_Date\"]")).getAttribute("value");
	    driver.findElement(By.xpath("//input[@id=\"x_Purchase_Date\"]")).clear();
	    driver.findElement(By.xpath("//input[@id=\"x_Purchase_Date\"]")).sendKeys(str1);
	}
	@When("i select supplier id {string}")
	public void i_select_supplier_id(String supplierid) 
	{
	   WebElement a =driver.findElement(By.id("x_Supplier_ID"));
	   Select sc= new Select(a);
	   sc.selectByVisibleText(supplierid);
	}
	@When("i enter notes {string}")
	public void i_enter_notes(String notes) 
	{
	   driver.findElement(By.xpath("//input[@id=\"x_Notes\"]")).sendKeys(notes);
	}
	@When("i enter total amount {string}")
	public void i_enter_total_amount(String totalamount) 
	{
	  driver.findElement(By.xpath("//input[@id=\"x_Total_Amount\"]")).sendKeys(totalamount);
	}
	@When("i enter total payment {string}")
	public void i_enter_total_payment(String totalpayment)
	{
	 driver.findElement(By.xpath("//input[@id=\"x_Total_Payment\"]")).sendKeys(totalpayment);
	}
	@When("i click on add button")
	public void i_click_on_add_button() throws InterruptedException 
	{
     driver.findElement(By.id("btnAction")).click();
     Thread.sleep(3000);
     
	}
	@When("i click on confirm record")
	public void i_click_on_confirm_record() throws InterruptedException 
	{
		driver.findElement(By.xpath("//button[text()=\"OK!\"]")).click();
		Thread.sleep(3000);
	}
	@When("i click on add alert record")
	public void i_click_on_add_alert_record() 
	{
	 driver.findElement(By.xpath("(//button[text()=\"OK\"])[6]")).click();
	}
	@When("i click on search icon")
	public void i_click_on_search_icon() 
	{
      boolean res=driver.findElement(By.id("psearch")).isDisplayed();
      if(!res)
      {
    	  driver.findElement(By.xpath("//span[@class=\"glyphicon glyphicon-search ewIcon\"]")).click();
    	  driver.findElement(By.id("psearch")).sendKeys(str);
    	  driver.findElement(By.id("btnsubmit")).click();
      }
      else
      {
    	  driver.findElement(By.id("psearch")).sendKeys(str);
    	  driver.findElement(By.id("btnsubmit")).click();  
      }
	}
	@Then("i click on logout")
	public void i_click_on_logout() throws InterruptedException 
	{
	  driver.findElement(By.linkText("Logout")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[text()=\"OK!\"]")).click();
	}
	@Then("i close my browser")
	public void i_close_my_browser() 
	{
      driver.close();
	}

}
