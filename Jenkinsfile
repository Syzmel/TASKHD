pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                echo "Running automated unit tests..."
                bat 'mvn -q test'
            }
            post {
                always {
                    echo "Publishing JUnit test results..."
                    bat 'dir /s /b target\\surefire-reports'
                    junit '**/target/surefire-reports/*.xml'
                }
                success {
                    echo "Tests passed."
                }
                failure {
                    echo "Some tests failed."
                }
            }
        }

        // OPTIONAL: UI/integration tests with Selenium
        stage('Selenium Tests') {
            when {
                expression { fileExists('src/test/selenium') } // Run only if Selenium tests exist
            }
            steps {
                echo "Running Selenium tests..."
                bat 'mvn verify' // or run separate selenium profile
            }
            post {
                always {
                    junit '**/target/failsafe-reports/*.xml'
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
