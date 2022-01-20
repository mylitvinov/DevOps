pipeline {
         agent any
         stages {
                 stage('2') {
                 steps {
                     echo 'Hi, itisgood. Starting to build the App.'
                 }
                 }
                 stage('Test') {
                 steps {
                    input('Do you want to proceed?')
                 }
                 }
                 stage('Deploy') {
                 parallel {
                            stage('Deploy start ') {
                           steps {
                                echo "Start the deploy .."
                           }
                           }
                            stage('Deploying now') {
                            agent {
                                    docker {
                                            reuseNode true
                                            image 'nginx'
                                           }
                                    }

                              steps {
                                echo "Docker Created"
                              }
                           }
                           }
                           }
                 stage('Prod') {
                     steps {
                                echo "App is Prod Ready"
                              }

              }
          }
}

//Блок Pipeline состоит из всех инструкций по сборке, тестированию и доставке программного обеспечения. Это ключевой компонент пайплайна Jenkins
// agent назначается для выполненияпайплайна на узле и выделения рабочего пространства для пайплайна.
// stage – это блок, в котором есть шаги для сборки, тестирования и развертывания приложения. Stage используются для визуализации процессовпайплайна Jenkins.
// step – это отдельная задача, которую необходимо выполнить, например, создать каталог, запустить образ докера, удалить файл и т. д.
// Groovy код, показанный выше, я использую для JenkinsFile.
// Любой доступный агент получает назначение в pipeline.
// Затем я определяю этап Build' и выполняю простой шаг echo.
// Затем я определил стадию Test, где шаг спрашивает, хотите ли вы продолжить или нет.
// После этого я создал этап Deploy, в котором параллельно работают еще два этапа.
// Этап Deploy start содержит шаг с командой echo, а в Deploying now теперь есть шаг, который тащит образ узла Nginx на узле.
// Наконец, есть стадия Prod с простым шагом echo.

