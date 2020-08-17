package com.github.diegopacheco.javapocs.karate.tests;

import com.intuit.karate.junit5.Karate;

class SampleTest {

    @Karate.Test
    Karate testSample() {
        return Karate.run().relativeTo(getClass());
    }

}