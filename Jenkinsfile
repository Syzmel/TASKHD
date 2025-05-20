pipeline {
    agent any

    stages {
        stage('SonarQube Analysis') {
            steps {
                                           bat '''
                            sonar-scanner ^

                         '''
            }
        }

        stage('Snyk Security Scan') {
            steps {
                script {
                    bat "snyk test --org=your-org-name --token=0fd70700-dcdd-4e80-a424-85129e1d5c55"
                }
            }
        }
    }
}
