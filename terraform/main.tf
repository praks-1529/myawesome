variable "aws_profile" {
  default = "dev"
}

variable "aws_region" {
  default = "ap-south-1"
}

variable "product_market" {
  default = "in"
}

variable "environment" {
  default = "dev"
}

provider "aws" {
  region  = "${var.aws_region}"
  profile = "${var.aws_profile}"
  version = ">2.0.0"
}

terraform {
  backend "s3" {
    bucket               = "tf-state-myawesome-sqewru13s"
    region               = "ap-south-1"
    key                  = "myawesome-service-1"
    workspace_key_prefix = "terraform-states"
    acl                  = "bucket-owner-full-control"
  }
  required_version = "~> 0.12.25"
}