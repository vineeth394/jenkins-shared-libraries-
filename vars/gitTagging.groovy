def tagGitRepository() {
    def tag = "build-${currentBuild.number}"
    
    // Check if the tag already exists
    def existingTag = sh(script: "git tag -l ${tag}", returnStdout: true).trim()
    
    if (existingTag) {
        echo "Tag ${tag} already exists. Skipping tag creation."
    } else {
        // Tag the repository with the current tag
        sh "git tag ${tag}"
        
        // Push the tag to the remote repository
        sh "git push origin ${tag}"
        
        echo "Git repository tagged with ${tag}"
    }
}
