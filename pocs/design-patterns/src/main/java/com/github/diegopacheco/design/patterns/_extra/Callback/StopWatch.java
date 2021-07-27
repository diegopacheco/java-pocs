package com.github.diegopacheco.design.patterns._extra.Callback;

public class StopWatch {

    private long init;
    private long end;
    private Callback callback;

    private StopWatch(){ }

    public static StopWatch withCallback(Callback cb){
        StopWatch sw = new StopWatch();
        sw.callback=cb;
        return sw;
    }

    public StopWatch start(){
        this.init = System.currentTimeMillis();
        return this;
    }

    public StopWatch stop(){
        this.end = System.currentTimeMillis();
        if (null!=callback)
            callback.run(end-init);
        return this;
    }

}
