resource "aws_security_group" "myawesome_elb_security_group" {
  name   = "${var.component_name}-${var.product_market}-${var.environment}"
  description = "Allow all inbound traffic on ELBs"
  vpc_id = "vpc-055cc9ea05e799c82" // Please use the VPC id of your k8s cluster

  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = [
      "0.0.0.0/0"]
  }
}

resource "aws_security_group_rule" "allow_external_ips" {
  type              = "ingress"
  from_port         = "${var.elb_ext_traffic_port}"
  to_port           = "${var.elb_ext_traffic_port}"
  protocol          = "tcp"
  cidr_blocks       = ["0.0.0.0/32"]
  security_group_id = "${aws_security_group.myawesome_elb_security_group.id}"
}