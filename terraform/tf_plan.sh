#!/bin/bash

set -x

WORKSPACE="${COMPONENT_NAME}-${PRODUCT_MARKET}-${ENV}-${REGION}"

${TF_EXE} init -upgrade
${TF_EXE} workspace select $WORKSPACE || ${TF_EXE} workspace new $WORKSPACE

${TF_EXE} plan -var-file="./tfvars/${PRODUCT_MARKET}-${ENV}-${REGION}.tfvars" \
                        -var "product_market=${PRODUCT_MARKET}" \
                        -var "environment=${ENV}" \
                        -var "component_name=${COMPONENT_NAME}"