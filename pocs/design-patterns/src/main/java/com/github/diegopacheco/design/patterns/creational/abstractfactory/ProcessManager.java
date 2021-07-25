package com.github.diegopacheco.design.patterns.creational.abstractfactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessManager {

    private IpConfigFactory factory;

    public ProcessManager(IpConfigFactory factory){
        this.factory=factory;
    }

    public String getIp(){
        try{
            ProcessBuilder processBuilder = new ProcessBuilder();
            String[] command = factory.getIPCommand();
            processBuilder.command(command);
            Process process = processBuilder.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
            process.waitFor();
            in.close();
            System.exit(0);

            return sb.toString();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
