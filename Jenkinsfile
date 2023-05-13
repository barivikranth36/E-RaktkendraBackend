pipeline {
    agent any
    stages {
        stage('Git clone backend') {
            steps {
                git url: 'https://github.com/imshukla12/E-RaktkendraBackend.git' , branch: 'master'
                echi 'project cloned'
            }
        }
      stage('Maven Build') {
            steps {
                sh 'mvn clean install'
                echo 'maven build completed'
            }
        }
//       stage('Testing project') {
//              steps {
//                 sh "mvn test"
//                 echo "Testing completed"
//              }
//         }
      stage('Docker Build to Image') {
             steps {
                  echo 'creating docker image'
                  sh 'docker build -t eraktkendra_security_backend .'
                  echo 'docker image created'
            }
        }
      stage('Push Docker Image to Docker Hub') {
              steps {
                        echo 'docker tag'
                        sh 'docker tag eraktkendra_security_backend imshukla/eraktkendra_security_backend:latest'
                        echo 'pushing image to docker hub'
                        withDockerRegistry([ credentialsId: "docker-cred", url: "" ]){
                        sh 'docker push imshukla/eraktkendra_security_backend'
                    }
              }
      }
//       stage('Ansible Pull Docker Image') {
//                   steps {
//                       ansiblePlaybook becomeUser: null,
//                       colorized: true,
//                       disableHostKeyChecking: true,
//                       installation: 'Ansible',
//                       inventory: 'inventory',
//                       playbook: 'playbook.yml',
//                       sudoUser: null
//                   }
//       }
    }
}