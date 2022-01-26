Неотслеживаемые файлы
Самая простая ситуация. Вы добавили новые файлы в репозиторий (или сгенерировали их как-то) и поняли, что они вам не нужны. В этом случае можно выполнить очистку:

mkdir one
touch two

git status

On branch main
Your branch is up to date with 'origin/main'.

# Пустые директории в git не добавляются в принципе.
# Физически директория one находится в рабочей директории,
# но её нет в git, и он её игнорирует
Untracked files:
  (use "git add <file>..." to include in what will be committed)
    two

# Выполняем очистку
# -f – force, -d – directory
git clean -fd

Removing one/
Removing two

=======================================

