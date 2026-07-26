package com.diegopacheco.floci.api;

import java.util.List;

public final class ApiModels {
    private ApiModels() {
    }

    public record WriteRequest(String value) {
    }

    public record WriteResponse(String service, String id, String value) {
    }

    public record ReadResponse(String service, List<String> values) {
    }

    public record ErrorResponse(String error) {
    }
}
