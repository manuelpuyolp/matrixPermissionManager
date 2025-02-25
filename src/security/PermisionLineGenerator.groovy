package security

import security.PermissionTags;

class PermisionLineGenerator {

    public static def getPermissionStringByEnum(PermissionTags permission) {
        switch (permission) {
            case PermissionTags.CREDENTIALS_CREATE:
                return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.Create"
                break;
            case PermissionTags.CREDENTIALS_DELETE:
                return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.Delete"
                break;
            case PermissionTags.CREDENTIALS_UPDATE:
                return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.Update"
                break;
            case PermissionTags.CREDENTIALS_VIEW:
                return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.View"
                break;
            case PermissionTags.CREDENTIALS_MANAGEDOMAIN:
                return "USER:com.cloudbees.plugins.credentials.CredentialsProvider.ManageDomains"
                break;
            case PermissionTags.JOB_BUILD:
                return "USER:hudson.model.Item.Build"
                break;
            case PermissionTags.JOB_CANCEL:
                return "USER:hudson.model.Item.Cancel"
                break;
            case PermissionTags.JOB_CONFIGURE:
                return "USER:hudson.model.Item.Configure"
                break;
            case PermissionTags.JOB_DELETE:
                return "USER:hudson.model.Item.Delete"
                break;
            case PermissionTags.JOB_READ:
                return "USER:hudson.model.Item.Read"
                break;
            case PermissionTags.JOB_DISCOVER:
                return "USER:hudson.model.Item.Discover"
                break;
            case PermissionTags.JOB_MOVE:
                return "USER:hudson.model.Item.Move"
                break;
            case PermissionTags.JOB_WORKSPACE:
                return "USER:hudson.model.Item.Workspace"
                break;
            case PermissionTags.RUN_DELETE:
                return "USER:hudson.model.Run.Delete"
                break;
            case PermissionTags.RUN_REPLAY:
                return "USER:hudson.model.Run.Replay"
                break;
            case PermissionTags.RUN_UPDATE:
                return "USER:hudson.model.Run.Update"
                break;
            case PermissionTags.SCM_TAG:
                return "USER:hudson.scm.SCM.Tag"
                break;

        }
    }

    public static def getGroupPermissionStringByEnum(PermissionTags permission) {
        switch (permission) {
            case PermissionTags.CREDENTIALS_CREATE:
                return "GROUP:com.cloudbees.plugins.credentials.CredentialsProvider.Create"
                break;
            case PermissionTags.CREDENTIALS_DELETE:
                return "GROUP:com.cloudbees.plugins.credentials.CredentialsProvider.Delete"
                break;
            case PermissionTags.CREDENTIALS_UPDATE:
                return "GROUP:com.cloudbees.plugins.credentials.CredentialsProvider.Update"
                break;
            case PermissionTags.CREDENTIALS_VIEW:
                return "GROUP:com.cloudbees.plugins.credentials.CredentialsProvider.View"
                break;
            case PermissionTags.CREDENTIALS_MANAGEDOMAIN:
                return "GROUP:com.cloudbees.plugins.credentials.CredentialsProvider.ManageDomains"
                break;
            case PermissionTags.JOB_BUILD:
                return "GROUP:hudson.model.Item.Build"
                break;
            case PermissionTags.JOB_CANCEL:
                return "GROUP:hudson.model.Item.Cancel"
                break;
            case PermissionTags.JOB_CONFIGURE:
                return "GROUP:hudson.model.Item.Configure"
                break;
            case PermissionTags.JOB_DELETE:
                return "GROUP:hudson.model.Item.Delete"
                break;
            case PermissionTags.JOB_READ:
                return "GROUP:hudson.model.Item.Read"
                break;
            case PermissionTags.JOB_DISCOVER:
                return "GROUP:hudson.model.Item.Discover"
                break;
            case PermissionTags.JOB_MOVE:
                return "GROUP:hudson.model.Item.Move"
                break;
            case PermissionTags.JOB_WORKSPACE:
                return "GROUP:hudson.model.Item.Workspace"
                break;
            case PermissionTags.RUN_DELETE:
                return "GROUP:hudson.model.Run.Delete"
                break;
            case PermissionTags.RUN_REPLAY:
                return "GROUP:hudson.model.Run.Replay"
                break;
            case PermissionTags.RUN_UPDATE:
                return "GROUP:hudson.model.Run.Update"
                break;
            case PermissionTags.SCM_TAG:
                return "GROUP:hudson.scm.SCM.Tag"
                break;

        }
    }
}