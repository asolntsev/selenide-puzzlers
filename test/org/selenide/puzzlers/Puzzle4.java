package org.selenide.puzzlers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Puzzle4 {
  long start;

  @Before
  public void setUp() {
    open(getClass().getResource("puzzle4.html"));
    start = System.nanoTime();
  }

  @Test
  public void find() {
    $("div#abc a").shouldNotBe(visible);
  }

  @After
  public void tearDown() {
    long end = System.nanoTime();
    System.out.println(TimeUnit.NANOSECONDS.toMillis(end-start));
  }
}
