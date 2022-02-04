docker build


Команда docker build используется для создания образа на основе файла Dockerfile и контекста. Контекст — это набор файлов, находящихся в локации, определенной с помощью PATH или URL. PATH — это директория в нашей локальной системе, а URL — это удаленный репозиторий. Контекст сборки обрабатывается рекурсивно, поэтому PATH включает как директорию, там и все ее поддиректории, а URL — как репозиторий, так и все его субмодули. Для исключения файлов из сборки образа используется .dockerignore (синтаксис этого файла похож на .gitignore).


# сигнатура
docker build [OPTIONS] PATH | URL | -

Создание образа:


# в качестве контекста сборки используется текущая директория
docker build .

Использование репозитория в качестве контекста (предполагается, что Dockerfile находится в корневой директории репозитория):


docker build github.com/creack/docker-firefox

docker build -f ctx/Dockerfile http://server/ctx.tar.gz

В данном случае http://server/ctx.tar.gz отправляется демону, которые загружает и извлекает файлы. Параметр -f ctx/Dockerfile определяет путь к Dockerfile внутри ctx.tar.gz.


Чтение Dockerfile из STDIN без контекста:


docker build - < Dockerfile

Добавление тега к образу:


docker build -t myname/my-image:latest .

Определение Dockerfile:


docker build -f Dockerfile.debug .

Экспорт файлов сборки в директорию out:


docker build -o out .

Экспорт файлов сборки в файл out.tar:


docker build -o - . > out.tar