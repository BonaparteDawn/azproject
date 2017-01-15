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
    public boolean writeBytes(String fileName,byte[] bytes) throws IOException;

    /**
     * 将数据追加到指定文件后面(注意fileName必须唯一,建议限制文件的大小)
     * @param fileName
     * @return 是否追加成功
     * @throws IOException
     */
    public boolean appendBytes(String fileName,byte[] bytes) throws IOException;
    /**
     * 将数据追加到指定文件后面(注意fileName必须唯一,建议限制文件的大小)
     * @param fileName
     * @return 是否追加成功
     * @throws IOException
     */
    public boolean appendInputStream(String fileName,InputStream inputStream) throws IOException;
    /**
     * 将服务器的数据保存到字节里面(建议读取的文件是比较小的)
     */
    public  byte[] readBytesByFileName(String fileName) throws IOException;

    /**
     * 将服务器的数据保存到字节里面(建议读取的文件是比较小的)
     */
    public  byte[] readBytes(String fileName,long skip_size,int block_size) throws IOException;
    /**
     * 将服务器的数据保存到输入流里面(建议读取的文件是比较小的)
     */
    public  InputStream readInputStream(String fileName,long skip_size,int block_size) throws IOException;

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
    public boolean read(String fileName,OutputStream outputStream) throws IOException;

    /**
     * 把输入流里面的数据以块的形式读取,然后将数据保存。
     * @param inputStream
     * @param fileName
     * @return
     */
    public boolean write(String fileName,InputStream inputStream) throws IOException;

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
