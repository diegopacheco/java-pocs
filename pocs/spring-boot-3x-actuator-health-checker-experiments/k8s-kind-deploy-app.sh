#!/bin/bash

kind load docker-image app:latest
kubectl apply -f specs/deployment.yaml
kubectl apply -f specs/service.yaml