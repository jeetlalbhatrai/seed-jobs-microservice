folder('JWR')
folder('JWR/Build-Services')

def services = [
    [name: 'config-server', jenkinsfile: 'service-jobs/config-server/Jenkinsfile'],
    [name: 'kyc-service',   jenkinsfile: 'service-jobs/kyc-service/Jenkinsfile']
]

services.each { svc ->
    pipelineJob("JWR/Build-Services/${svc.name}") {
        definition {
            cps {
                script(readFileFromWorkspace(svc.jenkinsfile))
                sandbox()
            }
        }
    }
}