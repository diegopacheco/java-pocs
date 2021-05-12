package com.github.diegopacheco.java.pocs.visibility.core.protection;

import com.github.diegopacheco.java.pocs.visibility.core.Readable;

public class ReaderProvider {

    public static Readable<String> get(){
        return CacheService.getInstance();
    }

}
