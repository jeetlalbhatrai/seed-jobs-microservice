def repos = [
    [name: 'jg-jwr-config-server', url: 'https://github.com/jeetlalbhatrai/test11june.git']
    // [name: 'jg-jwr-config-server', url: 'https://bitbucket.org/<workspace>/jg-jwr-config-server.git'],
    // [name: 'jg-jwr-osgiparser',    url: 'https://bitbucket.org/<workspace>/jg-jwr-osgiparser.git']
]

folder('JWR')
folder('JWR/Build-Services')

repos.each { svc ->
    multibranchPipelineJob("JWR/Build-Services/${svc.name}-pipeline") {
        branchSources {
            git {
                id(svc.name)
                remote(svc.url)
                credentialsId('bb-app')
            }
        }
        factory {
            workflowBranchProjectFactory {
                scriptPath('Jenkinsfile')   // looks inside repo
            }
        }
        orphanedItemStrategy {
            discardOldItems {
                numToKeep(20)
            }
        }
    }
}
