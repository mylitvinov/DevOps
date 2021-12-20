Проверка связи:

ansible all -m ping
======================================================

Сканируем сервер, полная информация о нем:
ansible staging_servers1 -m setup

===========================================
Запускаем какую либо команду на всех серверах:
ansible all -m shell -a 'uptime -p'          смотрим время работы сервера

ansible all -m shell -a 'ls /etc'            содержимое директорий /etc

ansible all -m shell -a 'pwd'  

Можно использовать command вместо shell, но некоторые команды, переменные не будут доступны
============================================================

Копируем файл на все сервера

ansible all -m copy -a 'src=devops.txt dest=/home mode=777' -b -K   (-b быть sudo  -K запрашивает пароль)

Но вот когда требуются права root и используется -b, приходится обязательно использовать -К и вводить пароль. На просторах инета пишут, что решается отключением пароля для sudo на целевом хосте (sudo  ALL=(ALL:ALL) NOPASSWD: ALL).


At the end of the /etc/sudoers file add this line:
username     ALL=(ALL) NOPASSWD:ALL

============================================================

Смотрим содержимое папки на всех серверах:

ansible all -m shell -a 'ls -la /home'

===========================================================
Удаляем файл с всех серверов

ansible all -m file -a 'path=/home/devops.txt state=absent' -b -K 
=============================================================

скачать по url на все сервера

ansible all -m get_url -a 'url=https://ds.emm.sberbank.ru/mac.pkg dest=/home' -b -K 

================================================

Установка пакетов
ansible all -m apt -a 'name=stress state=latest' -b -K

Удаление пакетов
ansible all -m apt -a 'name=stress state=absent' -b -K
===================================================

Проверяем доступность сайта. HTTP запросы, статус 200 ОК.
ansible all -m uri -a 'url=https://github.com/mylitvinov'

с контентом

ansible all -m uri -a 'url=https://github.com/mylitvinov return_conternt=yes'
===============================================================

Установка пакета apache
ansible all -m apt -a 'name=apache2 state=latest' -b -K

Проверка статуса
systemctl status apache2

ansible all -m shell -a 'systemctl status apache2'
=================================

ключик в конце команды -vvvvv дебагинг