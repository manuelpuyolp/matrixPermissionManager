String libPath = "${JENKINS_HOME}/matrixRoleManager"
String downloadPath = "${libPath}/permissions"


def downloadFile(String user, String password, String jobName, String download_Path, String full_File_Path) {
    sh "mkdir -p ${download_Path}"
    sh "touch ${full_File_Path}"
    sh "rm -rf ${download_Path}/*"
    def correctPath = URLhandler.getRegularJobString(jobName)
    def url = "${JENKINS_URL}${correctPath}config.xml"
    sh "curl -o ${full_File_Path} -X GET -u ${user}:${password} ${url}"
}

def getJobConfig(String jobName) {
    def user = getUser()
    def password = getPassword()
    def download_Path = downloadPath
    def file_Name = "output.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    downloadFile(user, password, jobName, download_Path,full_File_Path)
    def file = new File("${full_File_Path}")
    def fileContent = file.getText()
    return fileContent
}