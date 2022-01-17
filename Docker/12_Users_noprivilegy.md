Работа с непривилегированными пользователями

Настройка окружения:

cd docker_images
mkdir non-privileged-user 
cd non-privileged-user


Создание Dockerfile:

vi Dockerfile


Содержимое Dockerfile:

# Creates a CentOS image that uses cloud_user as a non-privileged user
FROM centos:latest
RUN useradd -ms /bin/bash cloud_user 
USER cloud_user


Сборка нового образа:

docker image build -t centos7/nonroot:v1 .


Создание контейнера с использованием нового образа:

docker container run -it --name test-build centos7/nonroot:v1 /bin/bash


Подключение под привилегированным пользователем:

docker container start test-build
docker container exec -u 0 -it test-build /bin/bash


Настройка окружения:

cd ~/docker_images
mkdir node-non-privileged-user c d node-non-privileged-user


Создание Dockerfile:

vi Dockerfile


Содержимое Dockerfile:

# Create an image for the weather-app
FROM node
LABEL org.label-schema.version=v1.1 R UN useradd -ms /bin/bash node_user U SER node_user
ADD src/ /home/node_user W   ORKDIR /home/node_user R UN npm install
EXPOSE 3000
CMD ./bin/www


git clone https://github.com/linuxacademy/content-weather-app.git src


Сборка	образа	weather-app	с	использованием	непривилегированного пользователя node_user:

docker image build -t linuxacademy/weather-app-nonroot:v1 .


Создание	контейнера	с	использованием	образа
linuxacademy/weather-app-nonroot:v1:

docker container run -d --name weather-app-nonroot -p 8086:3000 l inuxacademy/weather-app-nonroot:v1
