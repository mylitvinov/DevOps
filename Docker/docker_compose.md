Docker Compose позволяет управлять набором контейнеров, каждый из которых представляет собой один сервис проекта. Управление включает в себя сборку, запуск с учетом зависимостей и конфигурацию. Конфигурация Docker Compose описывается в файле docker-compose.yml, лежащем в корне проекта.

Пример файла docker-compose.yml
# Версия схемы, которую мы используем.
# Зависит от установленной версии docker
# https://docs.docker.com/compose/compose-file/
version: "3"
# Определяем список сервисов — services
# Эти сервисы будут частью нашего приложения
services:

  app: # Имя сервиса
    build:
      # Контекст для сборки образа,
      # в данном случае, текущая директория
      context: .
      # Имя докерфайла из которого будет собран образ
      dockerfile: Dockerfile
      # Команда, которая будет выполнена после старта сервиса
    command: make start
    ports: # Проброс портов
      - "3000:8000"
    # Перечисляем тома (volumes)
    # Они будут подключены к файловой системе сервиса
    # Например, всё что находится в . мы увидим в директории /app
    volumes:
      - ".:/app"
      - "/tmp:/tmp"
    # Сервис будет запущен, только после старта db
    depends_on:
      - db

  db:
    # Имя образа. Здесь мы используем базу данных Postgres
    image: postgres:latest
    environment: # А так задаются переменные окружения
      POSTGRES_PASSWORD: password
    volumes:
      - pgdata:/var/lib/postgresql/data

Команды для работы с Docker Compose
# Собирает сервисы, описанные в конфигурационных файлах
docker-compose build

# Запускает собранные сервисы
docker-compose up

# Если какой-то из сервисов завершит работу,
# то остальные будут остановлены автоматически
docker-compose up --abort-on-container-exit

# Запустит сервис application и выполнит внутри команду make install
docker-compose run application make install

# А так мы можем запустить сервис и подключиться к нему с помощью bash
docker-compose run application bash

# Останавливает и удаляет все сервисы,
# которые были запущены с помощью up
docker-compose down

# Останавливает но не удаляет сервисы, запущенные с помощью up
# Их можно запустить снова с помощью docker-compose start
docker-compose stop

# Перезапускает все остановленные и запущенные сервисы
docker-compose restart