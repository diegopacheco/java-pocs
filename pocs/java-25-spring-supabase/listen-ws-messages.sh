#!/bin/bash

websocat "ws://localhost:4000/socket/websocket?apikey=$(cat ./anon.key)&vsn=1.0.0"
