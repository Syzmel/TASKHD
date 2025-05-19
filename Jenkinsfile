pipeline {
    agent any
    stages {
         stage('Snyk Security Scan') {
            steps {
                script {
                    def snykTokenId = '0fd70700-dcdd-4e80-a424-85129e1d5c55'
                    // ... other Snyk build step configurations ...
                }
            }
        }
         stage('Deploy to Staging') {
                steps {
                    awsEBDeploy {
                        applicationName 'Ardavan'
                        environmentName 'Ardavan-env'
                        region 'your-aws-region'
                        credentialsId '1c4150806224e585e8db183ab45af7b83a4341f530f70175b64d945ea6b0fd03'
                        // Other Elastic Beanstalk configurations
                    }
                }
            }
    }
}

