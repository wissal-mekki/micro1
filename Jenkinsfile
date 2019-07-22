pipeline {
    agent any

stages {
    
    stage('Generate') {
    steps {
        checkout scm
        stash 'source'
    }
    }
        stage ('Compile Stage') {

            steps {
                withMaven(maven: 'Maven') {
                    sh 'mvn clean  install'
                }
            
   

 step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'StartAllServices'], useCustomDockerComposeFile: true])
    
}
}
}

}
