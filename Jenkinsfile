pipeline {
    agent any

stages {
    
    stage('Generate') {
    steps {
        checkout scm
        stash 'source'
    }
    
       
        stage('compile') {
        

 step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'StartAllServices'], useCustomDockerComposeFile: true]){
 withMaven(maven: 'Maven') {
                    sh 'mvn clean  install'
                }
 }
    }
    }
}
}
