#!/bin/bash
./gradlew clean test 2>&1 | grep -E "(=== |  PASSED|  Created|  Fed|  Search|  Launched|  All |  Deleted|  Double|  Index exists|  Exists|  Found|  Results|BUILD|tests)"
