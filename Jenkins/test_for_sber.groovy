
pipeline {
    agent any
    options {
        timestamps()
    }
    stages {
        stage('First step') {
      steps {
        echo 'Привет СБЕР'
      }
        }
        stage('Second step') {
      steps {
        echo "Меня зовут $FIO "
      }
        }
    }
}
