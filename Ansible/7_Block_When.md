Проверяем версию ОС Linux ('Debian', 'RedHat'...)
================================================
---
- name: Check version LINUX
  hosts: all
  become: yes

  tasks:
    - name: Print version LINUX
      debug: var=ansible_os_family

======================================================
Ответ:
ok: [ubuntu_slave1] => {
    "ansible_os_family": "Debian"
}
ok: [ubuntu_slave2] => {
    "ansible_os_family": "RedHat"
}
============================================================
Пишем код с условием