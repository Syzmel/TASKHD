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
                withCredentials([string(credentialsId: '1c4150806224e585e8db183ab45af7b83a4341f530f70175b64d945ea6b0fd03')]) {
                    bat '''
                    set AWS_ACCESS_KEY_ID=<Your_Access_Key>
                    set AWS_SECRET_ACCESS_KEY=%AWS_SECRET%
                    aws elasticbeanstalk update-environment --application-name "Ardavan" ^
                    --environment-name "Ardavan-env" --region "Asia Pacific(Sydney)"
                    '''
                }
            }
        }
    }
}
