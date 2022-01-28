
pipeline {
    agent any
    parameters {
      string(name: 'FIO', defaultValue: '', description: 'ФИО')
    }
    stages{
        stage('1: Hello, SBER') {
            steps {
                echo "Привет СБЕР"
            }
          } 
          
        stage('2: What is your name?') {
            steps {
                echo "Меня зовут $FIO"
            }
            
        }
        stage('3: I want to work for you') {
            steps {
                echo "Хочу у вас работать"
            }
        }
        stage('4: Make choice') {
            input {
                message "Принимаем на работу?"
                     ok "Принять на работу"
                  }
                steps{ 
                   echo "Отлично"
          }  
        }
             
        stage('5: END') {
            // input {
            //     message "Введите вашу почту"
            //     ok "Отправить"
            //     parameters {
            //         string(name: 'MAIL', defaultValue: '', description: 'email')
            //     }
            //       }
            steps {
                echo "Сообщение отправлено на почту: MAIL "
                echo "$FIO принят"
            }          
          }
      } 
      
      post { 
          aborted { 
            echo "Отказано"
                 }
               } 
}

