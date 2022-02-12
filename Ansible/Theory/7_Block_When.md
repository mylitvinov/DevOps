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
Пишем код с условием, см playbook6

====================================================================

 - block: # ======== for Debian ==============
        - name: Install Apache WebServer (Debian)
          apt: name=apache2
            state=latest
        - name: Copy my homepage to server
          copy: src={{source_file}}
            dest={{destin_file}}
            mode=0555
          notify: Restart Apache for Debian
   when: ansible_os_family=='Debian'
================================================================================