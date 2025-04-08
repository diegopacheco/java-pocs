import com.github.diegopacheco.liquidunit.execution.engine.LiquidUnitRollbackTests;
import com.github.diegopacheco.liquidunit.execution.engine.LiquidUnitTests;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import java.util.ArrayList;
import java.util.List;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class Main {
  public static void main(String args[]) throws Exception {
    displayLiquidUnitBanner();

    List<String> filteredArgs = new ArrayList<>();
    for (String arg : args) {
      if (!arg.equals("--enable-preview")) {
        filteredArgs.add(arg);
      }
    }

    if (!filteredArgs.isEmpty()) {
      String arg = filteredArgs.getFirst();

      if (arg.equals("--ro")) {
        runTests(LiquidUnitRollbackTests.class);
      } else if (arg.equals("--mt")) {
        runTests(LiquidUnitTests.class);
      } else if (arg.equals("--?") || arg.equals("--h")) {
        displayHelp();
      } else {
        System.err.println("Unknown argument: " + arg);
        displayHelp();
        System.exit(1);
      }
    } else {
      System.out.println("\n📌 Running migration tests...");
      runTests(LiquidUnitTests.class);

      System.out.println("\n📌 Running rollback tests...");
      runTests(LiquidUnitRollbackTests.class);
    }
  }

  private static void displayLiquidUnitBanner() {
    System.out.println("\n" +
            "  _     _             _     _ _   _       _ _   \n" +
            " | |   (_)           (_)   | | | | |     (_) |  \n" +
            " | |    _  __ _ _   _ _  __| | | | |_ __  _| |_ \n" +
            " | |   | |/ _` | | | | |/ _` | | | | '_ \\| | __|\n" +
            " | |___| | (_| | |_| | | (_| | |_| | | | | | |_ \n" +
            " |_____|_|\\__, |\\__,_|_|\\__,_|\\___/|_| |_|_|\\__|\n" +
            "             | |                                 \n" +
            "             |_|                                 \n");
  }

  private static void displayHelp() {
    System.out.println("\nLiquidUnit Usage:");
    System.out.println("  No args     - Run complete test suite: migrations, tests and rollbacks");
    System.out.println("  --mt        - Run only migration and tests");
    System.out.println("  --ro        - Run only rollback tests");
    System.out.println("  --? or --h  - Display this help message");
  }

  private static void runTests(Class<?> testClass) {
    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
            .selectors(selectClass(testClass))
            .build();
    Launcher launcher = LauncherFactory.create();
    SummaryGeneratingListener listener = new SummaryGeneratingListener();
    launcher.registerTestExecutionListeners(listener);

    launcher.execute(request);

    TestExecutionSummary summary = listener.getSummary();
    System.out.println("Tests run: " + summary.getTestsFoundCount());
    System.out.println("Tests succeeded: " + summary.getTestsSucceededCount());
    System.out.println("Tests failed: " + summary.getTestsFailedCount());

    if (summary.getTestsFailedCount() > 0) {
      System.out.println("\nTest failures:");
      summary.getFailures().forEach(failure ->
              System.out.println("- " + failure.getTestIdentifier().getDisplayName() + ": " + failure.getException()));
      System.exit(1);
    }

    System.out.println("✓ " + testClass.getSimpleName() + " completed successfully!");
  }
}