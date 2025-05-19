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
         stage('Install Dependencies') {
            steps {
                // Install dependencies using npm ci for a clean and reproducible install
                bat 'npm ci'
            }
         }
         stage('Build') {
            steps {
                // Build your project; adjust the script based on your project configuration
                bat 'npm run build'
          }
      } 
}

