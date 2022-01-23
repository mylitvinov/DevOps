Задача Kubernetes заключается в координации кластера компьютеров, работающего как одно целое. Абстрактные объекты в Kubernetes позволяют развертывать контейнеризированные приложения в кластер, не привязывая их к отдельным машинам. Для использования этой новой модели развертывания, приложения должны быть подготовлены так, чтобы они не зависели от конкретных хостов, т.е. они должны быть упакованы в контейнеры. Приложения в контейнерах более гибки и доступны, чем в предыдущих моделях развертывания, когда приложения устанавливались непосредственно на конкретные машины в виде пакетов, тесно связанных с хостом. Kubernetes автоматизирует распределение и выполнение контейнеров приложений для запуска в кластере более эффективным образом. 
Kubernetes — это платформа с открытым исходным кодом, готовая к промышленной эксплуатации.

Кластер Kubernetes состоит из двух типов ресурса:

Мастер (ведущий узел) управляет кластером
Рабочие узлы — машины, на которых выполняются приложения

=============================================================

Мастер отвечает за управление кластером. Мастер координирует все процессы в кластере, такие как планирование выполнения приложений, сохранение требуемого состояния приложений, а также их масштабирование и обновление.

Узел — это виртуальная машина или физический компьютер, который выполняет роль рабочего узла в кластере Kubernetes. У каждого узла есть Kubelet — агент, управляющий узлом и взаимодействующий с ведущим узлом Kubernetes. Узел также имеет инструменты для выполнения контейнерных операций, например, Docker или rkt. Кластер Kubernetes в промышленном окружении должен состоять как минимум из трёх узлов.

Ведущие узлы управляют кластером и узлами, которые используются для запуска приложений.

При развертывании приложений в Kubernetes вы сообщаете ведущему узлу запускать контейнеры приложений. Ведущий узел планирует выполнение контейнеров на узлах кластера. Узлы взаимодействуют с ведущим узлом посредством API Kubernetes, который предлагает ведущий узел. Кроме этого, конечные пользователи могут напрямую использовать API Kubernetes для работы с кластером.

Kubernetes-кластер может быть развернут на физических или виртуальных машинах. Чтобы начать работать с Kubernetes, можно использовать Minikube. Minikube — это упрощённая реализация Kubernetes, которая создает виртуальную машину на вашем локальном компьютере и разворачивает простой кластер с одним узлом. Minikube доступен для Linux, macOS и Windows. В CLI-инструменте Minikube есть основные операции для инициализации кластера, включая запуск, завершение, просмотра состояния и удаления кластера. Однако в этом уроке вы будете использовать онлайн-терминал с уже установленным Minikube.

Теперь, когда вы знаете, что такое Kubernetes, можно перейти к онлайн-уроку, где вы запустите ваш первый кластер!

===================================================================

Cluster up and running
We already installed minikube for you. Check that it is properly installed, by running the minikube version command:

minikube version

OK, we can see that minikube is in place.

Start the cluster, by running the minikube start command:

minikube start

Great! You now have a running Kubernetes cluster in your online terminal. Minikube started a virtual machine for you, and a Kubernetes cluster is now running in that VM.

===================================================

Cluster version
To interact with Kubernetes during this bootcamp we’ll use the command line interface, kubectl. We’ll explain kubectl in detail in the next modules, but for now, we’re just going to look at some cluster information. To check if kubectl is installed you can run the kubectl version command:

kubectl version

OK, kubectl is configured and we can see both the version of the client and as well as the server. The client version is the kubectl version; the server version is the Kubernetes version installed on the master. You can also see details about the build.

============================================================

Cluster details
Let’s view the cluster details. We’ll do that by running kubectl cluster-info:

kubectl cluster-info

During this tutorial, we’ll be focusing on the command line for deploying and exploring our application. To view the nodes in the cluster, run the kubectl get nodes command:

kubectl get nodes

This command shows all nodes that can be used to host our applications. Now we have only one node, and we can see that its status is ready (it is ready to accept applications for deployment).
=====================================================================