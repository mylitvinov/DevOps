Настройки Jenkins

Конфигурация системы

Количество сборщиков: 4 ( ставим необходимое количество)

Labels (Метки) (название сервера, agent , необязательно)

==========================================

Перезагрузка через UI http://192.168.1.182:8080/restart

Через командную строку

sudo service jenkins restart

===================================================

Обновляем

cd /usr/share/jenkins/

jenkins.war - актуальная версия(ставится автоматом отсюда)

Делаем копию текущей версии

sudo mv jenkins.war jenkinsx.xxx.x.war 

sudo wget link

======================================

Статус jenkins: 

service jenkins status

============================================

CLI

java -jar jenkins-cli.jar -auth myserviceuser:password123 -s http://localhost:8080 who-am-i

=======================================

Экспорт переменных

export JENKINS_USER_ID=mynewuser
export JENKINS_API_TOKEN=qq3423twtwtwfsgSCffafgs

env | grep JENKINS

=====================================================

java -jar jenkins-cli.jar -s http://localhost:8080 who-am-i


сохраняем файл джобу с Jenkins
java -jar jenkins-cli.jar -s http://localhost:8080 get-job MyJobNumber-1 > myjob.xml


отправляем джобу в Jenkins
Linux:
java -jar jenkins-cli.jar -s http://localhost:8080 create-job MyJobNumberFromLocalComp-1 < myjob.xml

Windows PowerShell:
get-content myjob.xml | java -jar jenkins-cli.jar -s http://localhost:8080 create-job MyJobNumberFromLocalComp-1 

=======================

SSH с GitHub

Settings - SSH and GPG keys - Add SSH key

и вставляем public key

В самом Jenkins настраиваем privatKey
==============================================

Build triggers:

1) Trigger builds remotely (e.g., from scripts)

По url, создаем tokken

http://192.168.1.182:8080//job/Build-AUTO-Trigger-1/build?token=ghdhqg235ghgshdfgshgf45h34hghsghg5646hjghg

вставляем в адресную строку браузера или
через командную строку:
 curl url (но через user и токкен на вход Jenkins или логин:пароль)
 curl http://Family:11f634be4da3d2da733f9074a4d70d1f7a@192.168.1.182:8080//job/Build-AUTO-Trigger-1/build?token=ghdhqg235ghgshdfgshgf45h34hghsghg5646hjghg

 curl http://admin:admin@192.168.1.182:8080//job/Build-AUTO-Trigger-1/build?token=ghdhqg235ghgshdfgshgf45h34hghsghg5646hjghg

================================================
2) Build after other projects are built

После окончания сборки какого-то проекта

======================================================

3) Запускать периодически

*/1 * * * * каждую минуту

This field follows the syntax of cron (with minor differences). Specifically, each line consists of 5 fields separated by TAB or whitespace:
MINUTE HOUR DOM MONTH DOW
MINUTE	Minutes within the hour (0–59)
HOUR	The hour of the day (0–23)
DOM	The day of the month (1–31)
MONTH	The month (1–12)
DOW	The day of the week (0–7) where 0 and 7 are Sunday.
To specify multiple values for one field, the following operators are available. In the order of precedence,

* specifies all valid values
M-N specifies a range of values
M-N/X or */X steps by intervals of X through the specified range or whole valid range
A,B,...,Z enumerates multiple values
To allow periodically scheduled tasks to produce even load on the system, the symbol H (for “hash”) should be used wherever possible. For example, using 0 0 * * * for a dozen daily jobs will cause a large spike at midnight. In contrast, using H H * * * would still execute each job once a day, but not all at the same time, better using limited resources.

The H symbol can be used with a range. For example, H H(0-7) * * * means some time between 12:00 AM (midnight) to 7:59 AM. You can also use step intervals with H, with or without ranges.

The H symbol can be thought of as a random value over a range, but it actually is a hash of the job name, not a random function, so that the value remains stable for any given project.

Beware that for the day of month field, short cycles such as */3 or H/3 will not work consistently near the end of most months, due to variable month lengths. For example, */3 will run on the 1st, 4th, …31st days of a long month, then again the next day of the next month. Hashes are always chosen in the 1-28 range, so H/3 will produce a gap between runs of between 3 and 6 days at the end of a month. (Longer cycles will also have inconsistent lengths but the effect may be relatively less noticeable.)

Empty lines and lines that start with # will be ignored as comments.

In addition, @yearly, @annually, @monthly, @weekly, @daily, @midnight, and @hourly are supported as convenient aliases. These use the hash system for automatic balancing. For example, @hourly is the same as H * * * * and could mean at any time during the hour. @midnight actually means some time between 12:00 AM and 2:59 AM.

Examples:

# Every fifteen minutes (perhaps at :07, :22, :37, :52):
H/15 * * * *
# Every ten minutes in the first half of every hour (three times, perhaps at :04, :14, :24):
H(0-29)/10 * * * *
# Once every two hours at 45 minutes past the hour starting at 9:45 AM and finishing at 3:45 PM every weekday:
45 9-16/2 * * 1-5
# Once in every two hour slot between 8 AM and 4 PM every weekday (perhaps at 9:38 AM, 11:38 AM, 1:38 PM, 3:38 PM):
H H(8-15)/2 * * 1-5
# Once a day on the 1st and 15th of every month except December:
H H 1,15 1-11 *
Time zone specification
Periodic tasks are normally executed at the scheduled time in the time zone of the Jenkins master JVM (currently Etc/UTC). This behavior can optionally be changed by specifying an alternative time zone in the first line of the field. Time zone specification starts with TZ=, followed by the ID of a time zone.

==================================================

4) Опрашивать SCM об изменениях

SCM Управление исходным кодом (Source Code Managment)

Как правило синхронизируют с гит, 
================================================
5) GitHub hook trigger for GITScm polling

по изменениям коммитов, синхронизация с гит

В самом репозитории настраиваем вебхук:

Settings-webhooks

http://192.168.1.182:8080/github-webhook/

Content type
 application/json

=============================================================

Jobs с параметрами

в job выбираем чекбокс:

Это - параметризованная сборка

Добавить параметр

Параметр строки: (один из параметров, выбираем нужный)

name: FOLDERNAME (впоследствии становится переменной, которую можно использовать в командах в Job)
default value: /home
description: здесь описываем задание
=============================================
Choice параметр (выбор из перечисленных)
Name: To_do_Choice (станет переменной)
Choices:
Yes
No
Don`t know

Description: описание
========================================

File parametr:

File location: Название файла (/home/ubuntu/UPLOADED_FILE)
Куда и под каким именем будет загружаться файл
Desription: