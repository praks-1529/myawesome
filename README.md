## What is this repository about ?
Having a solid and extensible CI-CD pipeline is one of the core engineering strengths of any organization. We want developers to spend as much little time as possible on deployment procedures. This repo is used to demo usage of GoCD to build a pipeline from scratch. <br/> <br/> The full blog can be found [here](https://medium.com/@prakashshanbhag/going-great-guns-with-gocd-6d270f2d185d)

# Project structure

<pre>
.
├── Dockerfile                       (File used do build the docker img of the service)
├── README.md
├── k8s                              (Holds all the k8s manifest file )
│   ├── deploy_kube                  (Pyhton helper utility )
│   ├── deployment-manifest.jsonnet  ( Manifest file for k8s deployment obj)
│   ├── namespace-manifest.jsonnet   ( Manifest file for k8s namespace obj )
│   └── service-manifest.jsonnet     (Manifest file for k8s service obj )
├── pom.xml ( Project pom file)
├── src 
│   ├── main
│   │   ├── java                      (Biz logic )
│   │   └── resources                 ( resources )
│   │       ├── application-docker.properties
│   │       ├── application-local.properties ( This profile file will be used in docker )
│   │       ├── logback-spring-local.xml
│   └── test ( Tests. Sorry don't have anything here yet :P )
│       └── java
├── target ( Compiled java files go here )
└── terraform ( Terraform files to create/update the infra )
    ├── elb_sg.tf                    ( Security group of load balancer)
    ├── main.tf                      (Main TF file)
    ├── output.tf                    (These tfvars will be exported from terraform )
    ├── rds.tf                       ( TF to create/update RDS )
    ├── tf_apply.sh                  ( Utility shell script to apply terraform )
    ├── tf_gen_env.sh                ( Generates env.sh file that can be sourced in later stages of pipeline)
    ├── tf_plan.sh                   ( Utility shell script to do terraform plan)
    ├── tfvars ( Different tfvars for each env QA/PP/PROD)
    │   ├── in-dev-ap-south-1.tfvars
    │   └── in-qa-ap-south-1.tfvars
    └── vars.tf ( terraform variables defined in the module)

