#!/bin/bash
SPRING_PROFILES_ACTIVE=$1
export ECS_INSTANCE_IP_ADDRESS=$(/usr/bin/python /getContainerIp.py)
java -jar sample-service.jar --APPLICATION_SPRING_PROFILE=${SPRING_PROFILES_ACTIVE}
