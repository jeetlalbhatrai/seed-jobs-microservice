pipeline {
    agent any
    stages {
        stage('Checkout seed repo') {
            steps {
                git branch: 'main2',
                    url: 'https://github.com/jeetlalbhatrai/seed-jobs-microservice.git'
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
