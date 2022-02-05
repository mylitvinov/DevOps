ssh root@192.168.1.201 'hostname'

// ssh root@ub1  hostname
ssh root@192.168.1.120 'hostname'
// ssh root@ub2  hostname

команды в стейджах сначала пишем sh

sh 'ls -la /etc/var/'

// Started by user admin
// Running as SYSTEM
// Building in workspace /var/lib/jenkins/workspace/test_job
// [test_job] $ /bin/sh -xe /tmp/jenkins14811533390593994389.sh
// + ssh root@192.168.1.201 hostname
// ubuntuserver1
// + ssh root@192.168.1.120 hostname
// ubuntuserver2
// Finished: SUCCESS
