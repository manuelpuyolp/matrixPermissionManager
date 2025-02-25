// First method to be called in order for the correct use of the shared library, otherwise any changes will be rejected.
// It stores the login credentials for the remainder of the pipeline to be used going forward.

def call(String user, String password) {
    def loginPath = util.logInCredPath
    def userPath = util.userCredPath
    def passPath = util.passwordCredPath
    sh "mkdir -p ${loginPath}"
    sh "rm -rf ${loginPath}/*"
    sh "touch ${userPath}"
    sh "touch ${passPath}"
    sh "echo ${user} > ${userPath}"
    sh "echo ${password} > ${passPath}"
}