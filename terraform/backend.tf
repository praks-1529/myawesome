terraform {
  backend "s3" {
    bucket = "tf-state-myawesome-sqewru13s"
    key = "myawesome-service-1-in-qa-ap-south-1"
    region = "ap-south-1"
  }
}
