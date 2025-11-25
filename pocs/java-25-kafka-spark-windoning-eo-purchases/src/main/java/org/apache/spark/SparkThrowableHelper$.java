package org.apache.spark;

import scala.Enumeration;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Seq;
import scala.jdk.CollectionConverters$;

public final class SparkThrowableHelper$ {
    public static final SparkThrowableHelper$ MODULE$ = new SparkThrowableHelper$();
    private SparkThrowableHelper$() {}

    public ErrorClassesJsonReader errorReader() {
        return null;
    }

    public String getMessage(String errorClass, Map<String, String> params, String format) {
        return errorClass;
    }

    public String getMessage(String errorClass, java.util.Map<String, String> params) {
        return errorClass;
    }

    public String getMessage(String errorClass, Map<String, String> params) {
        return errorClass;
    }

    public String getMessage(Throwable t, Enumeration.Value format) {
        return t != null ? t.getMessage() : "";
    }

    public boolean isInternalError(String errorClass) {
        return false;
    }

    public Seq<String> getMessageParameters(String errorClass) {
        return (Seq<String>) (Seq<?>) scala.collection.immutable.List$.MODULE$.empty();
    }

    public boolean isValidErrorClass(String errorClass) {
        return true;
    }

    public String getSqlState(String errorClass) {
        return null;
    }
}
