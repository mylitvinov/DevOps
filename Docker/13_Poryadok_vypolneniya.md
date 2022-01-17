cd docker_images
mkdir centos-conf
cd centos-conf

оздание Dockerfile:

vi Dockerfile


Содержимое Dockerfile:

# Creates a CentOS image that uses cloud_user as a non-privileged user
FROM centos:latest
RUN mkdir -p ~/new-dir1
RUN useradd -ms /bin/bash cloud_user 
RUN mkdir -p ~/new-dir1
RUN mkdir -p ~/etc/myconf
RUN echo "Some config data" >> /etc/myconf/my.conf
USER cloud_user


Сборка нового образа:

docker image build -t centos7/myconf:v1 .

