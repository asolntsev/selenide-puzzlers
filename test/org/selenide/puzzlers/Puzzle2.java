package org.selenide.puzzlers;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertNotNull;

public class Puzzle2 {
  @Before
  public void setUp() {
    open(getClass().getResource("puzzle2.html"));
  }

  @Test
  public void find() {
    SelenideElement el = $("div#ab").$("a");
    assertNotNull(el);
  }
}
