package com.github.diegopacheco.projectc;

import com.github.diegopacheco.projecta.CompareUtils;
import com.github.diegopacheco.projectb.CustomLogger;

public class App {

  public int compare(){
    int result = CompareUtils.compare(2, 2);
    return result;
  }

  public static void main(String... args) throws Exception {
    App app = new App();
    CustomLogger.log("Result is: " + app.compare());
  }

}
