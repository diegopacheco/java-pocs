/**
 * JEP 504: Remove the Applet API
 * Removes java.applet package, javax.swing.JApplet, and related methods due to browser deprecation.
 * @see <a href="https://openjdk.org/jeps/504">JEP 504</a>
 */
public class AppletApiRemovalFeature {
    public static void run() {
        System.out.println("Applet API Removal (JEP 504):");
        System.out.println("  Removed: java.applet package");
        System.out.println("  Removed: javax.swing.JApplet");
        System.out.println("  Removed: java.beans.AppletInitializer");
        System.out.println("  Reason: Browser plugin support ended, security concerns");

        try {
            Class.forName("java.applet.Applet");
            System.out.println("  Status: java.applet.Applet still exists (unexpected)");
        } catch (ClassNotFoundException e) {
            System.out.println("  Status: java.applet.Applet successfully removed");
        }
    }
}
