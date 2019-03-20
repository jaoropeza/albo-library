#!/usr/bin/env bash

echo "Starting Application AlboLibraryApp"
echo "java -jar target/albo-library-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod"

java -jar target/albo-library-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
