#!/bin/bash

set -x

WORKSPACE="${COMPONENT_NAME}-${PRODUCT_MARKET}-${ENV}-${REGION}"

${TF_EXE} init -upgrade
${TF_EXE} workspace select $WORKSPACE || ${TF_EXE} workspace new $WORKSPACE

${TF_EXE} plan -var-file="./tfvars/${PRODUCT_MARKET}-${ENV}-${REGION}.tfvars" \
    -var "environment=${ENV}" -var "prod_market=${PRODUCT_MARKET}"

${TF_EXE} apply -auto-approve -var-file="./tfvars/${PRODUCT_MARKET}-${ENV}-${REGION}.tfvars" \
    -var "environment=${ENV}" -var "prod_market=${PRODUCT_MARKET}"