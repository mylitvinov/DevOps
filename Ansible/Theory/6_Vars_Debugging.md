Смотрим конфигурацию, переменные серверов:

ansible all -m setup

Сохраняем результат переменной после модуля shell:

- shell : uptime
  register : results

 - debug:
    var: results

===============================================

---
- name: My playbook
  hosts: all
  become: yes

  vars:
    message1: Hello
    message2: World
    secret: jfhWFSFHAAAHGAHG34534HJH

  tasks:
    - name: Print secret variable
      debug:
        var: secret
    
    - debug:
        msg: 'Secret word : {{secret}}'


    - debug:
        msg: 'Owner this server : --> {{ansible_user}} <--'

    - set_fact: full_message='{{message1}},{{message2}} from {{ansible_user}}'    

    - debug: 
        var: full_message
=================================================================
