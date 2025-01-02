@Library('test1@main') _  // Use main branch from the shared library

pipeline {
    agent any
    
    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
        PATH = "$JAVA_HOME/bin:$PATH"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                checkout scm
            }
        }

        stage('Set up Java and Maven') {
            steps {
                // Call the setupJavaAndMaven function from the shared library
                setupJavaAndMaven()
            }
        }

        stage('Build Application') {
            steps {
                // Call the buildApp function from the shared library
                buildApp()
            }
        }

        stage('Run Application') {
            steps {
                // Run the Spring Boot application
                script {
                    sh 'nohup mvn spring-boot:run &'
                    sleep(15)  // Allow time for the app to fully start
                }
            }
        }

        stage('Validate App') {
            steps {
                // Validate if the app is running
                script {
                    def response = sh(script: 'curl --write-out "%{http_code}" --silent --output /dev/null http://localhost:8080', returnStdout: true).trim()
                    if (response == '200') {
                        echo 'The app is running successfully!'
                    } else {
                        echo 'The app failed to start. HTTP response code: ' + response
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }

        stage('Wait for 5 Minutes') {
            steps {
                // Wait for 5 minutes
                echo 'Waiting for 5 minutes...'
                sleep(300)  // Wait for 5 minutes
            }
        }

        stage('Stop Application') {
            steps {
                // Stop the application gracefully
                script {
                    sh 'mvn spring-boot:stop'
                }
            }
        }
    }
    
    post {
        always {
            echo 'Cleaning up resources...'
            // Add any necessary cleanup steps here
        }
    }
}
