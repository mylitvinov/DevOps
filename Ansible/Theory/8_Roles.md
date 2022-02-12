mkdir roles

cd roles

ansible-galaxy init deploy_apache_web

Создается директория с каталогами и пустыми .yml файлами(см. документацию ansible), которые мы заполняем из, например,playbook (см.playbook3)

Создаем playbook

===============================================================================

---
- name: Install default Apache Webserver
  hosts: all
  become: yes

  roles: 
    - deploy_apache_web
    <!-- - { role: deploy_apache_web, when: ansible_system=='Linux'} -->

==============================