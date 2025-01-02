// File: vars/setupJavaAndMaven.groovy

def call() {
    echo "Setting up Java and Maven..."

    // Install OpenJDK 11
    sh '''
    sudo apt update
    sudo apt install -y openjdk-11-jdk
    java -version
    '''
    
    // Install Maven if not already installed
    sh '''
    sudo apt install -y maven
    mvn -version
    '''
}
