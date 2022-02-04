
Использование многоэтапных сборок

Настройка окружения:

cd docker_images
mkdir multi-stage-builds 
c  multi-stage-builds
git clone https://github.com/linuxacademy/content-weather-app.git src


Создание Dockerfile:

vi Dockerfile


Содержимое Dockerfile:

# Create an image for the weather-app using multi-stage build
FROM node AS build
RUN mkdir -p /var/node/ 
ADD src/ /var/node/
WORKDIR /var/node 
RUN npm install

FROM node:alpine A RG VERSION=V1.1
LABEL org.label-schema.version=$VERSION 
ENV NODE_ENV="production"
COPY --from=build /var/node /var/node 
WORKDIR /var/node
EXPOSE 3000
ENTRYPOINT ["./bin/www"]


Сборка образа:

docker image build -t linuxacademy/weather-app:multi-stage-build --rm --build-arg V ERSION=1.5 .


Вывод списка образов для просмотра различий в размере:

docker image ls


Создание контейнера weather-app:
 
docker container run -d --name multi-stage-build -p 8087:3000 l inuxacademy/weather-app:multi-stage-build
