pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url:'https://github.com/Syzmel/TASKHD.git'
            }
        }
        stage('Build') {
            steps {
                // Your build commands, e.g., Maven/Gradle
                bat 'echo Building...'
            }
        }
        stage('Code Quality Analysis') {
            steps {
                                bat '''
                  sonar-scanner ^
                  -Dsonar.projectKey=Syzmel_TASKHD ^
                  -Dsonar.organization=sit223 ^
                  -Dsonar.sources=. ^
                  
                  -Dsonar.login=1ff6b33727b1ace77eb4117fc636c057e8301cdf
                  if %ERRORLEVEL% NEQ 0 exit /b 0
                '''
                }
            }
        }
    }

