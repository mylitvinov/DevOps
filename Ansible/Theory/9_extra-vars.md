В playbook создаем переменную, например, MYHOSTS

=============================================

---
- name: Test connection to my servers
  hosts: '{{ MYHOSTS }}'
  become: yes

  tasks:
  - name: Ping my servers
    ping: 
==================================================

Затем вызываем playbook c --extra-vars (--extra-var, --e)

ansible-playbook playbokxxx.yml --extra-var 'MYHOSRS=staging_servers_ALL'

см. файл hosts.txt
================================================
[staging_servers1]
ubuntu_slave1  ansible_host=192.168.1.201   ansible_user=mylitvinov1 
[staging_servers2]
ubuntu_slave2  ansible_host=192.168.1.120   ansible_user=mylitvinov2

[staging_servers_ALL:children]
[staging_servers1]
[staging_servers2]

=====================================================