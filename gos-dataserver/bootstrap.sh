#!/usr/bin/env bash

if [-z "$0"]; then
    echo "No storage path given!"
    exit
fi

mkdir -p $0

docker stop docker-gos-dataserver
docker rm -f docer-gos-dataserver

docker run --name docker-gos-dataserver -d -p 9001:9001 -v $0:/gos/data gos-dataserver