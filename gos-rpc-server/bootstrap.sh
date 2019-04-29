#!/usr/bin/env bash

docker stop docker-gos-rpc-server
docker rm -f docker-gos-rpc-server

docker run --name docker-gos-rpc-server -d -p 9966:9966 gos-rpc-server