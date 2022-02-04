
Dockerfile — это простой текстовый файл, в котором содержится список команд Докер-клиента. Это простой способ автоматизировать процесс создания образа. Самое классное, что команды в Dockerfile почти идентичны своим аналогам в Linux. Это значит, что в принципе не нужно изучать никакой новый синтаксис чтобы начать работать с докерфайлами.


В директории с приложением есть Dockerfile, но так как мы делаем все впервые, нам нужно создать его с нуля. Создайте новый пустой файл в любимом текстовом редакторе, и сохраните его в той же директории, где находится flask-приложение. Назовите файл Dockerfile.


Для начала укажем базовый образ. Для этого нужно использовать ключевое слово FROM.

FROM python:3-onbuild


Дальше обычно указывают команды для копирования файлов и установки зависимостей. Но к счастью, onbuild-версия базового образа берет эти задачи на себя. Дальше нам нужно указать порт, который следует открыть. Наше приложение работает на порту 5000, поэтому укажем его:


EXPOSE 5000


Последний шаг — указать команду для запуска приложения. Это просто python ./app.py. Для этого используем команду CMD:


CMD ["python", "./app.py"]


Главное предназначение CMD — это сообщить контейнеру какие команды нужно выполнить при старте. Теперь наш Dockerfile готов. Вот как он выглядит:


# our base image
FROM python:3-onbuild

# specify the port number the container should expose
EXPOSE 5000

# run the application
CMD ["python", "./app.py"]


Теперь можно создать образ. Команда docker build занимается сложной задачей создания образа на основе Dockerfile.

=========================================================

Создание образа

docker build -t mylitvinov/myimage .

Если у вас нет образа python:3-onbuild, то клиент сначала скачает его, а потом возьмется за создание вашего образа. Так что, вывод на экран может отличаться от моего. Посмотрите внимательно, и найдете триггеры onbuild. Если все прошло хорошо, то образ готов! Запустите docker images и увидите свой образ в списке.


Последний шаг — запустить образ и проверить его работоспособность (замените username на свой):


 docker run -p 8888:5000 mylitvinov/myimage
 * Running on http://0.0.0.0:5000/ (Press CTRL+C to quit)

 

Зайдите на указанный URL и увидите приложение в работе.

========================================

Публикация в регистре DockerHub

docker push mylitvinov/myimage

=======================================

Теперь наш образ онлайн, и любой докер-клиент может поиграться с ним с помощью простой команды:

 docker run -p 8888:5000 mylitvinov/myimage

=====================================