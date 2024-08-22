#!/bin/bash

kind load docker-image app:latest
kubectl apply -f specs/deployment.yaml --force
kubectl apply -f specs/service.yaml --force