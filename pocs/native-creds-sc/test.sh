#!/bin/bash

CT=$(curl -s "http://localhost:8080/enc/default/SpringRocks")
#CT=${CT::-1}
echo "Calling encryption. Result: $CT"

PT=$(curl -s "http://localhost:8080/dec/default/$CT")
echo "Calling decryption. Result: $PT"