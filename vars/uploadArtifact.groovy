def call(String artifactPath) {
    echo 'Uploading artifact...'
    archiveArtifacts artifacts: artifactPath, allowEmptyArchive: true
}
