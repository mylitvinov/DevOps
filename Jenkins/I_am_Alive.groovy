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

           post {
             aborted {
  .              steps {
                      echo "Отказано"
                  }
              }
         }    
        //     stage('Example stage') {
        //       steps {
        //         echo '''
        //           WTF
        //           COOL
        //           DevOps
        //         '''
        //      }
        // }
     }
}   
