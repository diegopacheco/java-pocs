package org.openapitools.client;

import org.openapitools.client.auth.*;
import org.openapitools.client.model.Pet;
import org.openapitools.client.api.PetApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        System.out.println(defaultClient);

        // Simple API Key Auth
        ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
        auth.setApiKey("123456");

        PetApi apiInstance = new PetApi(defaultClient);
        try {
            Pet result = apiInstance.getPetById(1L);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PetApi#addPet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}