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
                //archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    
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
        stage('Code Quality - SonarQube') {
            environment {
                  SONAR_SCANNER_OPTS = "-Xmx1024m"
    }
        steps {
         withSonarQubeEnv('MySonarQube') {
            bat 'mvn sonar:sonar -Dsonar.projectKey=TASKHD -Dsonar.host.url=http://localhost:9000 -Dsonar.login=${SONAR_AUTH_TOKEN}'
          }
      }
   }
}
