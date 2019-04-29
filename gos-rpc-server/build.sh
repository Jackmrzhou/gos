#!/bin/bash

mvn package -DskipTests

docker build --rm -t gos-rpc-server .