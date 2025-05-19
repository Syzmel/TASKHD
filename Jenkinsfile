    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    // Build your application
                }
            }
            stage('Deploy to Staging') {
                steps {
                    awsEBDeploy {
                        applicationName 'Ardavan'
                        environmentName 'Ardavan-env'
                        region 'Asia Pasific(Sydney)'
                        credentialsId '1c4150806224e585e8db183ab45af7b83a4341f530f70175b64d945ea6b0fd03'
                        // Other Elastic Beanstalk configurations
                    }
                }
            }
        }
    }
