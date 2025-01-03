def call() {
    echo 'Cleaning up...'
    sh 'pkill -f "mvn spring-boot:run" || true'
}
