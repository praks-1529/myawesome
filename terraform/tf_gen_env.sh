#!/bin/bash
echo "#!/bin/bash"
echo "export DB_HOST=`AWS_PROFILE=${AWS_PROFILE} terraform output -no-color db-host`"
echo "export DB_PASSWORD=`AWS_PROFILE=${AWS_PROFILE} terraform output -no-color db-passwd`"
echo "export EXT_SG_GROUPS=`AWS_PROFILE=${AWS_PROFILE} terraform output -no-color ext_sg_groups`"