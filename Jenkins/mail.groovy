pipeline {
    agent any

    stages {
        stage('Ok') {
            steps {
                echo "Ok"
            }
        }
    }

    post {
        always {
          emailext (
            subject:'Jenkins Build Test for XUSDK', 
            mimeType: 'text/html', 
            to: 'testuser@example.com',
            recipientProviders: [[$class: 'DevelopersRecipientProvider'],[$class: 'RequesterRecipientProvider']], 
            body: 'Testing Jenkins sending an email message after building a job.'
            )
      }
    }
}