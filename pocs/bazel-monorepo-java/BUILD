load("@rules_java//java:defs.bzl", "java_binary", "java_library", "java_test")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "projecta-java-maven-lib",
    srcs = glob(["project-a/src/main/java/com/github/diegopacheco/projecta/*.java"]),
    deps = ["@maven//:com_google_guava_guava"],
)

java_library(
    name = "projectb-java-maven-lib",
    srcs = glob(["project-b/src/main/java/com/github/diegopacheco/projectb/*.java"]),
 )

java_library(
    name = "projectc-java-maven-lib",
    srcs = glob(["project-c/src/main/java/com/github/diegopacheco/projectc/*.java"]),
    deps = [":projecta-java-maven-lib",":projectb-java-maven-lib"],
)

java_binary(
    name = "projectc",
    main_class = "com.github.diegopacheco.projectc.App",
    runtime_deps = [":projecta-java-maven-lib",":projectb-java-maven-lib",":projectc-java-maven-lib"],
)

java_test(
    name = "tests",
    srcs = glob(["project-c/src/test/java/com/github/diegopacheco/projectc/*.java"]),
    test_class = "com.github.diegopacheco.projectc.TestApp",
    deps = [
        ":projecta-java-maven-lib",
        ":projectb-java-maven-lib",
        ":projectc-java-maven-lib",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
    ],
)
