folder('services') {
    displayName('Services')
    description('Folder for all microservice pipeline jobs')
}

pipelineJob('services/kyc-server') {
    description('Pipeline job for Config Server')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/jeetlalbhatrai/test11june.git')
                        credentials('bitbucket-creds')
                    }
                    branch('main')
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}
