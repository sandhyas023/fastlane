package com.lambdatest.lambdatest_android_sample_app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static org.junit.Assert.assertTrue;

public class MainActivityUnitTest {

  private AndroidDriver driver;
  private String server ;

  @Before
  public void setUp() throws Exception {
   server = "mobile-hub.lambdatest.com";

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }


  @Test
  public void checkIfWelcomToLambdatestViewIsPresent() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "android");
    capabilities.setCapability("deviceName", "Pixel 4");
    capabilities.setCapability("platformVersion", "10");
    capabilities.setCapability("build", "Lambdatest build");
    capabilities.setCapability("name", "Lambdatest");
    capabilities.setCapability("isRealMobile", true);
    capabilities.setCapability("video", true);
    capabilities.setCapability("console", true);

    String username = System.getenv("LT_USERNAME");
    String accessKey = System.getenv("LT_ACCESS_KEY");

    // App url of the uploaded app on lambdatest.
    String app = System.getenv("APP_URL");
    capabilities.setCapability("app", app);

    driver = new AndroidDriver(new URL("https://" + username + ":" + accessKey + "@" + server + "/wd/hub"), capabilities);

    String assertionLabel = "TextView with text 'WelcomeToLambdatestTextView' is present.";
    Thread.sleep(30);
    List<AndroidElement> elements = driver.findElementsById("WelcomeToLambdatestTextView");
    if (elements.size() > 0) {
      String textViewText = elements.get(0).getText();
      assertTrue(assertionLabel, textViewText.equals("Welcome To LambdaTest"));
    } else {
      assertTrue(assertionLabel, false);
    }
    driver.executeScript("lambda-status=passed");

  }
}

