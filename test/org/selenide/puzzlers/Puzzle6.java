package org.selenide.puzzlers;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Puzzle6 {
  @Before
  public void setUp() {
    open(getClass().getResource("puzzle6.html"));
    $("#greeting").shouldBe(visible).shouldHave(text("Hello"));
  }

  @Test
  public void shouldHaveStrings() {
    $("#greeting").shouldNotHave(text(""));
  }
}
