
Entrypoint vs command


Настройка окружения:

cd docker_images 
mkdir entrypoint 
cd entrypoint


Создание Dockerfile:

vi Dockerfile


Содержимое Dockerfile:

# Create an image for the weather-app
FROM node
LABEL org.label-schema.version=v1.1 
ENV NODE_ENV="production"
ENV PORT 3001

RUN mkdir -p /var/node 
ADD src/ /var/node/
WORKDIR /var/node R UN npm install
EXPOSE $PORT
ENTRYPOINT ./bin/www


Клонирование образа:

git clone https://github.com/linuxacademy/content-weather-app.git src


Сборка образа:

docker image build -t linuxacademy/weather-app:v4 .


Развертывание weather-app:

docker container run -d --name weather-app4 linuxacademy/weather-app:v4
 
Инспектирование weather-app4:

docker container inspect weather-app4 | grep Cmd docker container inspect weather-app-nonroot
docker container inspect weather-app4


Создание контейнера weather-app:

docker container run -d --name weather-app5 -p 8083:3001 l inuxacademy/weather-app:v4 echo "Hello World"


Инспектирование weather-app5:

docker container inspect weather-app5


Создание томов для Prometheus:

docker volume create prometheus
docker volume create prometheus_data



Создание контейнера для Prometheus:

docker run --name prometheus -d -p 8084:9090 \
    -v prometheus:/etc/prometheus \
    -v prometheus_data:/prometheus/data \
    prom/prometheus \
    --config.file=/etc/prometheus/prometheus.yml \
    --storage.tsdb.path=/prometheus/data


Инспектирование Prometheus:

docker container inspect prometheus
