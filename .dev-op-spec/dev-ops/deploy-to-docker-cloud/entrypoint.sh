#!/bin/sh
SERVICE_VERSION=$(cat target/VERSION)

updateDockerCloudService () {

docker-cloud service set --sync --image ${DOCKER_REPOSITORY_NAME}:${SERVICE_VERSION} short-url-svc.${DOCKERCLOUD_STACK_NAME}

}

redeployDockerCloudService () {

docker-cloud service redeploy --sync short-url-svc.${DOCKERCLOUD_STACK_NAME}

}

updateDockerCloudService && redeployDockerCloudService
