package com.github.diegopacheco.javapocs.driver.v1.impl;

import com.github.diegopacheco.javapocs.driver.v1.contract.Fact;
import com.github.diegopacheco.javapocs.driver.v1.contract.FactsContract;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FactsImpl implements FactsContract {

    private final OkHttpClient restClient = new OkHttpClient();
    private final Gson gson = new Gson();

    @Override
    public List<Fact> getFacts() {
        Fact[] facts = Arrays.asList(getFact(), getFact(), getFact()).toArray(new Fact[3]);
        return Collections.unmodifiableList(Arrays.asList(facts));
    }

    private Fact getFact(){
        try{
            String nonProdURL = "https://catfact.ninja/fact";
            Request request = new Request.Builder()
                    .url(nonProdURL)
                    .build();

            try (Response response = restClient.newCall(request).execute()) {
                assert response.body() != null;
                String json = response.body().string();
                return gson.fromJson(json, Fact.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
