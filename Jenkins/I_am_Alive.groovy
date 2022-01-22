pipeline {
       agent any

       stages {
           stage('Connection test') {
               steps { script {          
                   print  "I am alive!"                
               }}

               input 'Make Choice'
           }
       }    
   }
