package org.selenide.puzzlers;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.TextReport;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.System.nanoTime;

public class Puzzle8 {

  @Rule
  public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

  private ChromeDriver webdriver;
  long t1, t2, t3, t4, t5, t6;

  @Before
  public void setUp() {
    t1 = nanoTime();
    WebDriverRunner.setWebDriver(webdriver = new ChromeDriver());
    t2 = nanoTime();
    open(getClass().getResource("puzzle7.html"));
    t3 = nanoTime();
  }

  @Test
  public void withoutTimeout() {
    $("#greeting").shouldHave(text("Hello"));
  }

  @Test
  public void performance() {
    for (int i = 0; i < 1000; i++) {
      open(getClass().getResource("puzzle1.html"));
      close();
    }
  }

  @Test(timeout = 8000)
  public void withTimeout() {
    t4 = nanoTime();

    // TODO Почему эта строчка добавляет +4 секунды?
    open(getClass().getResource("puzzle1.html"));

    t5 = nanoTime();
    $("#greeting").shouldHave(text("Hello"));
  }

  @After
  public void tearDown() {
    t6 = nanoTime();
    System.out.println("TIMES:");
    System.out.println("create chrome: " + TimeUnit.NANOSECONDS.toMillis(t2-t1));
    System.out.println("open html: " + TimeUnit.NANOSECONDS.toMillis(t3-t2));
//    System.out.println("t4: " + TimeUnit.NANOSECONDS.toMillis(t4-t3));
    System.out.println("open ff: " + TimeUnit.NANOSECONDS.toMillis(t5-t4));
    System.out.println("assert: " + TimeUnit.NANOSECONDS.toMillis(t6-t5));
    System.out.println("open ff + assert: " + TimeUnit.NANOSECONDS.toMillis(t6-t4));
    webdriver.quit();
  }
}
