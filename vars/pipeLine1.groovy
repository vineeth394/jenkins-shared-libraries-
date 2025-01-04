def call() {
    echo 'Checking out code...'
    checkout scm

    echo 'Setting up Java 17...'
    sh 'sudo apt update'
    sh 'sudo apt install -y openjdk-17-jdk'
    
    echo 'Setting up Maven...'
    sh 'sudo apt install -y maven'
    
    echo 'Building project with Maven...'
    sh 'mvn clean package'
    
    echo 'Uploading artifact...'
    archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
   
    echo 'Running Spring Boot application...'
    sh 'nohup mvn spring-boot:run &'
    sleep(time: 15, unit: 'SECONDS')

    def publicIp = sh(script: "curl -s https://checkip.amazonaws.com", returnStdout: true).trim()
    echo "The application is running and accessible at: http://${publicIp}:8080"
}
