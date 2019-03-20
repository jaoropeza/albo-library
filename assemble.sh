#!/usr/bin/env bash

echo "Building war..."

./mvnw -Pprod clean package

echo "Build complete"
