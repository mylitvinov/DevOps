
Работа с инструкцией Volume

Настройка окружения:

cd docker_images 
mkdir volumes
cd volumes


Создание Dockerfile:

vi Dockerfile


Сборка образа с Nginx, который использует том:

FROM nginx:latest
VOLUME ["/usr/share/nginx/html/"]


Сборка нового образа:

docker image build -t linuxacademy/nginx:v1 .


Создание нового контейнера с использованием образа linuxacademy/nginx:v1:

docker container run -d --name nginx-volume linuxacademy/nginx:v1


Инспектирование nginx-volume:

docker container inspect nginx-volume


Вывод списка томов:

docker volume ls | grep [VOLUME_NAME]


Инспектирование томов:

docker volume inspect [VOLUME_NAME]
