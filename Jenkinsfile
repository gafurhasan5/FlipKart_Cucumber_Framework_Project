pipeline {
    agent any
     tools{
       maven "MAVEN_HOME"  
     }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/gafurhasan5/FlipKart_Cucumber_Framework_Project.git'

                // Run the build on a Unix agent. You must have Maven installed.
               // sh 'mvn -Dmaven.test.failure.ignore=true clean package'

                // To run Maven on a Windows agent, use
                bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }

            post {
               
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
