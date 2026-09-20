import com.github.diegopacheco.java27.compactheaders.CompactObjectHeaders;
import com.github.diegopacheco.java27.lazyconstants.LazyConstants;
import com.github.diegopacheco.java27.pqctls.HybridKeyExchange;
import com.github.diegopacheco.java27.primitivepatterns.PrimitivePatterns;
import com.github.diegopacheco.java27.primitivepatterns.PrimitivePatterns.Json;
import com.github.diegopacheco.java27.structuredconcurrency.StructuredConcurrency;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Java " + Runtime.version() + " - top 5 features");

        section("JEP 531 - Lazy Constants (Third Preview)");
        LazyConstants lazy = new LazyConstants();
        System.out.println("initializations before use : " + lazy.initializations());
        System.out.println("banner                     : " + lazy.banner());
        System.out.println("lazy list square(4)        : " + lazy.square(4));
        System.out.println("lazy map width(constant)   : " + lazy.width("constant"));
        System.out.println("lazy set VERBOSE enabled   : " + lazy.isEnabled(LazyConstants.Option.VERBOSE));
        System.out.println("initializations after use  : " + lazy.initializations());

        section("JEP 532 - Primitive Types in Patterns, instanceof and switch (Fifth Preview)");
        System.out.println("status(2)                  : " + PrimitivePatterns.status(2));
        System.out.println("status(42)                 : " + PrimitivePatterns.status(42));
        System.out.println("narrowest(7.0)             : " + PrimitivePatterns.narrowest(7.0));
        System.out.println("narrowest(100000.0)        : " + PrimitivePatterns.narrowest(100000.0));
        System.out.println("narrowest(1.5)             : " + PrimitivePatterns.narrowest(1.5));
        System.out.println("narrowest(0.1)             : " + PrimitivePatterns.narrowest(0.1));
        Json person = new Json.Obj(Map.of("name", new Json.Str("Diego"), "age", new Json.Num(30)));
        System.out.println("ageOf(json)                : " + PrimitivePatterns.ageOf(person));

        section("JEP 533 - Structured Concurrency (Seventh Preview)");
        System.out.println("order                      : " + StructuredConcurrency.load("diego", "book"));
        System.out.println("fastest of 3 subtasks      : " + StructuredConcurrency.fastest(
                java.time.Duration.ofSeconds(5), "cache", "replica", "origin"));

        section("JEP 527 - Post-Quantum Hybrid Key Exchange for TLS 1.3");
        System.out.println("default named groups       : " + HybridKeyExchange.defaultNamedGroups());
        System.out.println("quantum resistant default  : " + HybridKeyExchange.quantumResistantByDefault());
        System.out.println("hybrid on by default       : " + HybridKeyExchange.hybridGroupsEnabledByDefault());
        System.out.println("hybrid available opt-in    : " + HybridKeyExchange.optInHybridSchemes());
        System.out.println("ML-KEM-768 available       : " + HybridKeyExchange.supportsMlKem("ML-KEM-768"));

        section("JEP 534 - Compact Object Headers by Default");
        System.out.println("compact headers enabled    : " + CompactObjectHeaders.enabled());
        System.out.println("object header bits         : " + CompactObjectHeaders.headerBits());
        System.out.println("bytes saved per object     : " + CompactObjectHeaders.headerBytesSavedPerObject());
    }

    private static void section(String title) {
        System.out.println();
        System.out.println(title);
        System.out.println("-".repeat(title.length()));
    }
}
