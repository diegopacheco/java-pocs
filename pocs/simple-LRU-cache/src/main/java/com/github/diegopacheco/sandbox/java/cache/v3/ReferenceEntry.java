package com.github.diegopacheco.sandbox.java.cache.v3;

/**
 *
 * ReferenceEntry Container type in order to keeo track beetween the Map and the DLL.
 *
 * @param <T> any type really.
 *
 * @author Diego Pacheco
 */
class ReferenceEntry<T> {
    String key;
    T value;
    ReferenceEntry left;
    ReferenceEntry right;
}