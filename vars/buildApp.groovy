// vars/buildApp.groovy
def call() {
    echo 'Building the project with Maven...'
    sh 'mvn clean install -DskipTests'
}
