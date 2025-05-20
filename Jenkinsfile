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
                // archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Selenium Tests') {
            when {
                expression { fileExists('src/test/selenium') } // Run only if Selenium tests exist
            }
            steps {
                echo "Running Selenium tests..."
                bat 'mvn verify' // Assumes failsafe or profile-based Selenium
            }
            post {
                always {
                    junit '**/target/failsafe-reports/*.xml'
                }
            }
        }

        stage('Code Quality - SonarQube') {
            environment {
                SONAR_SCANNER_OPTS = "-Xmx1024m"
            }
            steps {
                withSonarQubeEnv('MySonarQube') {
                    bat 'mvn sonar:sonar -Dsonar.projectKey=TASKHD -Dsonar.host.url=http://localhost:9000 -Dsonar.login=${ae3e0cd85e60d4e43416a9ebf03d827702acd046}'
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
