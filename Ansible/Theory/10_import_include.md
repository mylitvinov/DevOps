См playbook10


Проверяем содержимое директории
ansible -m shell -a 'ls  /home/secret' all


Проверяем содержимое файла
ansible -m shell -a 'cat  /home/secret/file1' all