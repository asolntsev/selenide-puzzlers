package org.selenide.puzzlers;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Puzzle7 {
  private ChromeDriver webdriver;

  @Before
  public void setUp() {
    WebDriverRunner.setWebDriver(webdriver = new ChromeDriver());
    open(getClass().getResource("puzzle7.html"));
  }

  @Test
  public void withoutTimeout() {
    $("#greeting").shouldHave(text("Hello"));
  }

  @Test(timeout = 8000)
  public void withTimeout() {
    $("#greeting").shouldHave(text("Hello"));
  }

  @After
  public void tearDown() {
    webdriver.quit();
  }
}
