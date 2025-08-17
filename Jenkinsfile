pipeline {
    agent any
    stages {
        stage('Checkout seed repo') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/jeetlalbhatrai/seed-jobs-microservice.git'
                    // url: 'https://github.com/jeetlalbhatrai/seed-jobs-microservice.git',
                    // credentialsId: 'bb-app'
            }
        }
        stage('Generate jobs') {
            steps {
                jobDsl targets: 'dsl/**/*.groovy',
                       removedJobAction: 'DELETE',
                       removedViewAction: 'DELETE',
                       removedConfigFilesAction: 'DELETE'
            }
        }
    }
}