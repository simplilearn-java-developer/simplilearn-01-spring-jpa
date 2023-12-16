pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                // git 'https://github.com/simplilearn-java-developer/simplilearn-01-spring-jpa.git'

                echo 'Building the Project with maven compile'

                // Run Maven on a Unix agent.
                sh "./mvnw compile"

                // To run Maven on a Windows agent, use
                //bat "mvnw.cmd compile"
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the Project with maven test'

                sh "./mvnw test"
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the Project with maven package'

                sh "./mvnw package"
            }
        }
    }
}
