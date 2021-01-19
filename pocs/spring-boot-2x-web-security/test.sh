#!/bin/bash

echo "will not work: "
curl -v http://localhost:8080/ 

echo "shall work:"
curl -i --user root:root http://localhost:8080/
