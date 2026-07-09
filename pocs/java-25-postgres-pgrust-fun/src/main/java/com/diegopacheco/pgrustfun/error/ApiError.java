package com.diegopacheco.pgrustfun.error;

public record ApiError(int status, String error, String message) {
}

