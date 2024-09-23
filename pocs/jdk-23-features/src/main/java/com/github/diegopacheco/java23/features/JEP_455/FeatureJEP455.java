package com.github.diegopacheco.java23.features.JEP_455;

/**
 * JEP 455: Primitive Types in Patterns, instanceof, and switch (Preview)
 * https://openjdk.org/jeps/455
 *
 */
public class FeatureJEP455 {

    static class Situation {
        private int status;
        public Situation(int status) {
            this.status = status;
        }
        public int getStatus() {
            return status;
        }
        public void setStatus(int status) { this.status = status;}
    }

    public static void main(String[] args) {
        Situation x = new Situation(0);
        var res = switch (x.getStatus()) {
            case 0 -> "okay";
            case 1 -> "warning";
            case 2 -> "error";
            case int i -> "unknown status: " + i;
        };
        System.out.println(res);

        x.setStatus(200);
        var res1 = switch (x.getStatus()) {
            case 0 -> "Nothing";
            case 1 -> "Little";
            case 2 -> "Will give you a discount";
            case int i when i >= 100 -> "wow! you are a VIP";
            default -> throw new IllegalStateException("Unexpected value: " + x.getStatus());
        };
        System.out.println(res1);
    }
}
