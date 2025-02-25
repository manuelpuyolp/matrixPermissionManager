def call(String user, String password) {
    def loginPath = util.logInCredPath
    println(loginPath)
    def userPath = "${loginPath}/user.txt"
    def passPath = "${loginPath}/pass.txt"
    sh "mkdir -p ${loginPath}"
    sh "rm -rf ${loginPath}/*"
    sh "touch ${userPath}"
    sh "touch ${passPath}"
    sh "echo ${user} > ${userPath}"
    sh "echo ${password} > ${passPath}"
}