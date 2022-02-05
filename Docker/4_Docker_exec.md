docker exec

Команда docker exec используется для выполнения команды в запущенном контейнере.

# сигнатура
docker exec [OPTIONS] CONTAINER COMMAND [ARG...]
# основные флаги
-d - выполнение команды в фоновом режиме
-e - установка переменной среды окружения
-i - оставить `STDIN` открытым
-t - выделение псевдотерминала
-w - определение рабочей директории внутри контейнера

Пример:


# -U - это пользователь, которым по умолчанию является root
docker exec -it postgres psql -U postgres

В данном случае в контейнере postgres будет запущен интерактивный терминал psql. Выполним парочку команд:


# получаем список баз данных
\l
# подключаемся к базе данных mydb
-d mydb
# получаем список таблиц, точнее, сообщение об отсутствии отношений (relations)
\dt
# выходим
\q