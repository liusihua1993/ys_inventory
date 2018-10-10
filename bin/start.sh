###启动
#!/bin/bash

module="inventory"
pidPath="/var/run/$module.pid"

PROFILE=$1
if [ ! -n "$PROFILE" ] ;then
  PROFILE="prod"
fi

rm -f $pidPath
echo "Starting with profile $PROFILE ..."
nohup java -jar ./$module.jar -server -Xms1024m -Xmx2048m -Xss256k --spring.profiles.active=$PROFILE &
echo $! > $pidPath