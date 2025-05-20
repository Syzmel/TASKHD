pipeline {
    agent any


    environment {
        BUILD_DIR = 'target'
        ARTIFACT_NAME = 'taskhd.jar' // Customize if your output JAR is named differently
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Syzmel/TASKHD.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building project with Maven..."
                bat 'mvn clean package -DskipTests' // Windows-based system
            }
            post {
                success {
                    echo "Build successful!"
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
                failure {
                    echo "Build failed!"
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline finished."
        }
    }
}
