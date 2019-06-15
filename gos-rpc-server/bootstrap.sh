#!/usr/bin/env bash

docker stop docker-gos-rpc-server
docker rm -f docker-gos-rpc-server

docker run --name docker-gos-rpc-server \
        -e DUBBO_IP_TO_REGISTRY=10.214.213.43 \
        -e DUBBO_PORT_TO_REGISTRY=20880 \
         -d -p 9966:9966 -p 20880:20880 gos-rpc-server