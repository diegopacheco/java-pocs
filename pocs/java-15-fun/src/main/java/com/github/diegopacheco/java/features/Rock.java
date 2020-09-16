package com.github.diegopacheco.java.features;

sealed public interface Rock permits RockRecord {}
non-sealed interface RockRecord extends Rock {}
record StAnger(int year) implements RockRecord {}

// Samba is not allowed in the sealed hierarchy
// interface Samba implements Rock {}

// works because RockRecord is non-sealed
interface SNM2 extends RockRecord {}

// SNM2 is not allowed in the sealed hierarch
// interface SNM2 extends Rock {}