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

@Test
public void testcase4() throws InterruptedException, IOException {
	
	service=startserver();
	driver=capability(appPackage,appActivity,deviceName,chromedriverExecutable);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anand");
	
	driver.findElement(By.xpath("//*[@text='Female']")).click();
	driver.findElement(By.id("android:id/text1")).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();	
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(3000);
    String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
    amount1 = amount1.substring(1);
    double amount1value = Double.parseDouble(amount1);
    
    
    String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
    amount2 = amount2.substring(1);
    double amount2value = Double.parseDouble(amount2);
    
    //Sum of the amount of first two product
    double TotalAmount = amount1value + amount2value;
    
    //Final one
    String finalamount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
    finalamount = finalamount.substring(1);
    double FinalTotal = Double.parseDouble(finalamount);
    
    Assert.assertEquals(FinalTotal, TotalAmount);
    //tap on checkbox
    //longpress on please read terms and condition
    //popup where i have to click on ok button
    //then i have to click on visit to website to complete purchase
    
    AndroidElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
    TouchAction t = new TouchAction(driver);
    t.tap(tapOptions().withElement(element(checkbox))).perform();
    AndroidElement terms =driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
    t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(3))).release().perform();
    System.out.println(driver.findElement(By.id("android:id/message")).getText());
    driver.findElement(By.xpath("//*[@text='CLOSE']")).click();
    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    Thread.sleep(8000);
 
    //to shift from native to web
    
    Set<String> contextNames = driver.getContextHandles();
    for (String contextName : contextNames) {
        System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
    }
    driver.context("WEBVIEW_com.androidsample.generalstore");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
    driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    
    driver.pressKey(new KeyEvent(AndroidKey.BACK));	
    driver.context("NATIVE_APP");
    service.stop();
    
    //
 }

}