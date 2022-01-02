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
==============================================

