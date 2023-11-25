
public class Main{
  public static void main(String args[]){
    Guitar g = new FlyingV("white");
    System.out.println(getFamousPlayerV1(g));
    System.out.println(getFamousPlayerV2(g));
  }

  private static String getFamousPlayerV1(Guitar guitar){
    if (guitar instanceof LesPaul){
        return "Famous LesPaul player is Slash";
    }
    if (guitar instanceof FlyingV){
      return "Famous FlyingV player is James Hatfield";
    }
    return null;
  }

  private static String getFamousPlayerV2(Guitar guitar){
    return switch (guitar){
      case FlyingV(var color) -> "Famous FlyingV "  + color + "player is James Hatfield";
      case LesPaul ignored -> "Famous LesPaul player is Slash";
      // if comment out LesPaul - Error - 'switch' expression does not cover all possible input values
    };
  }

}

sealed interface Guitar permits LesPaul, FlyingV{};
final class LesPaul implements Guitar{};
record FlyingV(String color) implements Guitar{};
