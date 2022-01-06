
pipeline {
    agent any
    
    stages{
        stage('Hello, SBER') {
            steps {
                echo "Привет, СБЕР"
            }
          } 
          
        stage('What is your name?') {
            input {
                message "Введите ваши ФИО и нажмите ОК"
                ok "ОК"
                parameters {
                    string(name: 'FIO', defaultValue: '', description: 'ФИО')
                }
            }
            steps {
                echo "Меня зовут $FIO"
            }
            
        }
        stage('I want to work for you') {
            steps {
                echo "Хочу у вас работать"
            }
        }
        stage('Make choice') {
            input {
                message "Принимаем на работу?"
                ok "Принять на работу"
                  }
            steps {
                echo "Принят"
            }
          
       }
   
   }
}

