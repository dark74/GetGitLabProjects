import bean.GitProjects;
import utils.FileUtils;
import utils.JsonUtils;
import utils.ProcessUtils;
import utils.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExeCurl {
    private static final String PARAM_PAGE_INDEX = "pageIndex";
    private static final String PARAM_ACCESS_TOKEN = "<accessToken>";
    private static final String PARAM_GITLAB_URL = "<gitlabUrl>";
    private static final String GITLAB_ACCESS_TOKEN = "your access token";
    private static final String GITLAB_URL = "https://gitlab.example.com";

    public static void main(String[] args) {
        String cmdStr = readCmdStr();
        List<GitProjects> list = getProjects(cmdStr);
        System.out.println("共获取项目：" + list.size() + "个");
        writeResultJson(list);
    }

    /**
     * 获取gitlab中所有项目
     *
     * @param cmdStr
     * @return
     */
    private static List<GitProjects> getProjects(String cmdStr) {
        int pageIndex = 1;
        List<GitProjects> resultProjects = new ArrayList<>();
        List<GitProjects> list = exeGetProjectsCmd(cmdStr, pageIndex);//首次执行获取项目list
        while (!list.isEmpty()) {
            resultProjects.addAll(list);
            list.clear();
            pageIndex++;
            list.addAll(exeGetProjectsCmd(cmdStr, pageIndex));
        }
        return resultProjects;
    }

    /**
     * 执行curl拉取命令
     *
     * @param cmdStr
     * @param pageIndex 当前要获取第几页
     * @return 获取git项目json，转为GitProjects列表返回
     */
    private static List<GitProjects> exeGetProjectsCmd(String cmdStr, int pageIndex) {
        if (!StringUtils.isEmpty(cmdStr)) {
            if (cmdStr.contains(PARAM_PAGE_INDEX) && cmdStr.contains(PARAM_ACCESS_TOKEN)) {
                String curlCmd = cmdStr.replace(PARAM_PAGE_INDEX, String.valueOf(pageIndex))
                        .replace(PARAM_ACCESS_TOKEN, GITLAB_ACCESS_TOKEN)
                        .replace(PARAM_GITLAB_URL, GITLAB_URL);
                String tempJsonArrayStr = ProcessUtils.exeCurl(curlCmd);
                return JsonUtils.parseArray(tempJsonArrayStr, GitProjects.class);
            }
        }
        return Collections.emptyList();
    }

    private static void writeResultJson(List<GitProjects> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String savePath = System.getProperty("user.dir") + File.separator + "result\\projects.json";
        String jsonString = JsonUtils.toJSONString(list);
        FileUtils.writeFile(savePath, jsonString, false);
    }

    /**
     * 读取curl命令
     *
     * @return
     */
    private static String readCmdStr() {
        String path = System.getProperty("user.dir") + "/config/cmd_get_projects.cfg";
        return FileUtils.readFile(path);
    }
}
