package com.github.diegopacheco.pocs.seda.pipeline;

public enum Pools {

    SANITIZER_POOL(1),
    CAT_POOL(2),
    CONOSLE_POOL(3);

    private final Integer code;
    Pools(Integer code){
        this.code = code;
    }

    public static Pools fromCode(Integer code){
        switch (code){
            case 1 -> {
                return SANITIZER_POOL;
            }
            case 2 -> {
                return CAT_POOL;
            }
            case 3 -> {
                return CONOSLE_POOL;
            }
        }
        throw new IllegalStateException("Cannot construct pool from code " + code);
    }

}
