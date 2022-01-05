
pipeline {
    agent any
    stages {
        stage('Hello, SBER') {
          steps {
            echo 'Привет, СБЕР'
      }
        }
        stage('What is your name?') {
          steps {
            echo "Меня зовут $FIO "
      }
        }
        stage('I want to work for you') {
          steps {
            echo "Хочу у вас рабоать "
      }
        }
        stage('Submit') {
           input {
                message "Принимаем на работу?"
                ok "Принять на работу."
                submitter "Отказать"
              
            }
            steps {
                echo "Поздравляем, ${FIO}, вы приняты."
            }
        }
        
        stage('End') {
           steps {
             echo "Поздравляем, $FIO ."
            }
        }  
    }
}



pipeline {
    agent any
    parameters { string(name: 'FIO', defaultValue: ' ', description: 'Введите ваши ФИО') }
    stages {
        stage('Submit') {
            input {
                message "Принимаем на работу?"
                ok "Принять на работу."
                submitter "Отказать"
              
            }
            steps {
                echo "Поздравляем, ${FIO}, вы приняты."
            }
        }
    }
}