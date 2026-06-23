#!/bin/bash
BASE=http://localhost:8081/api/filmography
echo "== basic structured output =="
curl -s "$BASE/basic?actor=Tom%20Hanks"
echo
echo "== self-correcting validated structured output =="
curl -s "$BASE/validated?actor=Meryl%20Streep"
echo
echo "== provider-native structured output =="
curl -s "$BASE/provider?actor=Denzel%20Washington"
echo
