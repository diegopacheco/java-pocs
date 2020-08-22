package com.github.diegopacheco.javapocs.mocks;

import java.util.HashMap;

public final class StupidMap extends HashMap {

    public final int anwserOfTheUniverse(){
        return 42;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

}
