ubuntu_master:
ssh mylitvinov@192.168.1.182
===========================================
ubuntu_slave1:
ssh mylitvinov1@192.168.1.184
============================================

ubuntu_slave2:
ssh mylitvinov1@192.168.1.120
============================================
Создание ключей и отправка на сервер publickey:

ssh-keygen -t rsa
ssh-copy-id -i .ssh/id_rsa.pub mylitvinov@192.168.1.182
===============================================
Проверка версии ansible:

ansible --version
===============================================
Создаем директорию ansible и в ней файл hosts.txt, добавляем сервера для подключения
mkdir ansible
cd ansible
nano hosts.txt
[staging_servers]
ubuntu_slave1 ansible_host=192.168.1.184 ansible_user=mylitvinov1 ansible_ssh_private_key_file=/home/mylitvinov/.ssh/id_rsa
=====================================================

Подключаемся к сервакам, проверяем. 

ansible -i hosts.txt all -m ping

Вот такой ответ:

ubuntu_slave1 | SUCCESS => {
    "ansible_facts": {
        "discovered_interpreter_python": "/usr/bin/python3"
    },
    "changed": false,
    "ping": "pong"
}

====================================================================
Создаем ansible.cfg, конфигурационный файл. Можно убрать запрос слепка/fingerprint при первом коннекте с серверами
или редактируем его /etc/ansible/ansible.cfg
nano ansible.cfg
[defaults]
# uncomment this to disable SSH key host checking
host_key_checking = False

Не надо больше писать после ansible  строчку -i hosts.txt, по умолчанию берем файл, указав где он :

inventory      = ./hosts.txt
=========================================================

