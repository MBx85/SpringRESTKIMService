pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'cd SpringRESTKIMService && mvn -B -DskipTests clean package && cd target && ls' 
            }
        }
    }
}
