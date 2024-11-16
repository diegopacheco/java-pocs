### Bazel + Java 21

Intelij bazel plugin
https://plugins.jetbrains.com/plugin/8609-bazel-for-intellij <br/>
The plugin is a bit cranky, you might got it working on the console but not on intelij. <br/>
IF you change WORKSPACE file, you need to restart intelij. <br/>


.bazelrc
```
build --java_runtime_version=remotejdk_8
```

## Build

```bash
./build.sh
```
```
INFO: Analyzed target //:ProjectRunner (95 packages loaded, 1623 targets configured).
INFO: From Building ProjectRunner.jar (1 source file):
warning: [options] source value 8 is obsolete and will be removed in a future release
warning: [options] target value 8 is obsolete and will be removed in a future release
warning: [options] To suppress warnings about obsolete options, use -Xlint:-options.
INFO: Found 1 target...
Target //:ProjectRunner up-to-date:
  bazel-bin/ProjectRunner
  bazel-bin/ProjectRunner.jar
INFO: Elapsed time: 8.186s, Critical Path: 3.16s
INFO: 3 processes: 2 internal, 1 worker.
INFO: Build completed successfully, 3 total actions
```

## Run

```bash
./run.sh
```
```
INFO: Analyzed target //:ProjectRunner (0 packages loaded, 0 targets configured).
INFO: Found 1 target...
Target //:ProjectRunner up-to-date:
  bazel-bin/ProjectRunner
  bazel-bin/ProjectRunner.jar
INFO: Elapsed time: 0.118s, Critical Path: 0.00s
INFO: 1 process: 1 internal.
INFO: Build completed successfully, 1 total action
INFO: Running command line: bazel-bin/ProjectRunner
Hello Bazel! Java 21!
```