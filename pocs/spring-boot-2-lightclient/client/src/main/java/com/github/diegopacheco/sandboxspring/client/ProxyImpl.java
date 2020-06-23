package com.github.diegopacheco.sandboxspring.client;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ProxyImpl implements Contract{

    private static final String baseUrl = "http://localhost:8080";
    private static JSONParser parser = new JSONParser();

    @Override
    public Double sum(Double va, Double vb) {
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("va",va);
            jsonObject.put("vb",vb);
            String boddy = jsonObject.toJSONString();
            String result = HttpUtils.callPOST(baseUrl+"/sum/",boddy);

            JSONObject obj = (JSONObject)parser.parse(result);
            String value = obj.get("result").toString();
            Double dblResult = Double.parseDouble(value);
            return dblResult;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Double mul(Double va, Double vb) {
        String result = HttpUtils.callGET(baseUrl+"/mul/" + va + "/" + vb);
        Double dblResult = Double.parseDouble(result);
        return dblResult;
    }

    @Override
    public Double sub(Double va, Double vb) {
        String boddy = va + "," + vb;
        String result = HttpUtils.callPOST(baseUrl+"/sub/",boddy);
        return Double.parseDouble(result);
    }

    @Override
    public Double div(Double va, Double vb) {
        throw new UnsupportedOperationException("Div not supported yet.");
    }

}
