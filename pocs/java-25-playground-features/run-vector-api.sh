#!/bin/bash
cd "$(dirname "$0")"
java --enable-preview --add-modules jdk.incubator.vector -cp target/classes com.github.diegopacheco.java25.features.VectorAPI

