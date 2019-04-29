#!/usr/bin/env bash

mvn package -DskipTests
docker build --rm -t gos-dataserver .