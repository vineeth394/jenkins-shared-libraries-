def call() {
    echo 'Building project with Maven...'
    sh 'mvn clean package'
}
