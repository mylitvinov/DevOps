Все сетевые адаптеры

ifconfig

----

docker0: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        inet 172.17.0.1  netmask 255.255.0.0  broadcast 172.17.255.255 
        inet6 fe80::42:76ff:fe7b:f5b6  prefixlen 64  scopeid 0x20<link>
        ether 02:42:76:7b:f5:b6  txqueuelen 0  (Ethernet)
        RX packets 378  bytes 20797 (20.7 KB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 1149  bytes 2383661 (2.3 MB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

=======================================================

docker0 мостовая сеть, привязанная к enp0s3 нашей сетевой карте

====================================================

Вывести список всех сетевых команд

docker network -h

==========================================

Список вскх сетей на хосте с Docker

docker network -ls
====================================

Детальная инфа по сети

docker network inspect [NAME]

===========================================

Создание сети

docker network create br00
===========================================

Удаление сети

docker network rm br00
===========================================

Удаление всех неиспользуемых сетей

docker network prune
===========================================

Создание контейнера без сети

docker container run -d --name network-test03 -p 8081:80 nginx

==================================================

Добавление контейнера к сети

docker network create br01

docker network connect br01 network-test03

================================================
Инспектирование контейнера для просмотра сетей

docker container inspect network-test03

===============================================

Удаление network-test03 из сети br01

docker network disconnect br01 network-test03





