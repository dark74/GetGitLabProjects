package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessUtils {

    /**
     * 执行curl命令
     *
     * @param cmdStr
     * @return
     */
    public static String exeCurl(String cmdStr) {
        if (StringUtils.isEmpty(cmdStr)) {
            return "";
        }
        String[] cmds = cmdStr.split(" ");
        ProcessBuilder processBuilder = new ProcessBuilder(cmds);
        Process p = null;
        try {
            p = processBuilder.start();
            InputStream pInputStream = p.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pInputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.destroy();
            }
        }
        return "";
    }
}
