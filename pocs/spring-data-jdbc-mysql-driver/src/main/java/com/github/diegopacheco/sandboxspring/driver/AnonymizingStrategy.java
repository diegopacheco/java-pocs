package com.github.diegopacheco.sandboxspring.driver;

public enum AnonymizingStrategy {

    STAR(new StarApplication()),
    EMPTY(new EmptyApplication()),
    LAST4(new Last4Application());

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
            return value.repeat(value.length());
        }
    }

    private static class Last4Application implements AnonymizingApplication {
        @Override
        public String execute(String value) {
            if (null==value || value.length() <= 4) {
                return "";
            }
            return value.substring(value.length() - 4);
        }
    }

    private static class EmptyApplication implements AnonymizingApplication {
        @Override
        public String execute(String value) {
            return "";
        }
    }
}