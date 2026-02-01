#!/bin/bash
cd frontend
bun install
bun run build
cd ..
./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="--enable-preview" &
echo $! > .backend.pid
echo "Backend started on http://localhost:8080"
