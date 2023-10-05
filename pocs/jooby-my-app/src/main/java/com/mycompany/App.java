package com.mycompany;

import java.util.UUID;
import org.jooby.Jooby;

public class App extends Jooby {

  {
    get("/", () -> UUID.randomUUID().toString());
  }

  public static void main(final String[] args) {
    run(App::new, args);
  }

}
