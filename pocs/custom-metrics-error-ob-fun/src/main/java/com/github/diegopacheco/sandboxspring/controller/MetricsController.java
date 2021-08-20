package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.metrics.OperationMonitor;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
* Implementation for: https://grafana.com/grafana/plugins/grafana-simple-json-datasource/
* */
@RestController
public class MetricsController {

    @RequestMapping("/")
    public String index() {
        return "{}";
    }

    /**
     * Get Grafana METRICS for auto-complete
     */
    @RequestMapping(value="/search",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    public Map<String, Object>[] search(@RequestBody Map<Object,Object> parameters) {
        Map<String,Object>[] searchResult = new Map[2];

        Map<String,Object> searchEntry = new HashMap<>();
        searchEntry.put("text","success-getCurrentDate");
        searchEntry.put("value","success-getCurrentDate");
        searchResult[0] = searchEntry;

        searchEntry = new HashMap<>();
        searchEntry.put("text","error-getCurrentDate");
        searchEntry.put("value","error-getCurrentDate");
        searchResult[1] = searchEntry;

        return searchResult;
    }

    /**
     * Get Grafana DATAPOINTS for plotting TABLE or TIMESERIES charts.
     */
    @RequestMapping(value="/query",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json")
    public Map<String,Object>[] query(@RequestBody Map<Object,Object> parameters) {
        String dataType = "table";
        String target = "";
        try{
            dataType = ((Map<String,String>)((List)parameters.get("targets")).get(0)).get("type");
            target   = ((Map<String,String>)((List)parameters.get("targets")).get(0)).get("target");
        }catch(Exception e){}
        System.out.println("Request for type   == " + dataType) ;
        System.out.println("Request for target == " + target) ;
        System.out.println("Parameters: " + parameters);

        if ("table".equals(dataType)){
            return getTableData();
        }else if ("timeserie".equals(dataType)){
            return getTimeserieData(target);
        } else{
            return getTableData();
        }
    }

    private Map<String,Object>[] getTimeserieData(String targetMetric){

        Object[] datapoints = new Object[1];

        Long datapoint = 0L;
        try{
            datapoint = (Long)OperationMonitor.dump().get(targetMetric);
            if (null==datapoint) datapoint=0L;
        }catch(Exception e){}

        datapoints[0] = new Long[]{
            datapoint, System.currentTimeMillis()
        };

        Map<String,Object>[] result = new Map[1];
        Map<String,Object> entry = new HashMap<>();
        entry.put("target",targetMetric);
        entry.put("datapoints",datapoints);
        result[0] = entry;

        return result;
    }

    private Map<String,Object>[] getTableData(){
        Map<String,Object>[] columns = new Map[2];
        Map<String,Object> column = new HashMap<>();
        column.put("text","success-getCurrentDate");
        column.put("type","number");
        columns[0]=column;

        column = new HashMap<>();
        column.put("text","error-getCurrentDate");
        column.put("type","number");
        columns[1]=column;

        Long datapointOK = 0L;
        try{
            datapointOK = Long.parseLong( ((AtomicInteger)OperationMonitor.dump().get("success-getCurrentDate")).get() + "");
            if (null==datapointOK) datapointOK=0L;
        }catch(Exception e){}

        Long datapointError = 0L;
        try{
            datapointError = Long.parseLong( ((AtomicInteger)OperationMonitor.dump().get("error-getCurrentDate")).get() + "");
            if (null==datapointError) datapointError=0L;
        }catch(Exception e){}

        Object[] rows = {
                new Object[]{datapointOK,datapointError},
        };

        Map<String,Object> queryResult = new HashMap<>();
        queryResult.put("columns",columns);
        queryResult.put("rows",rows);

        Map<String,Object>[] result = new Map[1];
        result[0]= queryResult;

        return result;
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


    @RequestMapping("/metrics")
    public Map<String, Object> metrics() {
        return OperationMonitor.dump();
    }

}
