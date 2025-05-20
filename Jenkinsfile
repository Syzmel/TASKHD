pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                // Set environment variables (replace with your actual values)
                bat 'echo CODE_CLIMATE_REPO_ID=eb159807-a6c3-4320-9a51-435fc9a82510'
                bat 'echo CODE_CLIMATE_TOKEN=qltcw_gppEbpHCdusHDMR4'

                // Before-build command (before your tests)
                bat "cc-test-reporter before-build"

                // Run your tests
                bat "your-test-command"

                // After-build command (after your tests)
                bat "cc-test-reporter after-build"
            }
        }
    }
}
