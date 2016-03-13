#!/bin/sh
SERVICE_VERSION=$(cat target/VERSION)

updateDockerCloudService () {

tutum service set --sync --image ${DOCKER_REPOSITORY_NAME}:${SERVICE_VERSION} short-url-svc.${DOCKERCLOUD_STACK_NAME}

}

redeployDockerCloudService () {

tutum service redeploy --sync short-url-svc.${DOCKERCLOUD_STACK_NAME}

}

updateDockerCloudService && redeployDockerCloudService
