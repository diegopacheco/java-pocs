package com.github.diegopacheco.design.patterns._extra.marker;

public class Main {
    public static void main(String[] args) {
        CodeV1 codeV1 = new CodeV1();
        CodeV2 codeV2 = new CodeV2();
        run(codeV1);
        run(codeV2);
    }

    private static void run(Code code){
        if (code instanceof Active){
            code.run();
        }else{
            System.out.println("Sorry: ["+code+"] cannot run since is not Active!");
        }
    }

}
