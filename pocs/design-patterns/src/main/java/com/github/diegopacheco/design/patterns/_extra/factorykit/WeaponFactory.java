package com.github.diegopacheco.design.patterns._extra.factorykit;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface WeaponFactory {
    Weapon create(WeaponType name);

    static WeaponFactory factory(Consumer<Builder> consumer) {
        java.util.Map<WeaponType,Supplier<Weapon>> map = new HashMap<>();
        consumer.accept(map::put);
        return name -> map.get(name).get();
    }
}