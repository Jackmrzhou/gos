#!/usr/bin/env bash

if [ -z "$1" ]; then
    echo "No storage path given!"
    exit
fi

mkdir -p $1

docker stop docker-gos-dataserver
docker rm -f docker-gos-dataserver

docker run --name docker-gos-dataserver -d -p 9001:9001 -v $1:/gos/data gos-dataserver
