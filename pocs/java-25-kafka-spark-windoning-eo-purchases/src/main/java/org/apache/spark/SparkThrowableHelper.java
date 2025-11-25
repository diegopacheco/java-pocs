package org.apache.spark;

import scala.Enumeration;
import scala.collection.immutable.Map;
import scala.collection.immutable.Nil$;
import scala.collection.immutable.Seq;

public final class SparkThrowableHelper {
    public static String getMessage(Throwable t, Enumeration.Value format) {
        return SparkThrowableHelper$.MODULE$.getMessage(t, format);
    }

    public static boolean isInternalError(String errorClass) {
        return SparkThrowableHelper$.MODULE$.isInternalError(errorClass);
    }

    public static Seq<String> getMessageParameters(String errorClass) {
        return SparkThrowableHelper$.MODULE$.getMessageParameters(errorClass);
    }

    public static boolean isValidErrorClass(String errorClass) {
        return SparkThrowableHelper$.MODULE$.isValidErrorClass(errorClass);
    }

    public static String getSqlState(String errorClass) {
        return SparkThrowableHelper$.MODULE$.getSqlState(errorClass);
    }

    public static String getMessage(String errorClass, Map<String, String> params, String format) {
        return SparkThrowableHelper$.MODULE$.getMessage(errorClass, params, format);
    }

    public static String getMessage(String errorClass, java.util.Map<String, String> params) {
        return SparkThrowableHelper$.MODULE$.getMessage(errorClass, params);
    }

    public static String getMessage(String errorClass, Map<String, String> params) {
        return SparkThrowableHelper$.MODULE$.getMessage(errorClass, params);
    }

    public static ErrorClassesJsonReader errorReader() {
        return SparkThrowableHelper$.MODULE$.errorReader();
    }
}
