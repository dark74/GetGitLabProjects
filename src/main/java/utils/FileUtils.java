package utils;

import org.apache.log4j.Logger;

import java.io.*;

public class FileUtils {
    /**
     * File文件 -> FileInputStream[文件流] -> InputStreamReader[流读取对象, Reads a single character]
     * -> BufferReader[流读取buffer缓冲器] -> reader读出字节流 -> 字节流 - 字符串
     *
     * @param path
     * @return
     */
    public static String readFile(String path) {
        File file = new File(path);
        StringBuilder stringBuilder = new StringBuilder();
        if (file.exists() && file.isFile()) {
            BufferedReader bufferedReader = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(file);//读取文件流
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);//输入流reader
                bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (!stringBuilder.toString().equals("")) {
                        stringBuilder.append("\r\n");
                    }
                    stringBuilder.append(line);
                }
            } catch (FileNotFoundException e) {
                LogUtils.e("文件不存在");
                e.printStackTrace();
            } catch (IOException e) {
                LogUtils.e("文件读取异常");
                e.printStackTrace();
            } finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 写入字符串 FileWriter
     *
     * @param path
     * @param content
     * @param append  是否追加
     * @return
     */
    public static boolean writeFile(String path, String content, boolean append) {
        if (path == null || path.length() == 0) return false;
        if (content == null || content.length() == 0) return false;
        boolean res = false;
        //获取文件目录
        int index = path.lastIndexOf(File.separator);
        String foldName = (index == -1 ? "" : path.substring(0, index));
        boolean foldDirsExist = false;
        if (foldName.isEmpty()) {
            File folder = new File(foldName);
            if (!folder.exists() || !folder.isDirectory()) {
                foldDirsExist = folder.mkdirs();//创建文件目录
            }
        } else {
            foldDirsExist = true;
        }
        //待写入文件目录存在
        if (foldDirsExist) {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(path, append);
                fileWriter.write(content);//写入字符串内容
                res = true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return res;
    }
}
