// vars/setupJavaAndMaven.groovy
def call() {
    echo 'Setting up Java and Maven...'
    sh 'sudo apt update && sudo apt install -y openjdk-11-jdk maven'
}
