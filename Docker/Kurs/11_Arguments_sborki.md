
Аргументы сборки

Использование флага --build-arg при сборке образа:

-- build-arg [NAME]=[VALUE]


Использование инструкции A RG в Dockerfile:

ARG [NAME]=[DEFAULT_VALUE]


Переход в каталог args:

cd  docker_images 
mkdir args
cd args


Клонирование weather-app:

git clone https://github.com/linuxacademy/content-weather-app.git src


Создание Dockerfile:

vi Dockerfile


Dockerfile:

# Create an image for the weather-app
FROM node
LABEL org.label-schema.version=v1.1 A RG SRC_DIR=/var/node

RUN mkdir -p $SRC_DIR A DD src/ $SRC_DIR
WORKDIR $SRC_DIR
RUN npm install E XPOSE 3000
CMD ./bin/www


Создание контейнера weather-app:
 

docker image build -t linuxacademy/weather-app:v3 --build-arg SRC_DIR=/var/code .


Инспектирование образа:

docker image inspect linuxacademy/weather-app:v3 | grep WorkingDir


Создание контейнера weather-app:

docker container run -d --name weather-app3 -p 8085:3000 l inuxacademy/weather-app:v3


Проверка того, что контейнер работает, при помощи c url:

curl localhost:8085
