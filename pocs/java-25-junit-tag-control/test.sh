#!/bin/bash
set -e

./mvnw clean test -Dtest=NonBadTestSuite
