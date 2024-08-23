#!/bin/bash

kind load docker-image app:latest
kubectl apply -f specs/deployment.yaml --force
kubectl apply -f specs/service.yaml --force

kubectl apply -f specs/grafana-deployment.yaml --force
kubectl apply -f specs/grafana-service.yaml --force

kubectl apply -f specs/prometheus-deployment.yaml --force
kubectl apply -f specs/prometheus-service.yaml --force
kubectl apply -f specs/prometheus-sb-configmap.yaml --force