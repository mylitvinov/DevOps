Развёртывания Kubernetes
Как только вы запустили кластер Kubernetes, вы можете развернуть свои контейнеризированные приложения в него. Для этого вам нужно создать конфигурацию развёртывания (Deployment) в Kubernetes. Развёртывание сообщает Kubernetes, как создавать и обновлять экземпляры вашего приложения. После создания развёртывания ведущий узел Kubernetes планирует запустить экземпляры приложения на отдельных узлах в кластере.

Когда экземпляры приложения были созданы, контроллер развёртывания Kubernetes непрерывно отслеживает их. Если узел, на котором размещен экземпляр, вышёл из строя или был удалён, контроллер развёртывания вместо этого экземпляра использует экземпляр на другом узле в кластере. Этот процесс представляет собой механизм самовосстановления, обеспечивающий работу кластера в случае возникновения аппаратных неисправностей либо технических работ.

До того, как появились системы оркестровки, для запуска приложений обычно использовались установочные скрипты, которые не перезапускались после сбоя компьютера. Создавая экземпляры приложений и поддерживая их работу на нескольких узлах, развёртывания Kubernetes коренным образом отличаются в плане управления приложениями.

====================================================================

Вы можете создавать и управлять развёртыванием через командный инструмент Kubernetes под названием Kubectl. Kubectl использует API Kubernetes для работы с кластером. В этом модуле вы узнаете про наиболее используемые команды Kubectl, необходимые для создания развёртываний, которые будут запускать приложения в кластере Kubernetes.

При создании развертывания нужно указать образ контейнера приложения и количество запущенных реплик. Впоследствии эти параметры можно изменить. В модулях 5 и 6 рассказывается про масштабирование и обновление развертываний.

Чтобы приложение запускалось в Kubernetes, оно должно быть упаковано в один из поддерживаемых форматов контейнеров

В качестве первого развёртывания будем использовать приложение на Node.js, упакованное в Docker-контейнер. Следуя инструкциям в руководстве "Привет, Minikube" вы сможете создать такое приложение Node.js и поместить его в контейнер.

Теперь, когда познакомились с развёртываниями, можно начать онлайн-урок, где вы развернёте своё первое приложение!

==================================================================

kubectl basics
Like minikube, kubectl comes installed in the online terminal. Type kubectl in the terminal to see its usage. The common format of a kubectl command is: kubectl action resource. This performs the specified action (like create, describe) on the specified resource (like node, container). You can use --help after the command to get additional info about possible parameters (kubectl get nodes --help).

Check that kubectl is configured to talk to your cluster, by running the kubectl version command:

kubectl version

OK, kubectl is installed and you can see both the client and the server versions.

To view the nodes in the cluster, run the kubectl get nodes command:

kubectl get nodes

Here we see the available nodes (1 in our case). Kubernetes will choose where to deploy our application based on Node available resources.

=======================================================

Deploy our app
Let’s deploy our first app on Kubernetes with the kubectl create deployment command. We need to provide the deployment name and app image location (include the full repository url for images hosted outside Docker hub).

kubectl create deployment kubernetes-bootcamp --image=gcr.io/google-samples/kubernetes-bootcamp:v1

Great! You just deployed your first application by creating a deployment. This performed a few things for you:

searched for a suitable node where an instance of the application could be run (we have only 1 available node)
scheduled the application to run on that Node
configured the cluster to reschedule the instance on a new Node when needed
To list your deployments use the get deployments command:

kubectl get deployments

We see that there is 1 deployment running a single instance of your app. The instance is running inside a Docker container on your node.

=====================================================================

View our app
Pods that are running inside Kubernetes are running on a private, isolated network. By default they are visible from other pods and services within the same kubernetes cluster, but not outside that network. When we use kubectl, we're interacting through an API endpoint to communicate with our application.

We will cover other options on how to expose your application outside the kubernetes cluster in Module 4.

The kubectl command can create a proxy that will forward communications into the cluster-wide, private network. The proxy can be terminated by pressing control-C and won't show any output while its running.

We will open a second terminal window to run the proxy.

echo -e "\n\n\n\e[92mStarting Proxy. After starting it will not output a response. Please click the first Terminal Tab\n"; 
kubectl proxy
We now have a connection between our host (the online terminal) and the Kubernetes cluster. The proxy enables direct access to the API from these terminals.

You can see all those APIs hosted through the proxy endpoint. For example, we can query the version directly through the API using the curl command:

curl http://localhost:8001/version

Note: Check the top of the terminal. The proxy was run in a new tab (Terminal 2), and the recent commands were executed the original tab (Terminal 1). The proxy still runs in the second tab, and this allowed our curl command to work using localhost:8001.

If Port 8001 is not accessible, ensure that the kubectl proxy started above is running.

The API server will automatically create an endpoint for each pod, based on the pod name, that is also accessible through the proxy.

First we need to get the Pod name, and we'll store in the environment variable POD_NAME:

export POD_NAME=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')
echo Name of the Pod: $POD_NAME

You can access the Pod through the API by running:

curl http://localhost:8001/api/v1/namespaces/default/pods/$POD_NAME/

In order for the new deployment to be accessible without using the Proxy, a Service is required which will be explained in the next modules.