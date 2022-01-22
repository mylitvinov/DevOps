pipeline {
       agent any

        stages {
            stage('Connection test') {
                input {
                   message "Make Choice"
                   ok "OK"
               }
                steps { script {          
                   print  "I am alive!"                
               }}
           }    
            stage('Example stage') {
              steps {
                echo '''
                  WTF
                  COOL
                  DevOps
                '''
             }
        }
     }
}   
