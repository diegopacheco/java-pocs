package com.github.diegopacheco.app;

import com.sun.tools.attach.VirtualMachine;
import java.io.File;
import java.util.Optional;

public class AgentLoader {

    public static void run(String[] args) throws Exception{
        String agentFilePath = "/home/diego/git/diegopacheco/java-pocs/pocs/agent-fun";
        agentFilePath += "/agent/target/agent-1.0-SNAPSHOT-jar-with-dependencies.jar";
        String applicationName = "com.github.diegopacheco.app.Main";

        //iterate all jvms and get the first one that matches our application name
        Optional<String> jvmProcessOpt = Optional.ofNullable(VirtualMachine.list()
                .stream()
                .filter(jvm -> {
                    System.out.println("jvm: " + jvm.displayName());
                    return jvm.displayName().contains(applicationName);
                })
                .findFirst().get().id());

        if(!jvmProcessOpt.isPresent()) {
            System.out.println("Target Application not found");
            return;
        }
        File agentFile = new File(agentFilePath);
        try {
            String jvmPid = jvmProcessOpt.get();
            System.out.println("Attaching to target JVM with PID: " + jvmPid);
            VirtualMachine jvm = VirtualMachine.attach(jvmPid);
            jvm.loadAgent(agentFile.getAbsolutePath());
            jvm.detach();
            System.out.println("Attached to target JVM and loaded Java agent successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
