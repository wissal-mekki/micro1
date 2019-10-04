node {
   def mvnHome
   stage('Preparation') {
        checkout scm
        stash 'source'
      mvnHome = tool name: 'Maven', type: 'maven'
   }
   stage('Build') {    
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean install"
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
   }
   stage('Test') {
      sh "'${mvnHome}/bin/mvn' surefire:test"
      junit '**/target/surefire-reports/TEST-*.xml' 
   }
   stage('Artefact') {
      archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
   }
   stage('Publish') {
     nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/micro1-0.0.1-SNAPSHOT.jar']], mavenCoordinate: [artifactId: 'micro1', groupId: 'com.project', packaging: 'jar', version: '0.0.1']]]
   }
stage('Analyse sonar') {
 withSonarQubeEnv('sonar') {
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
}
stage('Deploy') {
   docker.build('micro1-app-jenk')
  sh 'docker-compose up -d'
//step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'StartAllServices'], useCustomDockerComposeFile: true])
}
}
