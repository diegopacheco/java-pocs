package com.github.diegopacheco.javapocs.driver.v1.contract;

import java.util.List;

/**
 * Contract (try not to break it as much as possible - if break it create a new Version)
 */
public interface FactsContract {
    List<Fact> getFacts();
}
