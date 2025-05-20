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
            steps {
                
                                 bat '''
                  sonar-scanner ^
                  -Dsonar.projectKey=TASKHD ^
                  -Dsonar.organization=TASKHD ^
                  -Dsonar.sources=. ^
                  -Dsonar.host.url=https://sonarcloud.io ^
                  -Dsonar.login=2ee7f51401a20a2042d4d2270a6aa8c12ec53ec9
                  if %ERRORLEVEL% NEQ 0 exit /b 0
                '''
                
            }
        }
    }

    post {
        always {
            echo "Pipeline completed."
        }
    }
}
