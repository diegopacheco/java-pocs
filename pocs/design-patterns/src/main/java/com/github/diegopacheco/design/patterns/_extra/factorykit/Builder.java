package com.github.diegopacheco.design.patterns._extra.factorykit;

import java.util.function.Supplier;

public interface Builder {
    void add(WeaponType name, Supplier<Weapon> supplier);
}