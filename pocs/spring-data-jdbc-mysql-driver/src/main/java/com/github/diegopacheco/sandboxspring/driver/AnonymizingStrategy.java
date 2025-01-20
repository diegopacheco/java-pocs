package com.github.diegopacheco.sandboxspring.driver;

public enum AnonymizingStrategy {

    STAR(new StarApplication()),
    EMPTY(new EmptyApplication()),
    NULL(new NullApplication()),
    LAST4(new Last4Application()),
    RAMDOM_NUMBER(new RamdomNumberApplication());

    private final AnonymizingApplication application;

    AnonymizingStrategy(AnonymizingApplication application) {
        this.application = application;
    }
    public AnonymizingApplication getApplication() {
        return application;
    }

    private static class StarApplication implements AnonymizingApplication {
        @Override
        public String execute(String value) {
            return "*".repeat(value.length());
        }
    }

    private static class Last4Application implements AnonymizingApplication {
        @Override
        public String execute(String value) {
            if (null==value || value.length() <= 4) {
                return "";
            }
            int len = value.length() - 4;
            return "*".repeat(len) + value.substring(value.length() - 4);
        }
    }

    private static class EmptyApplication implements AnonymizingApplication {
        @Override
        public String execute(String value) {
            return "";
        }
    }

    private static class NullApplication implements AnonymizingApplication {
        @Override
        public String execute(String value) {
            return null;
        }
    }

    private static class RamdomNumberApplication implements AnonymizingApplication {
        public String execute(String value) {
            if (null==value) {
                return "";
            }
            StringBuilder result = new StringBuilder();
            for(int i=0;i<value.length();i++){
                result.append((int) (Math.random() * 10));
            }
            return result.toString();
        }
    }
}