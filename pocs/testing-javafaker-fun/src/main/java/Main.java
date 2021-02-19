import com.github.javafaker.Faker;

public class Main{
  public static void main(String args[]){
    Faker faker = new Faker();
    String name = faker.name().fullName();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    System.out.println("first: [" + name + "] firstname: [" + firstName + "] last [" + lastName + "]");

    String streetAddress = faker.address().streetAddress();
    System.out.println("Address: " + streetAddress);

    System.out.println("Md5: " + faker.crypto().md5());
    System.out.println("Harry Potter Char: " + faker.harryPotter().character());
  }
}
