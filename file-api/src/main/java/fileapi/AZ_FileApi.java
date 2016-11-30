package fileapi;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作接口
 * Created by Fuzhong.Yan on 16/10/30.
 */

public interface AZ_FileApi {
    /**
     * 删除指定文件
     * @param fileName
     * @return
     */
    public boolean deleteFile(String  fileName) throws IOException;

    /**
     * 将数据写入指定文件(注意fileName必须唯一,建议限制文件的大小)
     * @param bytes
     * @param fileName
     * @return
     */
    public boolean writeBytes(byte[] bytes,String fileName) throws IOException;
    /**
     * 将服务器的数据保存到字节里面(建议读取的文件是比较小的)
     */
    public  byte[] readBytes(String fileName) throws IOException;
    /**
     * 将服务器文件的数据下载到指定位置
     */
    public boolean download(String local,String fileName) throws IOException;

    /**
     * 将指定文件数据以块的形式写入数据到输出流中
     * @param outputStream
     * @param fileName
     * @return
     */
    public boolean read(OutputStream outputStream,String fileName) throws IOException;

    /**
     * 把输入流里面的数据以块的形式读取,然后将数据保存。
     * @param inputStream
     * @param fileName
     * @return
     */
    public boolean write(InputStream inputStream,String fileName) throws IOException;

    /**
     * 打开文件系统
     * @throws IOException
     */
    public void open() throws  IOException;

    /**
     * 关闭文件系统
     */
    public void close() throws IOException;
}
