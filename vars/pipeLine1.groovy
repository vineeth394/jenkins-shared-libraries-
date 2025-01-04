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
}
