pipelineJob('services/config-server') {
    description('Pipeline job for Config Server')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/jeetlalbhatrai/test11june.git')
                        credentials('bitbucket-creds')   // Jenkins credentials ID
                    }
                    branch('main')
                }
            }
            scriptPath('Jenkinsfile')  // Jenkinsfile inside service repo
        }
    }
}