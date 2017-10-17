package com.github.diegopacheco.sandbox.java.junit.test.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ SlowTests.class, FastTests.class })
public class B {
  
  @Test
  public void c() {

  }
  
}
