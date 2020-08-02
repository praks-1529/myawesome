local env               = "${ENV}";
local aws_profile       = "${AWS_PROFILE}";
local component_name    = "${COMPONENT_NAME}";
local region            = "${REGION}";
local image             = "${IMAGE}";
local product_market    = "${PRODUCT_MARKET}";
local replicas          = ${REPLICA};
local team_name         = "${TEAM_NAME}";
local namespace         = component_name + "-" + product_market + "-"+ env + "-" + region;
local resource_tags     = "component=" + component_name + ",env=" + env + ",product_market=" + product_market + ",region=" + region + ",team_name=" + team_name;

{
  "kind": "Service",
  "apiVersion": "v1",
  "metadata": {
    "name": component_name,
    "namespace": namespace,
    "labels": {
      "app": component_name,
      "name": component_name
    },
    "annotations": {
        "external-dns.alpha.kubernetes.io/ttl": "60",
        "service.beta.kubernetes.io/aws-load-balancer-access-log-emit-interval": "5",
        "service.beta.kubernetes.io/aws-load-balancer-access-log-enabled": "true",
        "service.beta.kubernetes.io/aws-load-balancer-access-log-s3-bucket-name": "elb-logs-myawesome",
        "service.beta.kubernetes.io/aws-load-balancer-access-log-s3-bucket-prefix": namespace,
        "service.beta.kubernetes.io/aws-load-balancer-additional-resource-tags": resource_tags,
        "service.beta.kubernetes.io/aws-load-balancer-backend-protocol": "http",
        "service.beta.kubernetes.io/aws-load-balancer-connection-draining-enabled": "true",
        "service.beta.kubernetes.io/aws-load-balancer-connection-draining-timeout": "60",
        "service.beta.kubernetes.io/aws-load-balancer-extra-security-groups": "${EXT_SG_GROUPS}",
        "service.beta.kubernetes.io/aws-load-balancer-healthcheck-healthy-threshold": "9",
        "service.beta.kubernetes.io/aws-load-balancer-healthcheck-unhealthy-threshold": "2",
        "service.beta.kubernetes.io/aws-load-balancer-internal": "true"
    }
  },
  "spec": {
    "ports": [
        {
          "name": "http",
          "protocol": "TCP",
          "port": 80,
          "targetPort": 80
        }
    ],
    "selector": {
      "app":component_name,
      "region_short":region
    },
    "type": "LoadBalancer",
    "sessionAffinity": "None",
    "externalTrafficPolicy": "Cluster"
  }
}