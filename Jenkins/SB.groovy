
pipeline {
    agent any
    
    stages{
        stage('1: Hello, SBER') {
            steps {
                echo "Привет СБЕР"
            }
          } 
          
        stage('2: What is your name?') {
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
            steps {
                echo "Принят"
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
                echo "Сообщение отправлено на почту: /"$MAIL/" "
                echo "$FIO принят"
            }
          
       }
  }
}

