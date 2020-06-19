package com.github.diegopacheco.thrift.server;

import com.github.diegopacheco.thrift.impl.CrossPlatformResource;
import com.github.diegopacheco.thrift.impl.CrossPlatformService;
import com.github.diegopacheco.thrift.impl.InvalidOperationException;
import org.apache.thrift.TException;
import java.util.Collections;
import java.util.List;

public class CrossPlatformServiceImpl implements CrossPlatformService.Iface {

    @Override
    public CrossPlatformResource get(final int id) throws InvalidOperationException, TException {
        return new CrossPlatformResource();
    }

    @Override
    public void save(final CrossPlatformResource resource) throws InvalidOperationException, TException {}

    @Override
    public List<CrossPlatformResource> getList() throws InvalidOperationException, TException {
        return Collections.emptyList();
    }

    @Override
    public boolean ping() throws InvalidOperationException, TException {
        System.out.println("Server being pinged... ");
        return true;
    }

}