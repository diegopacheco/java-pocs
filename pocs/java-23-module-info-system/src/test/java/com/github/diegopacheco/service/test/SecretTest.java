package com.github.diegopacheco.service.test;

//
// // Package 'com.github.diegopacheco.hidden' is declared in module
// // 'com.github.diegopacheco.service', which does not export it to module
// // 'com.github.diegopacheco.service.test'
//
// // Do not work
// import com.github.diegopacheco.hidden.NoOneSeemsMe;
//
import org.junit.jupiter.api.Test;

public class SecretTest {

    @Test
    public void testSecret() {
        // Do not work
        //
        // This will not compile because the package is not exported
        //
        // new NoOneSeemsMe().showSecret();
    }

}
