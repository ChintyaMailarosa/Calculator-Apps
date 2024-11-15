package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TixIDtest {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platFormName", "Android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "id.tix.android");
        dc.setCapability("appActivity", ".splash.view.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL ("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void finish() {
        delay(3);
        driver.quit();
    }

    @Test
    public void testSearchMovie() {
        // Step Action
        delay(10);
        MobileElement search = (MobileElement) driver.findElement(By.id("id.tix.android:id/et_input"));
        search.click();
        delay(3);
        driver.findElement(By.id("id.tix.android:id/et_input")).sendKeys("venom");
        MobileElement searchFirst = (MobileElement) driver.findElement(By.id("id.tix.android:id/tv_search_first"));
        searchFirst.click();
        delay(3);
        String getTitleMovie = driver.findElement(By.id("id.tix.android:id/tv_title_of_movie")).getText();
        Assert.assertTrue(getTitleMovie.contains("Venom"));
//        MobileElement btnTwo = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
//        btnTwo.click();
//        MobileElement btnEq = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/eq"));
//        btnEq.click();
//
//        // Step validasi
//        MobileElement txtResult = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/result_final"));
//        String getTxtResult = txtResult.getText();
//        Assert.assertEquals(getTxtResult, "3");

    }

//    @Test
//    public void testSubtract(){
//        // Step Action
//        MobileElement btnThree = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
//        btnThree.click();
//        MobileElement btnSub = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
//        btnSub.click();
//        MobileElement btnFour = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
//        btnFour.click();
//        MobileElement btnEq = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/eq"));
//        btnEq.click();
//        // Step Validation
//        MobileElement txtResult = (MobileElement) driver.findElement(By.id("com.google.android.calculator:id/result_final"));
//        String getTxtResult = txtResult.getText();
//        Assert.assertEquals(getTxtResult, "−1");
//
//    }

    public static void delay (long detik){
        try{
            Thread.sleep(detik*1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
