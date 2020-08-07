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
  "apiVersion": "v1",
  "kind": "Namespace",
  "metadata": {
    "name": namespace,
    "labels": {
        "env": env,
        "component_name": component_name,
        "region": region,
        "product_market": product_market,
        "name": namespace,
        "team": team_name
    }
  }
}