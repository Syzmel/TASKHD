pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
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
                  -Dsonar.login=ae3e0cd85e60d4e43416a9ebf03d827702acd046
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
