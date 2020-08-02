local env               = "${ENV}";
local aws_profile       = "${AWS_PROFILE}";
local component_name    = "${COMPONENT_NAME}";
local region            = "${REGION}";
local image             = "${IMAGE}";
local product_market    = "${PRODUCT_MARKET}";
local replicas          = ${REPLICA};
local team_name         = "${TEAM_NAME}";
local namespace         = component_name + "-" + product_market + "-"+ env + "-" + region;

{
    "apiVersion": "apps/v1",
    "kind": "Deployment",
    "metadata": {
        "name":component_name
    },
    "spec" : {
        "replicas": replicas,
        "minReadySeconds": 10,
        "strategy": {
            "type":"RollingUpdate",
            "rollingUpdate": {
                "maxUnavailable": 1,
                "maxSurge":1
            }
        },
        "selector": {
            "matchLabels" : {
                "app":component_name,
                "region_short":region
            }
        },
        "template": {
            "metadata" : {
                "namespace":namespace,
                "labels": {
                    "app":component_name,
                    "region_short":region,
                }
            },
            "spec": {
                "containers": [
                    {
                        "name": component_name,
                        "image": image,
                        "ports": [ {"containerPort": 80 } ],
                        "env": [
                            {
                                "name": "DB_HOST",
                                "value":"${DB_HOST}"
                            },
                            {
                                "name": "DB_PASSWORD",
                                "value":"${DB_PASSWORD}"
                            }
                        ]
                    }
                ]
            }
        }
    }
}
