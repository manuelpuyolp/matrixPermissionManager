package security

import security.PermissionTags;

class PermisionLineGenerator {

    public static def getPermissionStringByEnum(PermissionTags permissions) {
        return getPermissionStringByEnum(permissions, false)
    }

    public static def getPermissionStringByEnum(PermissionTags permission, boolean isGroup) {
        String type = isGroup ? "GROUP:" : "USER:"
        switch (permission) {
            case PermissionTags.CREDENTIALS_CREATE:
                return "${type}com.cloudbees.plugins.credentials.CredentialsProvider.Create"
                break;
            case PermissionTags.CREDENTIALS_DELETE:
                return "${type}com.cloudbees.plugins.credentials.CredentialsProvider.Delete"
                break;
            case PermissionTags.CREDENTIALS_UPDATE:
                return "${type}com.cloudbees.plugins.credentials.CredentialsProvider.Update"
                break;
            case PermissionTags.CREDENTIALS_VIEW:
                return "${type}com.cloudbees.plugins.credentials.CredentialsProvider.View"
                break;
            case PermissionTags.CREDENTIALS_MANAGEDOMAIN:
                return "${type}com.cloudbees.plugins.credentials.CredentialsProvider.ManageDomains"
                break;
            case PermissionTags.JOB_BUILD:
                return "${type}hudson.model.Item.Build"
                break;
            case PermissionTags.JOB_CANCEL:
                return "${type}hudson.model.Item.Cancel"
                break;
            case PermissionTags.JOB_CONFIGURE:
                return "${type}hudson.model.Item.Configure"
                break;
            case PermissionTags.JOB_DELETE:
                return "${type}hudson.model.Item.Delete"
                break;
            case PermissionTags.JOB_READ:
                return "${type}hudson.model.Item.Read"
                break;
            case PermissionTags.JOB_DISCOVER:
                return "${type}hudson.model.Item.Discover"
                break;
            case PermissionTags.JOB_MOVE:
                return "${type}hudson.model.Item.Move"
                break;
            case PermissionTags.JOB_WORKSPACE:
                return "${type}hudson.model.Item.Workspace"
                break;
            case PermissionTags.RUN_DELETE:
                return "${type}hudson.model.Run.Delete"
                break;
            case PermissionTags.RUN_REPLAY:
                return "${type}hudson.model.Run.Replay"
                break;
            case PermissionTags.RUN_UPDATE:
                return "${type}hudson.model.Run.Update"
                break;
            case PermissionTags.SCM_TAG:
                return "${type}hudson.scm.SCM.Tag"
                break;
        }
    }
}