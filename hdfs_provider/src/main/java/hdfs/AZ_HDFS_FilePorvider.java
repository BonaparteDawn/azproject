package hdfs;

import fileapi.AZ_FileApi;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.JobConf;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.URI;

/**
 * HDFS文件管理服务
 * Created by Fuzhong.Yan on 16/10/30.
 */
@Service
public class AZ_HDFS_FilePorvider implements AZ_FileApi{
    /**
     * 数据流块的大小
     */
    private  int block_size = 1024;
    /**
     * 小型文件最大的数据块数(即:文件最大不能超过 max_block_num * block_size个字节)
     */
    private  int max_block_num = 1;
    /**
     * HDFS配置
     */
    private  Configuration configuration;
    /**
     * HDFS文件系统
     */
    private  FileSystem fileSystem;
    /**
     * HDFS的URL
     */
    private  String HDFS_URL="hdfs://localhost:9000";
    /**
     * 初始化
     */
    public void init(){
        try {
            configuration = new JobConf(AZ_HDFS_FilePorvider.class);
            fileSystem = FileSystem.get(URI.create(HDFS_URL),configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除指定文件
     * @param fileName
     * @return
     * @throws IOException
     */
    public boolean deleteFile(String fileName)  throws IOException{
        boolean res = false;
        if (fileSystem == null){
            return  res;
        }
        Path path =new Path(fileName);
        if (fileSystem.exists(path)){
            res = fileSystem.delete(path,true);
        }else{
            res = false;
        }
        return res;
    }

    /**
     * 写入小数据到文件
     * @param bytes
     * @param fileName
     * @return
     */
    public boolean writeBytes(byte[] bytes, String fileName)throws IOException {
        boolean res = false;
        if (fileSystem == null || bytes == null ){
            return  false;
        }
        if (bytes.length > block_size*max_block_num){
            throw  new IOException("Data greater than "+max_block_num*block_size+" bytes");
        }
        Path path =new Path(fileName);
        if (fileSystem.exists(path)){
            fileSystem.delete(path,true);
        }
        FSDataOutputStream o = fileSystem.create(path);
        if (o == null){
            return  false;
        }
        o.write(bytes);
        o.flush();
        o.close();
        res = true;
        return res;
    }

    /**
     * 读取小数据文件
     * @param fileName
     * @return
     */
    public byte[] readBytes(String fileName) throws IOException{
        if (fileSystem == null){
            return  null;
        }
        Path path =new Path(fileName);
        FSDataInputStream fi = fileSystem.open(path);
        if (fi == null){
            return  null;
        }
        InputStream io = fi.getWrappedStream();
        int len = io.available();
        if (len > max_block_num * block_size){
            throw  new IOException("Data greater than "+max_block_num*block_size+" bytes");
        }
        byte[] res = new byte[len];
        io.read(res,0,len-1);
        io.close();
        return res;
    }

    /**
     * 将指定文件下载到指定位置
     * @param local
     * @param fileName
     * @return
     * @throws IOException
     */
    public boolean download(String local, String fileName)throws IOException{
        if (local == null || fileName == null){
            return  false;
        }
        Path path =new Path(fileName);
        Path path_local = new Path(local);
        fileSystem.copyToLocalFile(path,path_local);
        return true;
    }

    /**
     * 将指定文件写入到输出流里面
     * @param outputStream
     * @param fileName
     * @return
     * @throws IOException
     */
    public boolean read(OutputStream outputStream, String fileName) throws IOException{
        if (outputStream == null || fileName == null){
            return  false;
        }
        Path path = new Path(fileName);
        FSDataInputStream fi = fileSystem.open(path);
        if (fi == null){
            return false;
        }
        InputStream io = fi.getWrappedStream();
        byte[] block_temp = new byte[block_size];
        int b_t_size = 0;
        while((b_t_size = io.read(block_temp)) > 0){
            byte[]  block_out = new byte[b_t_size];
            outputStream.write(block_temp);
            outputStream.flush();
        }
        io.close();
        return true;
    }

    /**
     * 将指定输入流里面的数据写入到文件里面
     * @param inputStream
     * @param fileName
     * @return
     * @throws IOException
     */
    public boolean write(InputStream inputStream, String fileName) throws IOException{
        if (inputStream == null || fileName == null){
            return  false;
        }
        Path path = new Path(fileName);
        if (fileSystem.exists(path)){
            fileSystem.delete(path,true);
        }
        FSDataOutputStream o = fileSystem.create(path);
        if (o == null){
            return  false;
        }
        byte[] block_temp = new byte[block_size];
        int b_t_size = 0;
        while((b_t_size = inputStream.read(block_temp)) > 0){
            byte[]  block_out = new byte[b_t_size];
            o .write(block_temp);
            o .flush();
        }
        o.close();
        return true;
    }

    public void close() throws IOException {
        fileSystem.close();
    }

    public int getBlock_size() {
        return block_size;
    }

    public void setBlock_size(int block_size) {
        this.block_size = block_size;
    }

    public int getMax_block_num() {
        return max_block_num;
    }

    public void setMax_block_num(int max_block_num) {
        this.max_block_num = max_block_num;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public String getHDFS_URL() {
        return HDFS_URL;
    }

    public void setHDFS_URL(String HDFS_URL) {
        this.HDFS_URL = HDFS_URL;
    }
}
