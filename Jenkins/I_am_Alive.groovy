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
            stage ('second') {
              post {
                aborted {
  .               steps {
                      echo "Отказано"
                  }
              }
            }
          }
               
 
     }
}   
