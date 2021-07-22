#!/bin/bash

aws cloudwatch list-metrics --endpoint "http://127.0.0.1:4566" --namespace "APP/METRICS/"
