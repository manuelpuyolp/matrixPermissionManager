import security.*


@groovy.transform.Field
String libPath = "${JENKINS_HOME}/matrixRoleManager"

@groovy.transform.Field
String downloadPath = "${libPath}/permissions"

@groovy.transform.Field
String logInCredPath = "${libPath}/logInCredentials"

@groovy.transform.Field
String userCredPath = "${logInCredPath}/user.txt"

@groovy.transform.Field
String passwordCredPath = "${logInCredPath}/pass.txt"

def updateJobConfig(String jobName, String newFileText) {
    def user = getUser()
    def password = getPassword()
    def download_Path = downloadPath
    def file_Name = "config.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    File newFile = new File("${full_File_Path}")
    newFile.write("${newFileText}")
    def crumb = getCrumb(user, password, download_Path);
    def correctPath = URLhandler.getRegularJobString(jobName)
    def url = "${JENKINS_URL}${correctPath}config.xml"
    sh "curl -v -X POST --data-binary @${full_File_Path} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${url}\" -H 'Jenkins-Crumb: ${crumb}'"
}

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

def getCrumb(String user, String password, String downloadPath) {
    sh "touch  ${downloadPath}/crumb.txt"
    sh "curl -o ${downloadPath}/crumb.txt -X GET -u ${user}:${password} ${JENKINS_URL}crumbIssuer/api/xml"
    def crumbFile = new File("${downloadPath}/crumb.txt")
    def crumbFileCont = crumbFile.getText()
    def parts = crumbFileCont.split("<crumb>")
    def next = parts[1].split("</crumb>")
    return next[0]
}

def printJob(String jobName) {
    String text = getJobConfig(jobName)
    println(text)
}

def getUser() {
    def file = new File(userCredPath)
    def fileContent = file.getText()
    return fileContent.trim()
}

def getPassword() {
    def file = new File(passwordCredPath)
    def fileContent = file.getText()
    return fileContent.trim()
}