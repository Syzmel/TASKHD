pipeline {
    agent any

    stages {

        stage('Deploy') {
            steps {
                withAWS(credentials: '1c4150806224e585e8db183ab45af7b83a4341f530f70175b64d945ea6b0fd03') {
                    awsebDeployment(
                      applicationName: 'Ardavan',
                      environmentName: 'Ardavan-env',
                      region: 'Asia Pasific(Sydney)',
                      sourcePath: 'http://ardavan-env.eba-bxeqxxzd.ap-southeast-2.elasticbeanstalk.com/',
                      applicationVersion: "1.0.0" // Or use a dynamic version
                    )
                }
            }
        }
    }
}
