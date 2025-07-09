package security

public class URLhandler {
    public static def getCreateJobString(String jobName) {
        def result = ""
        def path = jobName.split("/")
        for (int i = 0; i < path.size()-1; i++) {
            result += "job/${path[i]}/"
        }
        result += "createItem?name=${path[path.size()-1]}"
        println(result)
        return result;
    }

    public static def getRegularJobString(String jobName) {
        def result = ""
        def path = jobName.split("/")
        for (int i = 0; i < path.size(); i++) {
            result += "job/${path[i]}/"
        }
        return result;
    }
}