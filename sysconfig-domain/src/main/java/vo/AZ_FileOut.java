package vo;


import java.io.OutputStream;

/**
 * Created by Fuzhong.Yan on 16/12/12.
 */
public class AZ_FileOut extends AZ_File{
    /**
     * 文件输出数据流
     */
    private OutputStream outputStream;

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
