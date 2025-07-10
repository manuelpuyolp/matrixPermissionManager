import security.*
// A set of helper calls that provide functionality to interact with the Jenkins API, like downloading job configurations or uploading the edited ones.
// As well as dealing with the crumb issuer for any requests
// They are to be used by the "permissions.groovy" script

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
    println "======================== updateJobConfig 1 ======================================="
    def user = getUser()
    def password = getPassword()
    def download_Path = downloadPath
    def file_Name = "config.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    println "======================== updateJobConfig 2 ======================================="

    File newFile = new File("${full_File_Path}")
    newFile.write("${newFileText}")
    def crumb = getCrumb(user, password, download_Path)

    println "======================== updateJobConfig 3 ======================================="


    def correctPath = URLhandler.getRegularJobString(jobName)

    println "======================== updateJobConfig 4 ======================================="
    def url = "${JENKINS_URL}${correctPath}config.xml"
    println "======================== updateJobConfig 5 ======================================="
    println "URL: ${url}"
    println "User: ${user}"
    println "Password: ${password}"
    println "Crumb: ${crumb}"
    println "Full File Path: ${full_File_Path}"
    println "======================== updateJobConfig 6 ======================================="    
    println "Executing curl command to update job config"
    // println "curl -v -X POST --data-binary @${full_File_Path} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${url}\" -H 'Jenkins-Crumb: ${crumb}'"
    println "curl -v -X POST --data-binary @${full_File_Path} -u ${user}:${password} -H Content-Type: application/xml '${url}' -H 'Jenkins-Crumb: ${crumb}' "
    
    println "======================== updateJobConfig 7_3 ======================================="    
    // sh "curl -v -X POST --data-binary @${full_File_Path} -u ${user}:${password} -H 'Content-Type: application/xml'  \"${url}\" -H 'Jenkins-Crumb: ${crumb}'"
    //sh """curl -v -X POST --data-binary @${full_File_Path} -u ${user}:${password} -H "Content-Type: application/xml" "${url}" -H "Jenkins-Crumb: ${crumb}" """

    aux = "curl -v -X POST --data-binary @${full_File_Path} -u ${user}:113cc3a3e49437a59cd4c9d72ffe90d115 -H Content-Type: application/xml '${url}' -H \'Jenkins-Crumb: ${crumb}\' "
    //sh "curl -v -X POST --data-binary @${full_File_Path} -u ${user}:${password} -H Content-Type: application/xml '${url}' -H \'Jenkins-Crumb: ${crumb}\' "
    sh "${aux}"
    println "======================== updateJobConfig 8 ======================================="
    println "Job config updated successfully"
}

def downloadFile(String user, String password, String jobName, String download_Path, String full_File_Path) {
    println "========================downloadFile======================================="
    sh "mkdir -p ${download_Path}"
    sh "touch ${full_File_Path}"
    sh "rm -rf ${download_Path}/*"
    def correctPath = URLhandler.getRegularJobString(jobName)
    def url = "${JENKINS_URL}${correctPath}config.xml"
    sh "curl -o ${full_File_Path} -X GET -u ${user}:${password} ${url}"
    sh "chmod 777 ${full_File_Path}"
    sh "ls -l ${download_Path}"
    sh "cat ${full_File_Path}"

}

def getJobConfig(String jobName) {
    println "==============================getJobConfig======================================="
    def user = getUser()
    def password = getPassword()
    def download_Path = downloadPath
    def file_Name = "output.xml"
    def full_File_Path = "${download_Path}/${file_Name}"

    downloadFile(user, password, jobName, download_Path,full_File_Path)
    println "============================getJobConfig1======================================="
    def file = new File("${full_File_Path}")
    println "============================getJobConfig2======================================="
    def fileContent = file.getText()
    println "============================getJobConfig3======================================="
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