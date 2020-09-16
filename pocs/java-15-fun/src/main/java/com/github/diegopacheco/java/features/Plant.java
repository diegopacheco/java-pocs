package com.github.diegopacheco.java.features;

sealed public class Plant permits Herb, Shrub, Climber {}

final class Herb extends Plant {}
non-sealed class Shrub extends Plant {}
sealed class Climber extends Plant permits Cucumber{}
final class Cucumber extends Climber {}

// Evil is not allowed in the sealed hierarchy
//public class Evil extends Plant{}