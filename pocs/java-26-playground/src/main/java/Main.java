
public class Main{
  public static void main(String args[]) throws Exception {
    System.out.println("=== Java 26 Playground ===\n");

    AotCachingFeature.run();
    System.out.println();

    G1GcThroughputFeature.run();
    System.out.println();

    Http3ClientFeature.run();
    System.out.println();

    PemEncodingsFeature.run();
    System.out.println();

    StructuredConcurrencyFeature.run();
    System.out.println();

    LazyConstantsFeature.run();
    System.out.println();

    PrimitivePatternFeature.run();
    System.out.println();

    FinalFieldReflectionFeature.run();
    System.out.println();

    AppletApiRemovalFeature.run();
  }
}
