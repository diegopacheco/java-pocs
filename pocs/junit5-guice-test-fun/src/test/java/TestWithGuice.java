import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.inject.Guice;
import com.google.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWithGuice {

  @Inject
  SomeService service;

  @Inject
  SomeOtherService serviceOther;
  
  @BeforeEach
  public void setup() {
      Guice.createInjector(new GuiceTestModule()).injectMembers(this);		
  }

  @Test
  public void helloTest() {
    assertEquals("works", service.getString());
  }
  
  @Test
  public void helloTestAgain() {
    assertEquals("works too", serviceOther.getString());
  }
}