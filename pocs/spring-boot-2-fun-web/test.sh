#!/bin/bash

curl -X POST localhost:8181/netflix-protected/actuator/refresh
curl http://localhost:8181/netflix-protected/hello
