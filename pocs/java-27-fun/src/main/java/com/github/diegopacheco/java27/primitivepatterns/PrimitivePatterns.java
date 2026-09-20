package com.github.diegopacheco.java27.primitivepatterns;

import java.util.Map;

public final class PrimitivePatterns {

    public sealed interface Json {
        record Str(String value) implements Json {}
        record Num(double value) implements Json {}
        record Obj(Map<String, Json> fields) implements Json {}
    }

    public static String status(int code) {
        return switch (code) {
            case 0 -> "okay";
            case 1 -> "warning";
            case 2 -> "error";
            case int c when c < 0 -> "invalid status: " + c;
            case int c -> "unknown status: " + c;
        };
    }

    public static String narrowest(double value) {
        if (value instanceof byte b) return "byte " + b;
        if (value instanceof int i) return "int " + i;
        if (value instanceof float f) return "float " + f;
        return "double " + value;
    }

    public static int ageOf(Json json) {
        if (json instanceof Json.Obj(var fields)
                && fields.get("age") instanceof Json.Num(int age)) {
            return age;
        }
        return -1;
    }

    public static String label(Object value) {
        return switch (value) {
            case Integer i when i > 100 -> "big int " + i;
            case Integer i -> "int " + i;
            case Character c -> "char " + c;
            case String s -> "text " + s;
            case null -> "nothing";
            default -> "other";
        };
    }
}
