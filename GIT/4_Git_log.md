Самая простая аналитика выполняется командой git log. Она показывает список всех выполненных коммитов, отсортированных по дате добавления (сверху самые последние):

git log

# Ниже неполный вывод истории проекта

commit 5120bea3e5528c29f8d1da43731cbe895892eb6d
Author: tirion <tirion@got.com>
Date:   Thu Sep 17 18:04:19 2020 -0400

    add new content

commit e6f625cf8433c8b1f1aaed58cd2b437ec8a60f27
Author: tirion <tirion@got.com>
Date:   Thu Sep 17 16:14:09 2020 -0400

    add INFO.md

commit 273f81cf2117044f1973ea80ce1067a94bea3f80
Author: tirion <tirion@got.com>
Date:   Thu Sep 17 16:08:39 2020 -0400

    remove NEW.md

# Этот вывод показывается через пейджер
Из этого вывода мы можем узнать кто, когда и какие коммиты делал. Если коммиты оформлены хорошо, то по их описанию уже многое понятно. Оформление коммитов — отдельная тема, которую мы рассмотрим позже.

У команды git log есть полезный флаг -p, который сразу выводит диф для каждого коммита:

git log -p
# Тут все коммиты с полным дифом
# Мотать вперед f, мотать назад b
# Выйти из режима просмотра — q

====================================================================
