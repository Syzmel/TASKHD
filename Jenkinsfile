pipeline {
    agent any 

    stages {

        stage('Test (Selenium)') {
            steps {
                // Start the application in background for testing
                // (Assumes the app listens on localhost:8080)
                bat 'start /B cmd /C "java -jar target\\myapp.jar --server.port=8080"'
                // Give the app time to start up
                sleep time: 30, unit: 'SECONDS'
                // Run Selenium integration tests (e.g. via Maven or direct invocation)
                bat 'mvn test -Dtest=ui.* -Dbrowser=chrome'
                // Stop the background app (force kill)
                bat 'taskkill /IM java.exe /F || echo "Server stopped."'
            }
        }
        stage('Code Analysis') {
            steps {
                // SonarQube static analysis (using configured SonarQube server)
                withSonarQubeEnv('SonarQube-Server') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        stage('Quality Gate') {
            steps {
                // Wait for SonarQube quality gate result (optional; requires webhook)
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('Security Scan') {
            steps {
                // OWASP Dependency-Check vulnerability scan
                dependencyCheck additionalArguments: '--project "MyApp" --scan . --format XML', odcInstallation: 'OWASP Dependency-Check'
                // Publish Dependency-Check report and fail on high vulnerabilities
                dependencyCheckPublisher pattern: 'dependency-check-report.xml', 
                                        failedTotalHigh: 0, failedTotalCritical: 0, 
                                        unstableTotalHigh: 10, 
                                        skipFailed: false, stopBuild: true
            }
        }
        stage('Deploy to Staging') {
            steps {
                // Deploy to AWS Elastic Beanstalk (staging)
                step([$class: 'AWSEBDeploymentBuilder', config: [
                    applicationName: 'MyApp-EB-App',
                    awsRegion:       'us-east-1',
                    bucketName:      'my-eb-artifacts-bucket',
                    environmentName: 'myapp-staging-env',
                    credentialId:    'aws-creds-id',
                    rootObject:      'target/myapp.jar',
                    includes:        'target/*.jar'
                ]])
            }
        }
        stage('Release to Production') {
            steps {
                // Deploy to AWS Elastic Beanstalk (production) or CodeDeploy
                step([$class: 'AWSEBDeploymentBuilder', config: [
                    applicationName: 'MyApp-EB-App',
                    awsRegion:       'us-east-1',
                    bucketName:      'my-eb-artifacts-bucket',
                    environmentName: 'myapp-prod-env',
                    credentialId:    'aws-creds-id',
                    rootObject:      'target/myapp.jar',
                    includes:        'target/*.jar'
                ]])
                // Alternatively, use AWS CodeDeploy:
                // step([$class: 'AWSCodeDeployPublisher', s3bucket: 'my-codedeploy-bucket',
                //       s3prefix: 'releases/', applicationName: 'MyApp', deploymentGroupName: 'MyApp-Prod'])
            }
        }
    }
}
