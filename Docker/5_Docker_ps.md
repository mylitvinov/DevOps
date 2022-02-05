docker ps


Команда docker ps используется для получения списка (по умолчанию только запущенных) контейнеров.


# сигнатура
docker ps [OPTIONS]
# основные флаги
-a - показать все контейнеры (как запущенные, так и остановленные)
-f - фильтрация вывода на основе условия (`id`, `name`, `status` и т.д.)
-n - показать n последних созданных контейнеров
-l - показать последний созданный контейнер
# пример получения списка приостановленных контейнеров
docker ps -f 'status=paused'