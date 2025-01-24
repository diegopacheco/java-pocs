package com.github.diegopacheco.packagelevelfun.logger;

public class RuntimeInfo {

    private String packageName;
    private String className;
    private String methodName;
    private Boolean isSecure = false;

    public RuntimeInfo() {}

    public RuntimeInfo(String packageName, String className, String methodName, Boolean isSecure) {
        this.packageName = packageName;
        this.className = className;
        this.methodName = methodName;
        this.isSecure = isSecure;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Boolean isSecure(){
        return isSecure;
    }

    @Override
    public String toString() {
        return "RuntimeInfo{" +
                "packageName='" + packageName + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", isSecure=" + isSecure +
                '}';
    }
}
