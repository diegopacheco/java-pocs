package com.github.diegopacheco.javapocs.proxy;

import org.apache.log4j.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {

    private static Logger LOGGER = Logger.getLogger(DynamicInvocationHandler.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
        LOGGER.info("Hijacked - Invoked method: " + method.getName());
        return 42;
    }

}
