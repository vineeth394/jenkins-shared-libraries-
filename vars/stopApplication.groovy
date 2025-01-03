def call() {
    echo 'Gracefully stopping the Spring Boot application...'
    sh 'mvn spring-boot:stop'
}
