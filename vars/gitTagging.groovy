def call(String tagName) {
    echo "Tagging commit with tag: ${tagName}"

    // Get the current commit hash
    def commitHash = sh(script: "git rev-parse HEAD", returnStdout: true).trim()

    // Check if the tag already exists
    def tagExists = sh(script: "git tag -l ${tagName}", returnStatus: true) == 0

    if (tagExists) {
        echo "Tag '${tagName}' already exists for commit ${commitHash}"
    } else {
        // Create a new tag
        echo "Creating new tag '${tagName}' for commit ${commitHash}"
        sh "git tag ${tagName}"
        
        // Push the tag to the remote repository
        sh "git push origin ${tagName}"
    }
}
