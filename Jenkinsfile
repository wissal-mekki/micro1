stage('Generate') {
    node {
        checkout scm
        stash 'source'
    }
    
    node {

 step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'StartAllServices'], useCustomDockerComposeFile: true])

}
}
