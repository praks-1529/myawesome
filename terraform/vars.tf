variable "rds_instance_size" {
  default = "db.t2.micro"
}

variable "elb_ext_traffic_port" {
  description = "All incomming traffic"
  default     = 80
}