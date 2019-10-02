
node {
   def mvnHome
   stage('Preparation') {
        checkout scm
        stash 'source'
      mvnHome = tool name: 'Maven', type: 'maven'
   }
   stage('Build') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
     // junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
   }
  
  
stage('deploy') {
   docker.build('micro1-app-jenk')
  sh 'docker-compose up -d'
  // sh '/usr/local/bin/docker-compose up --build'
//step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'StartAllServices'], useCustomDockerComposeFile: true])
}
/*
   stage('Publish') {
     nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/micro1-0.0.1-SNAPSHOT.jar']], mavenCoordinate: [artifactId: 'micro1', groupId: 'com.project', packaging: 'jar', version: '0.0.1']]]
   }

stage('sonar') {
 withSonarQubeEnv('sonar') {
     
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
}
*/

}
