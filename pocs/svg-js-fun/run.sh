#!/bin/bash

PORT=8081

echo "Starting server on http://localhost:${PORT}"
python3 -m http.server ${PORT}
