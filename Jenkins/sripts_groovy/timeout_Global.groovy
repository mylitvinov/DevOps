pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS') 
    }
    stages {
        stage('Example') {
            steps {
                echo 'Hello World'
            }
        }
    }
}

// Указание глобального тайм-аута выполнения в один час, после которого Jenkins прервет выполнение конвейера.
