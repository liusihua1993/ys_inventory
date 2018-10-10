###停止
#!/bin/bash

module="inventory"
pidPath="/var/run/$module.pid"

pid=`cat $pidPath | awk '{print $1}'`
pid=`ps -aef | grep $pid | awk '{print $2}' |grep $pid`
if [ ${pid} ]; then
  kill -9 $pid
fi