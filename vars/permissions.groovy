import security.PermisionsModifier
import security.PermissionTags

def add(String jobName, String user_to_modify, PermissionTags[] tags, boolean isGroup) {
    def fileContent = util.getJobConfig(jobName)
    def result = PermisionsModifier.addPermissions(fileContent, user_to_modify, tags, isGroup);

    util.updateJobConfig(jobName, result)
}

def addUser(String jobName, String user_to_modify, PermissionTags[] tags) {
    add(jobName, user_to_modify, tags, false)
}

def addGroup(String jobName, String user_to_modify, PermissionTags[] tags) {
    add(jobName, user_to_modify, tags, true)
}

def remove(String jobName, String user_to_modify, PermissionTags[] tags) {
    def fileContent = util.getJobConfig(jobName)
    def result = PermisionsModifier.removePermissions(fileContent, user_to_modify, tags);

    util.updateJobConfig(jobName, result)
}


def addAllUser(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    addUser(jobName, user, allTags)
}

def addAllGroup(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    addGroup(jobName, user, allTags)
}

def removeAll(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    remove(jobName, user, allTags)
}
