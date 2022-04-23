package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.dao.CapitalsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CapitalsService {

    @Autowired
    CapitalsDao dao;

    @Cacheable(value = "capitals_cache")
    public String getCapital(String state){
        return dao.getCapital(state);
    }

}
