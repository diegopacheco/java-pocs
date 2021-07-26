package com.github.diegopacheco.design.patterns.structural.proxy;

import java.util.UUID;

// Proxy: Transparently caches after 1 call
/**
 * It can be used in Virtual Proxy scenario---Consider a situation where there is multiple database call to extract huge size image. Since this is an expensive operation so here we can use the proxy pattern which would create multiple proxies and point to the huge size memory consuming object for further processing. The real object gets created only when a client first requests/accesses the object and after that we can just refer to the proxy to reuse the object. This avoids duplication of the object and hence saving memory.
 * It can be used in Protective Proxy scenario---It acts as an authorization layer to verify that whether the actual user has access the appropriate content or not. For example, a proxy server which provides restriction on internet access in office. Only the websites and contents which are valid will be allowed and the remaining ones will be blocked.
 * It can be used in Remote Proxy scenario---A remote proxy can be thought about the stub in the RPC call. The remote proxy provides a local representation of the object which is present in the different address location. Another example can be providing interface for remote resources such as web service or REST resources.
 * It can be used in Smart Proxy scenario---A smart proxy provides additional layer of security by interposing specific actions when the object is accessed. For example, to check whether the real object is locked or not before accessing it so that no other objects can change it.
 */
public class Proxy implements IDGenerator {

    private UUID cache;

    private IDGenerator target;

    public Proxy(IDGenerator target){
        this.target = target;
    }

    @Override
    public UUID getNext() {
        long init = System.currentTimeMillis();
        if (null==cache){
            cache = target.getNext();
        }
        long end = System.currentTimeMillis();
        System.out.println("Call took: ["+(end-init)+"] ms");
        return cache;
    }

}
