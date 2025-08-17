// def repos = [
//     [name: 'jg-jwr-config-server', url: 'https://github.com/jeetlalbhatrai/test11june.git']
//     // [name: 'jg-jwr-config-server', url: 'https://bitbucket.org/<workspace>/jg-jwr-config-server.git'],
//     // [name: 'jg-jwr-osgiparser',    url: 'https://bitbucket.org/<workspace>/jg-jwr-osgiparser.git']
// ]

// folder('JWR')
// folder('JWR/Build-Services')

// repos.each { svc ->
//     multibranchPipelineJob("JWR/Build-Services/${svc.name}-pipeline") {
//         branchSources {
//             git {
//                 id(svc.name)
//                 remote(svc.url)
//                 credentialsId('bb-app')
//             }
//         }
//         factory {
//             workflowBranchProjectFactory {
//                 scriptPath('Jenkinsfile')   // looks inside repo
//             }
//         }
//         orphanedItemStrategy {
//             discardOldItems {
//                 numToKeep(20)
//             }
//         }
//     }
// }

folder('JWR') {
    displayName('JWR')
    description('Parent folder for JWR services')
}

folder('JWR/Build-Services') {
    displayName('Build-Services')
    description('Pipelines for JWR microservices')
}

def repos = [
    [name: 'jg-jwr-config-server', url: 'https://github.com/jeetlalbhatrai/test11june.git'],
    [name: 'jg-jwr-osgiparser',    url: 'https://github.com/jeetlalbhatrai/jg-jwr-osgiparser.git']
]

repos.each { svc ->
    multibranchPipelineJob("JWR/Build-Services/${svc.name}") {
        branchSources {
            git {
                id(svc.name)
                remote(svc.url)
                credentialsId('github-credentials')   // update with your creds ID
            }
        }
        factory {
            workflowBranchProjectFactory {
                scriptPath('Jenkinsfile')
            }
        }
        orphanedItemStrategy {
            discardOldItems {
                numToKeep(10)
            }
        }
    }
}
