package com.github.diegopacheco.sandboxspring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.diegopacheco.sandboxspring.model.Purchase;
import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;
import io.confluent.ksql.api.client.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KsqlDbQueryService {
    private Client ksqlClient;
    private final ObjectMapper objectMapper;

    @Value("${ksqldb.server.host:localhost}")
    private String ksqlDbHost;

    @Value("${ksqldb.server.port:8088}")
    private int ksqlDbPort;

    public KsqlDbQueryService() {
        this.objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void init() {
        ClientOptions options = ClientOptions.create()
                .setHost(ksqlDbHost)
                .setPort(ksqlDbPort);
        this.ksqlClient = Client.create(options);
    }

    @PreDestroy
    public void cleanup() {
        if (ksqlClient != null) {
            ksqlClient.close();
        }
    }

    public BigDecimal getTotalDebt(String userId) {
        try {
            String query = "SELECT TOTALDEBT FROM USER_TOTAL_DEBT WHERE USERID = '" + userId + "';";
            List<Row> rows = ksqlClient.executeQuery(query).get();
            if (!rows.isEmpty()) {
                Row row = rows.get(0);
                BigDecimal total = row.getDecimal("TOTALDEBT");
                return total != null ? total : BigDecimal.ZERO;
            }
            return BigDecimal.ZERO;
        } catch (Exception e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

    public List<Purchase> getPurchaseHistory(String userId) {
        try {
            String query = "SELECT PURCHASES FROM USER_PURCHASE_HISTORY WHERE USERID = '" + userId + "';";
            List<Row> rows = ksqlClient.executeQuery(query).get();
            if (!rows.isEmpty()) {
                Row row = rows.get(0);
                Object purchasesObj = row.getValue("PURCHASES");
                if (purchasesObj instanceof JsonArray) {
                    JsonArray purchasesArray = (JsonArray) purchasesObj;
                    List<Purchase> purchases = new ArrayList<>();
                    int startIndex = Math.max(0, purchasesArray.size() - 20);
                    for (int i = startIndex; i < purchasesArray.size(); i++) {
                        JsonObject purchaseObj = purchasesArray.getJsonObject(i);
                        Purchase purchase = new Purchase();
                        purchase.setPurchaseId(purchaseObj.getString("PURCHASEID"));
                        purchase.setUserId(userId);
                        purchase.setProductName(purchaseObj.getString("PRODUCTNAME"));
                        purchase.setProductType(purchaseObj.getString("PRODUCTTYPE"));
                        purchase.setValue(new BigDecimal(purchaseObj.getValue("VALUE").toString()));
                        purchase.setQuantity(purchaseObj.getInteger("QUANTITY"));
                        purchase.setTotal(new BigDecimal(purchaseObj.getValue("TOTAL").toString()));
                        purchases.add(purchase);
                    }
                    return purchases;
                }
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
