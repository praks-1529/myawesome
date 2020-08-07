output "db-host" {
  value = "${aws_db_instance.server-db.endpoint}"
}

output "db-passwd" {
  value = "${aws_db_instance.server-db.password}"
}

output "ext_sg_groups" {
  value = "${aws_security_group.myawesome_elb_security_group.id}"
}