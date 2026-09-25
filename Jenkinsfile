pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/gafurhasan5/FlipKart_Cucumber_Framework_Project.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
        }
    }

    post {
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
        }
    }
}
