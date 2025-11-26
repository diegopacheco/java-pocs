package com.github.diegopacheco.sandboxspring.agent;

import java.lang.instrument.Instrumentation;

public class SubjectCompatAgent {
    public static void premain(String args, Instrumentation inst) throws Exception {
        install(inst);
    }

    public static void agentmain(String args, Instrumentation inst) throws Exception {
        install(inst);
    }

    private static void install(Instrumentation inst) throws Exception {
        SubjectClassTransformer transformer = new SubjectClassTransformer();
        inst.addTransformer(transformer, true);
        inst.retransformClasses(javax.security.auth.Subject.class);
    }
}
