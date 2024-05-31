#!/bin/bash

./mvnw verify
open target/site/jacoco/index.html