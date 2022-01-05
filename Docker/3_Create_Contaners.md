
Создание контейнеров

docker container run busybox (запускает и сразу останавливается процесс, sh, удлбно для задач)

docker container run --rm busybox (флаг --rm после завершения задачи, контейнер останавливается и удаляется)

docker container run nginx

docker container run -d nginx (создаем контейнер (-d выйти из контейнера) и запустить в фоновом режиме)

Присоединяемся к созданному контейнеру

docker container run -it busybox

Создаем свой контейнер

docker container run --name my_busybox busybox

=================================================

Открытие портов контейнеров

docker container run -d --expose 1234 nginx (открываем порт 1234)

docker rm -f 2581f9e320fb e966ef48fa52 (удаляем ненужные контейнеры, например с nginx)

docker container run -d --expose 1234 -p 80:1234 nginx (перенаправляем порт с 80 на 1234)

docker container run -d --expose 1234 -p 8080:80 nginx (перенаправляем порт с 8080 на 80)

docker container run -d -p 8081:80/tcp -p 8081:80/udp nginx 

docker container port id (смотрим порты открытые/перенаправленные на определенном контейнере)

================================================

Выполнение команд в контейнере


docker container run -d nginx

Заходим в командную строку nginx

docker container run -it nginx /bin/bash (после выхода контенейнер перестает существовать)

docker container exec -it 7d20d6eec24f /bin/bash (после выхода контейнер по прежнему работает и существует)

exec можно выполнять команды на работающем контейнере и не заходить на него

docker container exec -it 7d20d6eec24f ls /etc/var

===============================================