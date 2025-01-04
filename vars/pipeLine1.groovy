def call() {
    echo 'Checking out code...'
    checkout scm
}

def call() {
    echo 'Setting up Java 17...'
    sh 'sudo apt update'
    sh 'sudo apt install -y openjdk-17-jdk'
}

def call() {
    echo 'Setting up Maven...'
    sh 'sudo apt install -y maven'
}

def call() {
    echo 'Building project with Maven...'
    sh 'mvn clean package'
}

