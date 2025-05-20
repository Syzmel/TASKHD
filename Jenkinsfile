pipeline {
    agent any

    stages {
        stage('SonarQube Analysis') {
            steps {
                                           bat '''
                            sonar-scanner ^
                            -Dsonar.projectKey=Syzmel_TASKHD ^
                            -Dsonar.projectName=TASKHD ^
                            -Dsonar.projectVersion=1.0 ^
                            -Dsonar.sources=C:\\TASKHD\\ ^
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
