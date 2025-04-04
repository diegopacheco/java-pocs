package com.github.diegopacheco.proper.oop.media.two;

import java.util.Map;

/**
 * Here I changed the design a little bit.
 * Now there is no parameters it's more like a callback.
 * This solution is composable as the last one but is a little different.
 *
 */
public interface Media {
    Map<String,String> build();
}
