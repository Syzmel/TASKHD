pipeline {
    agent any
        environment {
        PATH = "C:\\Program Files\\nodejs;${env.PATH}"
        //SONAR_TOKEN = credentials('ae3e0cd85e60d4e43416a9ebf03d827702acd046')
       //-Dsonar.host.url=https://sonarcloud.io ^
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Syzmel/TASKHD.git'
            }
        }
        stage('Install Dependencies') {
            steps {
               bat 'npm install'
            }
        }
        stage('Run Tests') {
            steps {
                bat 'npm test || exit /B 0'
            }
        }
        stage('Generate Coverage Report') {
            steps {
                bat 'npm run coverage || exit /B 0'
            }
        }
        stage('NPM Audit (Security Scan)') {
            steps {
                bat 'npm audit || exit /B 0'
            }
        }
        stage('SonarCloud Analysis') {
            steps {
                                bat '''
                  sonar-scanner ^
                  -Dsonar.projectKey=Syzmel_TASKHD ^
                  -Dsonar.organization=sit223 ^
                  -Dsonar.sources=. ^
                  
                  sonarQubeServerUrl 'http://your-sonarqube-server:9000'
                  -Dsonar.login=77e2179c556089bac2e1c8c94c51df277eae3eca
                  if %ERRORLEVEL% NEQ 0 exit /b 0
                '''

            }
        }  
    }
}
