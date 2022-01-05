
pipeline {
    agent any
  
    stages {
        stage('First step') {
      steps {
        echo 'Привет, СБЕР'
      }
        }
        stage('Second step') {
      steps {
        echo "Меня зовут $FIO "
      }
        }
        stage('Third step') {
      steps {
        echo "Хочу у вас рабоать "
      }
        }
    }
}
