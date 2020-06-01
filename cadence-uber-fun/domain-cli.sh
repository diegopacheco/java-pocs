#!/bin/bash

docker run --network=host --rm ubercadence/cli:master --do test-domain domain register -rd 1
