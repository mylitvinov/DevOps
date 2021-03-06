
pipeline {
    agent any
    options {
      timestamps()
    }
    parameters {
      string(name: 'FIO', defaultValue: '', description: 'ФИО')
      string(name: 'MAIL', defaultValue: '', description: 'Введите вашу почту')
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
                  
                steps {
                    mail (
                      to: "$MAIL", 
                      subject: "SBER_TEST_FROM_JENKINS", 
                      body: "$FIO принят"
                    )
                    echo "Сообщение отправлено на почту: $MAIL "
            }          
          }
      } 
      
      post {
          aborted { 
            echo "Отказано"
                 }
          } 
}

