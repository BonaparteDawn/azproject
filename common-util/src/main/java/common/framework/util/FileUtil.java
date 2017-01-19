package common.framework.util;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Fuzhong.Yan on 17/1/19.
 */
public class FileUtil {
    /**
     * 读取classpath下的文件
     * @param file
     * @return
     * @throws IOException
     */
    public static InputStream readClasspath(String file) throws IOException {
        return new ClassPathResource(file).getInputStream();
    }

    /**
     * 清空该文件下的所有的数据
     * @param workspaceRootPath
     */
    public static void clearFiles(String workspaceRootPath){
        File file = new File(workspaceRootPath);
        if(file.exists()){
            clearFiles(file);
        }
    }
    /**
     * 清空该文件下的所有的数据
     * @param file
     */
    public static void clearFiles(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0; i<files.length; i++){
                clearFiles(files[i]);
                files[i].delete();
            }
        }
    }
}
