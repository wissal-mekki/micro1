#!/bin/bash
docker kill micro1-app-jenk  > /dev/null 2>&1
docker rm micro1-app-jenk  > /dev/null 2>&1
docker-compose up -d
