pipeline {
    agent any

    stages {
        stage('Deploy to Elastic Beanstalk') {
            steps {
                script {
                       echo "Deploying to AWS Elastic Beanstalk..."
                       bat "deploy_to_eb.bat"
                }
            }
        }
    }
}
