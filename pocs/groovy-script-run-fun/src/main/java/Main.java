import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class Main{
  public static void main(String args[]){
      simpleShell();
  }

  private static void simpleShell(){
    String groovyScript = "print foo";
    Binding binding = new Binding();
    binding.setVariable("foo", Integer.valueOf(2));
    GroovyShell shell = new GroovyShell(binding);
    Object value = shell.evaluate(groovyScript);
  }

}
