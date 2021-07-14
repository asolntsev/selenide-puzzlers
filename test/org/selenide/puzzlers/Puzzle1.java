package org.selenide.puzzlers;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Puzzle1 {
  @Before
  public void setUp() {
    open(getClass().getResource("puzzle1.html"));
  }

  @Test
  public void option1() {
    $("div a").click();
  }

  @Test
  public void option2() {
    $("div").$("a").click();
  }
}
