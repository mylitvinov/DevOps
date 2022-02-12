Берем переменные из команды:

ansible all -m setup
===========================================================

Переименовываем файл:

mv index.html index.j2

================================================================
Редактируем файл расширения .j2, вносим переменные формата:
{{ variable }}

================================================

Делаем изменения в playbook (template вместо copy):

- name: Generate index.html file
  template: src={{source_file}}/index.j2
        dest={{destin_file}}/index.html
        mode=0555