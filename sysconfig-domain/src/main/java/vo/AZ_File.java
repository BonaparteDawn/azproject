package vo;

import entity.File;

/**
 * Created by Fuzhong.Yan on 16/12/12.
 */
public class AZ_File extends File {
    /**
     * 文件前缀
     */
    private String filePathPrefix;
    /**
     * 完整路径
     */
    private String fullFilePath;

    public String getFilePathPrefix() {
        return filePathPrefix;
    }

    public void setFilePathPrefix(String filePathPrefix) {
        this.filePathPrefix = filePathPrefix;
    }

    public String getFullFilePath() {
        return fullFilePath;
    }

    public void setFullFilePath(String fullFilePath) {
        this.fullFilePath = fullFilePath;
    }
}
