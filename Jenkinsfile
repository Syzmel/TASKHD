pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\Program Files\\Maven\\apache-maven-3.9.9\\'
        //SONARQUBE_SERVER = 'http://your-sonarqube-server'
        AWS_CREDENTIALS = '1c4150806224e585e8db183ab45af7b83a4341f530f70175b64d945ea6b0fd03'
        DEPLOY_ENV = 'staging'
    }

    stages {
       stage('Checkout') {
            steps {
                // Pull your project source code from your repository
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo 'Building the application...'
                bat '"%MAVEN_HOME%\\bin\\mvn" clean package'
                //archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run tests using Maven - will execute JUnit tests through the Surefire plugin.
                    if (isUnix()) {
                        sh 'mvn test'
                    } else {
                        bat 'mvn test'
                    }
                }

                // Archive and publish JUnit test results.
                // This ensures that any test failures are captured by Jenkins.
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Code Quality') {
            steps {
                echo 'Running code quality checks...'
                bat '"%MAVEN_HOME%\\bin\\mvn" sonar:sonar -Dsonar.host.url=%SONARQUBE_SERVER%'
            }
        }

        stage('Security') {
            steps {
                echo 'Running security checks...'
                bat '"%MAVEN_HOME%\\bin\\mvn" snyk:test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying application to ${DEPLOY_ENV}..."
                bat 'aws elasticbeanstalk deploy --application your-app --environment ${DEPLOY_ENV}'
            }
        }

        stage('Release') {
            steps {
                echo 'Releasing to production...'
                bat 'aws deploy create-deployment --application-name your-app --deployment-group-name production'
            }
        }

        stage('Monitoring and Alerting') {
            steps {
                echo 'Setting up monitoring...'
                bat 'newrelic-cli install --api-key your-api-key'
                bat 'datadog-agent start'
            }
        }
    }
}
