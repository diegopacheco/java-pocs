#!/usr/bin/bash

./mvnw gatling:test -Dgatling.simulation=NettyMonoSimulation -Djava.net.preferIPv4Stack=true