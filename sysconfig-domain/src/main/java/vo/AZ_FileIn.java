package vo;

import java.io.InputStream;

/**
 * Created by Fuzhong.Yan on 16/12/12.
 */
public class AZ_FileIn extends AZ_File {

    /**
     * 文件输入流
     */
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
