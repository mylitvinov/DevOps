Stash—
Введение в Git
Представьте себе ситуацию. Вы работаете над какой-то важной задачей и исправили довольно много файлов. В этот момент появляется срочная задача — сделать какое-то изменение в исходном коде, не связанное с тем, над чем вы сейчас работаете. Ваши изменения ещё не готовы и они не должны попасть в репозиторий. Что делать?

В самом простом случае, если ваши изменения не пересекаются с изменениями по срочной задаче, вы можете внести исправления, добавить их в индекс, закоммитить и запушить. Но обычно это неудобно и не всегда возможно. А если изменения нужно делать в тех файлах, с которыми вы работаете прямо сейчас?

Подобная ситуация у опытных разработчиков встречается регулярно и, к счастью, она легко решается. В git существует набор команд, позволяющий «прятать» изменения в рабочей директории и восстанавливать их при необходимости. Попробуем:

touch FILE.md
git add FILE.md
git status

On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
    new file:   FILE.md

# Прячем файлы. После этой команды пропадут все изменённые файлы
# независимо от того, добавлены они в индекс или нет
git stash

Saved working directory and index state WIP on main: e7bb5e5 update README.md

git status

On branch main
Your branch is up to date with 'origin/main'.

nothing to commit, working tree clean
git stash не удаляет файлы, они попадают в специальное место внутри директории .git «на сохранение». Эта команда не трогает новые файлы, так как они ещё не являются частью репозитория.

git stash

После выполнения всех нужных изменений на чистой рабочей директории можно вернуть спрятанные изменения с помощью команды git stash pop:

# Восстанавливаем
git stash pop

On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
    new file:   FILE.md

Dropped refs/stash@{0} (b896d4a0126ef4409ede63857e5d996953fe75c5)

# Проверяем
git status

On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
    new file:   FILE.md
Файлы вернулись в том виде, в котором они попали в стеш (stash).

Stash в Git работает по принципу стека. Он позволяет сохранить внутрь любое количество изменений и восстановить их в обратном порядке:

git stash

# изменяем файлы
git stash

# Вернутся последние изменения
git stash pop

# Вернутся предпоследние изменения
git stash pop