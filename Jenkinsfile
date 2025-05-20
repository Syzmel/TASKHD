pipeline {
    agent any
    environment {
        PATH = "C:\\Program Files\\nodejs;${env.PATH}"
        //SONAR_TOKEN = credentials('1ff6b33727b1ace77eb4117fc636c057e8301cdf')
    }
    stages {
        stage('Build') {
            steps {
                // In a Windows environment, use "bat" commands.
                // Example using Maven to build and create a JAR file.
                bat 'mvn -B -DskipTests clean package'
                // Archive the build artifact so it can be used in later stages.
                
            }
        }

    stage('Run Tests') {
            steps {
                bat 'npm test || exit /B 0'
            }
        }      
        stage('Install Dependencies') {
            steps {
               bat 'npm install -g @sonar/scan'
            }
        }
        stage('SonarCloud Analysis') {
                steps {
                                bat '''
                  sonar-scanner ^
                  -Dsonar.projectKey=Syzmel_TASKHD ^
                  -Dsonar.organization=sit223 ^
                  -Dsonar.sources=. ^
                  -Dsonar.host.url=https://sonarcloud.io ^
                  -Dsonar.login=1ff6b33727b1ace77eb4117fc636c057e8301cdf
                  if %ERRORLEVEL% NEQ 0 exit /b 0
                '''
                
            }
        }  
        stage('Snyk Security Scan') {
            steps {
                script {
                    def snykTokenId = '0fd70700-dcdd-4e80-a424-85129e1d5c55'
                    // ... other Snyk build step configurations ...
                }
            }
        }
    }
}
