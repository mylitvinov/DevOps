
Сборка образов

Сборка образа:

docker image build -t <NAME>:<TAG> .

cd docker_images/weather-app
cp Dockerfile Dockerfile.test
docker image build -t linuxacademy/weather-app:path-example1 -f Dockerfile.test . 
docker image build -t linuxacademy/weather-app:path-example2 --label
com.linuxacademy.version=v1.8 -f Dockerfile.test .

Сборка образа путем передачи Dockerfile по программному каналу из STDIN:

docker image build -t <NAME>:<TAG> -<<EOF
Build instructions
EOF

Пример:

docker image build -t linuxacademy/nginx:stind --rm -<<EOF 
FROM nginx:latest
VOLUME ["/usr/share/nginx/html/"] 
EOF

Сборка образа с использованием URL:

docker image build -t <NAME>:<TAG> <GIT_URL>#<REF>
docker image build -t <NAME>:<TAG> <GIT_URL>#:<DIRECTORY>
docker image build -t <NAME>:<TAG> <GIT_URL>#<REF>:<DIRECTORY>

Пример:

docker image build -t linuxacademy/weather-app:github
https://github.com/linuxacademy/content-weather-app.git#remote-build

Сборка образа из сжатого файла:

docker image build -t <NAME>:<TAG> - < <FILE>.tar.gz

Пример:

cd docker_images 
mkdir tar_image 
cd tar_image
 
git clone https://github.com/linuxacademy/content-weather-app.git 
cd content-weather-app
git checkout remote-build
tar -zcvf weather-app.tar.gz Dockerfile src
docker image build -t linuxacademy/weather-app:from-tar - < weather-app.tar.gz
