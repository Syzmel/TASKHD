pipeline {
    agent any
    environment {
        // Set SonarQube environment variables if needed
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Syzmel/TASKHD.git'
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
                // Run SonarQube scanner
                withSonarQubeEnv('SonarQube') {
                    bat 'sonar-scanner -Dsonar.projectKey=TASKHD -Dsonar.sources=.' // Adjust according to your language/tools
                }
            }
        }
    }
    post {
        always {
            // Optional: quality gates, reports
        }
    }
}

