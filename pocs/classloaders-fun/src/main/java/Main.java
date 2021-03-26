import java.lang.reflect.Method;

public class Main{

  public static void main(String args[]) throws Exception{
    CustomCL customClassLoader = new CustomCL();
    Class<?> c = customClassLoader.findClass(ShowCL.class.getName());
    Object ob = c.newInstance();
    Method md = c.getMethod("printCL");
    md.invoke(ob);
  }

}
