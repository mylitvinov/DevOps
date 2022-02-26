pipeline {
    agent {
      any
    }
    parameters {
      string(name: 'MY_NAME', defaultValue: '', description: 'ФИО')
      string(name: 'E_MAIL', defaultValue: '', description: 'Введите вашу почту')

    }

    stages {
        stage('Hi') {
            steps {
                echo "Привет Компания"
            }
        }
        stage('My name') {
            steps {
                echo "Меня зовут ${params.MY_NAME}"
            }
        }
        stage('Work') {
            steps {
                echo "Хочу у вас работать"
            }
        }
        stage('Approve') {
			steps {
				script {
						 def ANSWER = input(
								message: 'Принять?',
								parameters: [
										[$class: 'ChoiceParameterDefinition',
										 choices: ['Отказать','Принять на работу'].join('\n'),
										 name: '',
										 description: 'Выберите результат']
								])

						echo "The answer is: ${ANSWER}"

						if( "${ANSWER}" == "Принять на работу"){
							
						} else {
							  autoCancelled = true
							  error('Отказ')
						}
				}
			}
		}
      //   stage('Mail') {
      //       steps {
			// 	emailext body: "${params.MY_NAME} принят в компанию ",
			// 		subject: "Результат собеседования",
			// 		to: "${params.E_MAIL}"
			// }
      //   }
    }		
}
