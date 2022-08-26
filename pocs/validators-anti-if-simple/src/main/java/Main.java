public class Main{
  public static void main(String args[]){
    Person p = new Person();
    p.setName("Diego");
    System.out.println(p + " is valid? " + Validators.validade(p));

    Person p2 = new Person();
    p2.setName("");
    System.out.println(p2 + " is valid? " + Validators.validade(p2));
  }
}
