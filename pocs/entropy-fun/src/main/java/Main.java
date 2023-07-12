import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String args[]) {
        System.out.println("===== Entropy visualization ===== ");
        System.out.println(" yes                             == " + Entropy.entropy("yes".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" no                              == " + Entropy.entropy("no".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" 111111111                       == " + Entropy.entropy("111111111".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" 123555489                       == " + Entropy.entropy("123555489".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" 89506                           == " + Entropy.entropy("89506".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" Marie Jane                      == " + Entropy.entropy("Marie Jane".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" john@jhon.com                   == " + Entropy.entropy("john@jhon.com".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" crazy@developer.io              == " + Entropy.entropy("crazy@developer.io".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" simple message here             == " + Entropy.entropy("simple message here".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" start the jboss server on 8080  == " + Entropy.entropy("start the jboss server on 8080".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" 2d4Gtyh$gJK^%5                  == " + Entropy.entropy("2d4Gtyh$gJK^%5".getBytes(StandardCharsets.UTF_8)));
        System.out.println(" a3d45f6h7kj8l0_[;>/4            == " + Entropy.entropy("a3d45f6h7kj8l0_[;>/4".getBytes(StandardCharsets.UTF_8)));
    }
}
