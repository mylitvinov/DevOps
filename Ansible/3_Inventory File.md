Файл инвентаризации по умолчанию обычно находится по адресу /etc/ansible/hosts, но вы также можете использовать -i опцию для указания на пользовательские файлы инвентаризации при выполнении команд Ansible и плейбуков. Это полезно для настройки инвентаризации для каждого проекта, которую можно включить в системы контроля версий, такие как Git:

ansible all -m ping -i my_custom_inventory
 
Такой же вариант действителен для ansible-playbook:

ansible-playbook myplaybook.yml -i my_custom_inventory
==================================================================

Группа -all входят все сервера из файла hosts
ungrouped остальные сервера, без группы

============================================================

Пример заполнения hosts

10.55.1.2
10.55.1.3

[staging_DB]
192.168.1.1
192.168.1.2

[staging_WEB]
192.168.2.1
192.168.2.2

[staging_APP]
192.168.3.1
192.168.3.2

[staging_ALL:children]
staging_DB
staging_WEB
staging_APP


[prod_DB]
10.168.1.1
10.168.1.2

[prod_WEB]
10.168.2.1
10.168.2.2

[prod_APP]
10.168.3.1
10.168.3.2

[prod_ALL:children]
prod_DB
prod_WEB
prod_APP

[DB_ALL:children]
staging_DB
prod_DB

[WEB_ALL:children]
staging_WEB
prod_WEB

============================================
[prod_servers]
ubuntu_slave1 ansible_host=192.168.1.184 ansible_user=mylitvinov1 ansible_ssh_private_key_file=/home/mylitvinov/.ssh/id_rsa


[prod_servers:vars]
ansible_user=mylitvinov1 
ansible_ssh_private_key_file=/home/mylitvinov/.ssh/id_rsa

Перенос переменных в group_vars

mkdir group_vars
nano staging_servers

==================================================

Смотрим какие сервера есть(берет инфу из файла hosts):
ansible-inventory --list

в виде "дерева":
ansible-inventory --graph 

=========================================================
