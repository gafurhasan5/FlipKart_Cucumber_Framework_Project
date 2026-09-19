pipeline {

    agent any

    triggers {
        // Run automatically when GitHub push webhook is received
        githubPush()

        // Nightly build at 2:00 AM
        cron('0 2 * * *')
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Running Maven Cucumber/TestNG tests...'

                bat 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Test Results') {
            steps {
                echo 'Publishing test results...'

                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }

    post {

        always {
            echo 'Build completed.'
        }

        success {
            echo 'BUILD SUCCESSFUL - All tests passed.'
        }

        failure {
            echo 'BUILD FAILED - Please check the Jenkins console and test reports.'
        }
    }
}