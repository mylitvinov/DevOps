pipeline {
    agent any
    stages {
        stage('Example') {
            options {
                timeout(time: 1, unit: 'HOURS') 
            }
            steps {
                echo 'Hello World'
            }
        }
    }
}

// Указание тайм-аута выполнения в один час для Exampleэтапа, после которого Jenkins прервет выполнение конвейера.
