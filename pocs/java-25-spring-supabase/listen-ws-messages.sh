#!/bin/bash

# WebSocket listener for Supabase Realtime
echo "Connecting to Supabase Realtime WebSocket..."
echo "Testing multiple connection approaches..."
echo ""

# Try direct connection to realtime service with proper Phoenix WebSocket format
echo "=== Attempting direct connection to realtime service ==="
echo "URL: ws://localhost:4000/socket/websocket"
echo "With Phoenix WebSocket join message..."

# Create a proper Phoenix WebSocket connection
(
  echo '{"topic":"phoenix","event":"heartbeat","payload":{},"ref":1}'
  sleep 1
  echo '{"topic":"realtime:public:votes","event":"phx_join","payload":{},"ref":2}'
  sleep 30
) | websocat "ws://localhost:4000/socket/websocket?apikey=$(cat ./anon.key)&vsn=1.0.0"
