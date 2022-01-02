echo 'Hello World'
echo "This build number: $BUILD_NUMBER"
pwd
sleep 3
whoami
sleep 3
echo "Build is name: $BUILD_DISPLAY_NAME"

# Started by user admin
# Running as SYSTEM
# Building in workspace /var/lib/jenkins/workspace/MyJobNumber-1
# [MyJobNumber-1] $ /bin/sh -xe /tmp/jenkins17106054482942135408.sh
# + echo Hello World
# Hello World
# + echo This build number: 2
# This build number: 2
# + pwd
# /var/lib/jenkins/workspace/MyJobNumber-1
# + sleep 3
# + whoami
# jenkins
# + sleep 3
# + echo Build is name: #2
# Build is name: #2
# Finished: SUCCESS