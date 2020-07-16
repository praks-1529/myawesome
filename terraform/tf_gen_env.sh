#!/bin/bash
echo "#!/bin/bash"
echo "export DB_HOST=`AWS_PROFILE=${AWS_PROFILE} terraform output -no-color db_host`"