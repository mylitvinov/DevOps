Dockerfile

Dockerfile — это документ (без расширения), содержащий инструкции, которые используются для создания образа при выполнении команды docker build.

Предостережение: не используйте / в качестве PATH для контекста сборки. Это приведет к передаче демону всего содержимого жесткого диска вашей машины.

Инструкции выполняются по одной. Результаты наиболее важных инструкций фиксируются в виде отдельных слоев образа. Обратите внимание: каждая инструкция выполняется независимо от других. Это означает, что выполнение RUN cd /tmp не будет иметь никакого эффекта для последующих инструкций.


Dockerfile может содержать следующие инструкции:


# Комментарий
ИНСТРУКЦИЯ аргументы

# Основные
# FROM - родительский образ
FROM <image>[:<tag>] [AS <name>]
# пример
FROM node:12-alpine AS build

# WORKDIR - установка рабочей директории для инструкций RUN, CMD, ENTRYPOINT, COPY и ADD
WORKDIR /path/to/dir
# пример
WORKDIR /app

# COPY - копирование новых файлов или директорий из <src>
# и их добавление в файловую систему образа по адресу, указанному в <dest>
COPY <src> <dest>
COPY ["<src>", "<dest>"]
# пример
COPY package.* yarn.lock ./
# или
COPY . .
# ADD, в отличие от COPY, позволяет копировать удаленные файлы,
# а также автоматически распаковывает сжатые (identity, gzip, bzip2 или xz) локальные файлы

# ADD - копирование новых файлов, директорий или удаленного (!) файла из <src>
# и их добавление в файловую систему образа по адресу, указанному в <dest>
ADD <src> <dest>
ADD ["<src>", "<dest>"]
# пример
ADD some.txt some_dir/ # <WORKING_DIR>/some_dir/

# RUN - выполнение команды в новом слое на основе текущего образа и фиксация результата
RUN <command>
# или
RUN ["executable", "arg1", "arg2"] # Кавычки должны быть двойными
# пример
RUN npm install

# CMD - предоставление дефолтных значений исполняемому контейнеру
CMD ["executable", "arg1", "arg2"]
# или если данной инструкции предшествует инструкция ENTRYPOINT
CMD ["arg1", "arg2"]
# или
CMD command arg1 arg2
# пример
CMD [ "node", "/app/src/index.js" ]
# RUN выполняет команду и фиксирует результат,
# CMD ничего не выполняет во время сборки, а определяет команду для образа
# (!) выполняется только одна (последняя) инструкция CMD

# ENTRYPOINT - настройка исполняемого контейнера
ENTRYPOINT ["executable", "arg1", "arg2"]
ENTRYPOINT command arg1 arg2
# пример
ENTRYPOINT ["top", "-b"]
CMD ["-c"]
# docker run -it --rm --name test top -H
# top -b -H
# разница между ENTRYPOINT и CMD:
# https://docs.docker.com/engine/reference/builder/#understand-how-cmd-and-entrypoint-interact
# https://stackoverflow.com/questions/21553353/what-is-the-difference-between-cmd-and-entrypoint-in-a-dockerfile

# переменные
# ${var} или $var
# пример
FROM busybox
ENV FOO=/bar
WORKDIR ${FOO}    # WORKDIR /bar
ADD . $FOO        # ADD . /bar
COPY \$FOO /qux   # COPY $FOO /qux

# Другие
# LABEL - добавление метаданных к образу
LABEL <key>=<value>
# пример
LABEL version="1.0"

# EXPOSE - информация о сетевом порте, прослушиваемом контейнером во время выполнения
EXPOSE <port> | <port>/<protocol>
# пример
EXPOSE 3000

# ENV - установка переменных среды окружения
ENV <key>=<value>
# пример
ENV MY_NAME="No Name"

# VOLUME - создание точки монтирования
VOLUME ["/var/log"]
VOLUME /var/log

# USER - установка пользователя для использования при запуске контейнера
# в любых инструкциях RUN, CMD и ENTRYPOINT
USER <user>[:<group>]
USER <UID>[:<GID>]

# ARG - определение переменной, которая может быть передана через командную строку при
# выполнении команды `docker build` с помощью флага `--build-arg <name>=<value>`
ARG <name>[=<default value>]

# ONBUILD - добавление в образ триггера, запускаемого при использовании
# данного образа в качестве основы для другой сборки
ONBUILD <INSTRUCTION>