#!/bin/bash

CT=$(curl -s "http://172.17.0.2:8080/enc/default/SpringRocks")
#CT=${CT::-1}
CT=$(echo $CT | sed 's/\//\\\//g') # Escape / character
echo "Calling encryption. Result: $CT"

PT=$(curl -s "http://172.17.0.2:8080/dec/default/$CT")
echo "Calling decryption. Result: $PT"