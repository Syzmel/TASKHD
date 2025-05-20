pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo 'Building the application...'
                bat 'mvn clean install -Dmaven.test.skip=true'
                //archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    
        stage('Selenium Tests') {
            when {
                expression { fileExists('src/test/selenium') } // Run only if Selenium tests exist
            }
            steps {
                echo "Running Selenium tests..."
                bat 'mvn verify' // or run separate selenium profile
            }
            post {
                always {
                    junit '**/target/failsafe-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline completed."
        }
    }
}
