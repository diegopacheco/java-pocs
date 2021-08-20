package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.metrics.OperationMonitor;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/*
* Implementation for: https://grafana.com/grafana/plugins/grafana-simple-json-datasource/
* */
@RestController
public class MetricsController {

    @RequestMapping("/")
    public String index() {
        return "{}";
    }

    @RequestMapping(value="/search",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    public Map<String, Object>[] search(@RequestBody Map<Object,Object> parameters) {
        Map<String,Object>[] searchResult = new Map[2];

        Map<String,Object> searchEntry = new HashMap<>();
        searchEntry.put("text","success-getCurrentDate");
        searchEntry.put("value","1");
        searchResult[0] = searchEntry;

        searchEntry = new HashMap<>();
        searchEntry.put("text","error-getCurrentDate");
        searchEntry.put("value","1");
        searchResult[1] = searchEntry;

        return searchResult;
    }

    @RequestMapping(value="/query",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json")
    public Map<String,Object> query(@RequestBody Map<Object,Object> parameters) {

        String target = parameters.getOrDefault("target","").toString();

        Map<String,Object>[] columns = new Map[2];

        Map<String,Object> column = new HashMap<>();
        column.put("text","success-getCurrentDate");
        column.put("type","number");
        columns[0]=column;

        column = new HashMap<>();
        column.put("text","error-getCurrentDate");
        column.put("type","number");
        columns[1]=column;

        Object[] rows = {
            new Object[]{10,10},
            new Object[]{10,10},
        };

        Map<String,Object> queryResult = new HashMap<>();
        queryResult.put("columns",columns);
        queryResult.put("rows",rows);
        return queryResult;
    }

    @RequestMapping(value="/annotations",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json")
    public Map<String, Object>[] annotations(@RequestBody Map<Object,Object> parameters) {

        Map<String, Object>[] result = new Map[1];

        Map<String,Object> annotations = new HashMap<>();
        Map<String,Object> annotation = new HashMap<>();
        annotation.put("name","annotation name");
        annotation.put("enabled","true");
        annotation.put("datasource","generic datasource");
        annotation.put("showLine","true");
        annotations.put("success-getCurrentDate",1);
        annotations.put("error-getCurrentDate",1);
        annotations.put("annotation",annotation);
        result[0] = annotations;

        return result;
    }

    @RequestMapping(value="/tag-keys",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public Map<String, Object>[] tagKeys(@RequestBody Map<Object,Object> parameters) {
        Map<String,Object>[] tagKeys = new Map[2];

        Map<String,Object> tagKey = new HashMap<>();
        tagKey.put("type","number");
        tagKey.put("text","success-getCurrentDate");
        tagKeys[0]=tagKey;

        tagKey = new HashMap<>();
        tagKey.put("type","number");
        tagKey.put("text","error-getCurrentDate");
        tagKeys[1]=tagKey;

        return tagKeys;
    }

    @RequestMapping(value="/tag-values",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public Map<String, Object>[] tagValues(@RequestBody Map<Object,Object> parameters) {
        Map<String,Object>[] tagKeys = new Map[2];

        Map<String,Object> tagKey = new HashMap<>();
        tagKey.put("text","success-getCurrentDate");
        tagKeys[0]=tagKey;

        tagKey = new HashMap<>();
        tagKey.put("text","error-getCurrentDate");
        tagKeys[1]=tagKey;

        return tagKeys;
    }

    @RequestMapping("/metrics")
    public Map<String, Object> metrics() {
        return OperationMonitor.dump();
    }

}
