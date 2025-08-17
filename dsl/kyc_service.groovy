pipelineJob('services/kyc-service') {
    description('Pipeline job for KYC Service')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://bitbucket.org/<workspace>/kyc-service.git')
                        credentials('bitbucket-creds')
                    }
                    branch('main')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}
