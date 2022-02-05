pipeline {
    agent any
    stages {
        stage("1-Build") {
            steps {
                echo 'Start of stage Build'
                echo 'Building...'
                sh 'ls -la'
                echo 'End of stage Build'
            }
        }
        stage("2-Test") {
            steps {
                echo 'Start of stage Test'
                echo 'Testing...'
                sh '''
                 echo 'Line 1'
                 echo 'Line 2'
                 echo 'Line 3'
                '''
                echo 'End of stage Test'
            }
        }
        stage("3-Deploy") {
            steps {
                echo 'Start of stage Deploy'
                echo 'Deploying...'
                echo 'End of stage Deploy'
            }
        }
        
    }
}