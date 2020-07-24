resource "aws_db_parameter_group" "server-rds" {
  name   = "pg-${var.component_name}-${var.product_market}-${var.environment}"
  family = "mysql5.7"
}

locals {
  db_name = "rds_${var.component_name}_${var.product_market}_${var.environment}"
}

resource "aws_db_instance" "server-db" {
  allocated_storage    = 20
  storage_type         = "gp2"
  engine               = "mysql"
  engine_version       = "5.7"
  instance_class       = "${var.rds_instance_size}"
  name                 = "${replace(local.db_name, "-", "_")}"
  username             = "root"
  password             = "your_root_paswd_ideal_to_get_it_from_env"
  parameter_group_name = "${aws_db_parameter_group.server-rds.name}"
  identifier           = "${var.component_name}-${var.product_market}-${var.environment}"
  apply_immediately    = "false"
  skip_final_snapshot = "true"
}