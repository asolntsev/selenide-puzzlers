package org.selenide.puzzlers;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Puzzle5 {
  @Before
  public void setUp() {
    open(getClass().getResource("puzzle5.html"));
  }

  @Test
  public void option1() {
    $("div").$(byText("Click ")).click();
  }

  @Test
  public void option2() {
    $("div").$(byText("Click")).click();
  }

  @Test
  public void option3() {
    $("div").$(withText("Click ")).click();
  }

  @Test
  public void option4() {
    $("div").$(withText("Click")).click();
  }
}
