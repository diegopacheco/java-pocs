import io.avaje.inject.BeanScope;

public class Main{
  public static void main(String args[]){
      BeanScope beanScope = BeanScope.builder().build();
      com.example.Example ex = beanScope.get(com.example.Example.class);
      System.out.println(beanScope);
      System.out.println(ex);
  }
}
