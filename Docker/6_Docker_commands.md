Команды управления


# запуск остановленного контейнера
docker start CONTAINER

# приостановление всех процессов, запущенных в контейнере
docker pause CONTAINER

# остановка контейнера
docker stop CONTAINER

# "убийство" контейнера
docker kill CONTAINER

# перезапуск контейнера
docker restart CONTAINER

# удаление остановленного контейнера
docker rm [OPTIONS] CONTAINER
# основные флаги
-f - принудительное удаление (остановка и удаление) запущенного контейнера
-v - удаление анонимных томов, связанных с контейнером
# пример удаления всех остановленных контейнеров
docker rm $(docker ps --filter status=exited -q)

# удаление образа
docker rmi IMAGE

###

# управление образами
docker image COMMAND

# управление контейнерами
docker container COMMAND

# управление томами
docker volume COMMAND

# управление сетями
docker network COMMAND

# управление docker
docker system COMMAND

=================================================

Другие команды


Для получения логов запущенного контейнера используется команда docker logs:


docker logs [OPTIONS] CONTAINER
# основные флаги
-f - следование за выводом
-n - n последних строк

Для удаления всех неиспользуемых данных (контейнеры, сети, образы и, опционально, тома) используется команда docker system prune. Основные флаги:


-a - удаление всех неиспользуемых образов, а не только обособленных (dangling)
--volumes - удаление томов

Предостережение: применять эту команду следует с крайней осторожностью, поскольку удаленные данные не подлежат восстановлению.
