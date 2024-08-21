#!/bin/bash

kind create cluster --config specs/kind-config.yaml

kubectl cluster-info --context kind-kind