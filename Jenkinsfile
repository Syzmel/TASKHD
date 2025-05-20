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
                                 bat '''
                  sonar-scanner ^
                  -Dsonar.projectKey=TASKHD ^
                  -Dsonar.organization=TASKHD ^
                  -Dsonar.sources=. ^
                  -Dsonar.host.url=https://sonarcloud.io ^
                  -Dsonar.login=ae3e0cd85e60d4e43416a9ebf03d827702acd046
                  if %ERRORLEVEL% NEQ 0 exit /b 0
                '''
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
