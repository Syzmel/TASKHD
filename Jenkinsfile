pipeline {
    agent any
    tools {
        sonarQube 'Sonar'
    }
    environment {
        PATH = "C:\\Program Files\\nodejs;${env.PATH}"
        //SONAR_TOKEN = credentials('1ff6b33727b1ace77eb4117fc636c057e8301cdf')
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'npm test || exit /B 0'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('Sonar') {
                            bat '''
                            sonar-scanner ^
                            -Dsonar.projectKey=Syzmel_TASKHD ^
                            -Dsonar.projectName=TASKHD ^
                            -Dsonar.projectVersion=1.0 ^
                            -Dsonar.sources=C:\\TASKHD\\src ^
                         '''
                    }
                }
            }
        }

        stage('Snyk Security Scan') {
            steps {
                script {
                    bat "snyk test --org=your-org-name --token=0fd70700-dcdd-4e80-a424-85129e1d5c55"
                }
            }
        }
    }
}
