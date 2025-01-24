package com.github.diegopacheco.packagelevelfun.logger;

public class RuntimeInfo {

    private String packageName;
    private String className;
    private String methodName;

    public RuntimeInfo() {}

    public RuntimeInfo(String packageName, String className, String methodName) {
        this.packageName = packageName;
        this.className = className;
        this.methodName = methodName;
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

    @Override
    public String toString() {
        return "RuntimeInfo{" +
                "packageName='" + packageName + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
