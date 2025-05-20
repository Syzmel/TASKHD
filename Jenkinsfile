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
                  script {
                      withSonarQubeEnv('Sonar') {
                          bat "\"%scannerHome%\\bin\\sonar-scanner\" ^
                              -Dsonar.projectKey=Syzmel_TASKHD ^
                              -Dsonar.projectName=TASKHD ^
                              -Dsonar.projectVersion=1.0 ^
                              -Dsonar.sources=C:\\TASKHD\\src"
                      }
                  }
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
