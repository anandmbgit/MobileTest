package Practise.AppiumFramework;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC_01 extends Capability{
AndroidDriver<AndroidElement>driver;

@BeforeTest
public void bt() throws IOException, InterruptedException {
	//driver=capability(appPackage,appActivity,deviceName,chromedriverExecutable);
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Thread.sleep(5000);
}
	@Test() 
    public void signinandverify() throws IOException, Exception {
		service=startserver();
		driver=capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	//driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
    	//Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
     	//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")).click();    //driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
  	    driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("anandmb@gmail.com");
    	driver.hideKeyboard();
    	driver.findElementByAccessibilityId("Password").sendKeys("anand@khan123");
    	driver.hideKeyboard();
    	driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign in\"]/android.widget.TextView")).click();
    	
    	boolean joinclass=driver.findElement(By.xpath("//*[@text='Join class']")).isDisplayed();
    	
    	if(joinclass=true) {
    		System.out.println("User is logged in"); 
    	} 
    	else
    		System.out.println("User is not logged in");
    	
    	driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
    	driver.findElement(By.xpath("//*[@text='Sign out']")).click();
    	driver.findElement(By.xpath("//*[@text='SIGN OUT']")).click();
    	System.out.println("User logged out");
    	Thread.sleep(3000);
 }
    
     
    @Test(enabled=false) 
    public void joiningClass() throws IOException, Exception {
    	
    	service=startserver();
		driver=capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
     	//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")).click();    //driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
  	    driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("anandmb@gmail.com");
    	driver.hideKeyboard();
    	driver.findElementByAccessibilityId("Password").sendKeys("anand@khan123");
    	driver.hideKeyboard();
    	driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign in\"]/android.widget.TextView")).click();
    	driver.findElement(By.xpath("//*[@text='Join class']")).click();
    	driver.findElementByAccessibilityId("e.g. ABC123 or teacher@example.com").sendKeys("abc@gmail.com");
    	Thread.sleep(2000);
    	driver.hideKeyboard();
    	driver.findElement(By.xpath("//*[@text='ADD']")).click();
    	driver.findElement(By.xpath("//*[@text='ADD']")).click();
    	//driver.findElement(By.className("android.widget.Button")).click();
    	driver.findElement(By.xpath("//*[@text='DISMISS']")).click();
    	
    	driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
    	driver.findElementByAndroidUIAutomator("text(\"Manage teachers\")").click();
    	boolean deleteButton=driver.findElementByAccessibilityId("Delete").isDisplayed();
        if(deleteButton=true)
        	System.out.println("User joined the class");
        else
      
        	System.out.println("User not joined the class");
       Thread.sleep(3000); 
       
    } 
    
    @Test(enabled=false) 
    public void manageTeacherandremove() throws IOException, Exception {
    	
    	service=startserver();
		driver=capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	
    	//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	//driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
    	//Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
     	//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")).click();    //driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
  	    driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("anandmb@gmail.com");
    	driver.hideKeyboard();
    	driver.findElementByAccessibilityId("Password").sendKeys("anand@khan123");
    	driver.hideKeyboard();
    	driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign in\"]/android.widget.TextView")).click();
    	driver.findElement(By.xpath("//*[@text='Join class']")).click();
    	driver.findElementByAccessibilityId("e.g. ABC123 or teacher@example.com").sendKeys("abc@gmail.com");
    	Thread.sleep(2000);
    	driver.hideKeyboard();
    	driver.findElement(By.xpath("//*[@text='ADD']")).click();
    	driver.findElement(By.xpath("//*[@text='ADD']")).click();
    	//driver.findElement(By.className("android.widget.Button")).click();
    	driver.findElement(By.xpath("//*[@text='DISMISS']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
    	driver.findElementByAndroidUIAutomator("text(\"Manage teachers\")").click();
    	
    	driver.findElementByAccessibilityId("Delete").click();
    	driver.findElementByAndroidUIAutomator("text(\"REMOVE\")").click();
    	
    	boolean noTeacher=driver.findElementByAndroidUIAutomator("text(\"No teachers\")").isDisplayed();
    	if(noTeacher=true)
    	    {
    		System.out.println("Added Teacher name has been removed");
    	    }
    	else
    		System.out.println("Teacher name is not removed");
   
     driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.ImageView")).click();
     driver.findElementByAndroidUIAutomator("text(\"Sign out\")").click();
     driver.findElementByAndroidUIAutomator("text(\"SIGN OUT\")").click();
     System.out.println("User logged out");
     Thread.sleep(2000);
 	
    }
   
    @Test(enabled=false) 
    public void khanacademyforKids() throws IOException, Exception {
    	service=startserver();
		driver=capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	//driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
    	//Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
     	//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")).click();    //driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
  	    driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("anandmb@gmail.com");
    	driver.hideKeyboard();
    	driver.findElementByAccessibilityId("Password").sendKeys("anand@khan123");
    	driver.hideKeyboard();
    	driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign in\"]/android.widget.TextView")).click();
    	Thread.sleep(2000);
    	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Get our free, award-winning app for kids ages 2-7.\"))").click();
    
    	//JavascriptExecutor js1=(JavascriptExecutor)driver;
     	//WebElement tillEnd=driver.findElement(By.xpath("//*[@text='Get our free, award-winning app for kids ages 2-7.']"));
  	    //js1.executeScript("arguments[0].scrollIntoView(true)", tillEnd);
    	
    }
    	
    
    
    @Test(enabled=false) 
    public void termsandconditions() throws IOException, Exception {
    	service=startserver();
		driver=capability(appPackage,appActivity,deviceName,chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	
    	//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	//driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
    	//Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
     	//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")).click();    //driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='Sign in']")).click();
  	    driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys("anandmb@gmail.com");
    	driver.hideKeyboard();
    	driver.findElementByAccessibilityId("Password").sendKeys("anand@khan123");
    	driver.hideKeyboard();
    	driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign in\"]/android.widget.TextView")).click();
    	
    	driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Terms of service\"))").click();
    	
    	driver.findElement(By.id("android:id/button_once")).click();
    	
    	Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); 
        }
        driver.context("WEBVIEW_org.khanacademy.android");
    	
    	boolean terms=driver.findElement(By.xpath("//*[@text='Khan Academy Terms of Service']")).isDisplayed();
        if(terms=true)
        	System.out.println("Khan Academy Terms of Service is displayed");
        else
        	System.out.println("Khan Academy Terms of Service is not displayed");
        
        driver.close();
        
    }
    
}	