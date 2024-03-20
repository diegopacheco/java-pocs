package com.github.diegopacheco.pocs.seda.seda;

public enum Queues {

    SANITIZER_QUEUE(1),
    CAT_QUEUE(2),
    CONOSLE_QUEUE(3);

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
                return CONOSLE_QUEUE;
            }
        }
        throw new IllegalStateException("Cannot construct queue from code " + code);
    }

}
