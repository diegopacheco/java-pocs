package com.github.diegopacheco.pocs.seda.seda;

public enum Queues {

    SANITIZER_QUEUE(1),
    CAT_QUEUE(2),
    CONSOLE_QUEUE(3),
    END(100);

    private final Integer code;
    Queues(Integer code){
        this.code = code;
    }

    public static Queues fromCode(Integer code){
        switch (code){
            case 1 -> {
                return SANITIZER_QUEUE;
            }
            case 2 -> {
                return CAT_QUEUE;
            }
            case 3 -> {
                return CONSOLE_QUEUE;
            }
            case 100 -> {
                return END;
            }
        }
        throw new IllegalStateException("Cannot construct queue from code " + code);
    }

}
