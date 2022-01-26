Изменённые файлы в рабочей директории
Для отмены изменений в таких файлах используется команда git restore. Причём git сам напоминает об этом при проверке статуса:

echo 'new text' > INFO.md
git status

On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  # Ниже написано, как отменить изменение
  (use "git restore <file>..." to discard changes in working directory)
    modified:   INFO.md

# Отменяем
git restore INFO.md

=====================================================================

Файлы, добавленные для коммита
С файлами, подготовленными к коммиту, можно поступить по-разному. Первый вариант — отменить изменения совсем, второй — переместить изменения из индекса в рабочую директорию. Второе полезно в том случае, если изменения нам нужны, но мы не хотим их коммитить сейчас.

echo 'new text' > INFO.md
git add INFO.md
git status

On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
    modified:   INFO.md
И здесь снова помогает git. При выводе статуса он показывает нужную нам команду для перевода изменений в рабочую директорию:

git restore --staged INFO.md
git status

On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
    modified:   INFO.md
Теперь, если нужно, можно выполнить git restore и окончательно отменить изменения в выбранных файлах.
