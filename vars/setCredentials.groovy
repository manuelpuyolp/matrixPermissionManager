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