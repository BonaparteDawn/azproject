package hdfs;

import common.framework.annotation.AZ_LogMethod;
import common.framework.util.IOUtils;
import common.framework.util.ObjectUtils;
import constant.AZ_Constant;
import enums.AZ_LogTime;
import enums.AZ_LogType;
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
     * 数据流块的大小(1M)
     */
    private  int block_size = AZ_Constant.FILE_BLOCK_SIZE*AZ_Constant.FILE_BLOCK_UNIT_M;
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
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "初始化HDFS服务",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public void init(){
        try {
            open();
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
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "根据文件名删除文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
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
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "写入字节数据",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean writeBytes(String fileName,byte[] bytes)throws IOException {
        boolean res = false;
        if (fileSystem == null || bytes == null ){
            return  false;
        }
        if (bytes.length > block_size){
            throw  new IOException("Data greater than "+block_size+" bytes");
        }
        Path path =new Path(fileName);
        if (fileSystem.exists(path)){
            this.deleteFile(fileName);
        }
        FSDataOutputStream outputStream = fileSystem.create(path);
        if (outputStream == null){
            return  false;
        }
        IOUtils.write2outputStream(bytes,outputStream);
        outputStream.close();
        res = true;
        return res;
    }

    /**
     * 将数据追加到指定文件后面(注意fileName必须唯一,建议限制文件的大小)
     *
     * @param bytes
     * @param fileName
     * @return 是否追加成功
     * @throws IOException
     */
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "追加字节数据",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean appendBytes(String fileName,byte[] bytes) throws IOException {
        boolean res = false;
        if (fileSystem == null || bytes == null ){
            return  false;
        }
        if (bytes.length > block_size){
            throw  new IOException("Data greater than "+block_size+" bytes");
        }
        Path path =new Path(fileName);
        FSDataOutputStream o = null;
        if (fileSystem.exists(path)){
            o = fileSystem.append(path);
        }else {
            o = fileSystem.create(path);
        }
        if (o == null){
            return  false;
        }
        IOUtils.write2outputStream(bytes,o);
        o.close();
        res = true;
        return res;
    }

    /**
     * 将数据追加到指定文件后面(注意fileName必须唯一,建议限制文件的大小)
     *
     * @param fileName
     * @param inputStream
     * @return 是否追加成功
     * @throws IOException
     */
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "追加数据流里面的数据",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean appendInputStream(String fileName, InputStream inputStream) throws IOException {
        boolean res = false;
        if (inputStream == null || fileName == null){
            return  false;
        }
        if (inputStream.available() > block_size){
            throw  new IOException("Data greater than "+block_size+" bytes");
        }
        Path path =new Path(fileName);
        FSDataOutputStream o = null;
        if (fileSystem.exists(path)){
            o = fileSystem.append(path);
        }else {
            o = fileSystem.create(path);
        }
        if (o == null){
            return  false;
        }
        while(true){
            InputStream temp = IOUtils.copy(inputStream,0,block_size,true);
            if (ObjectUtils.isEmpty(temp)){
                res = true;
                break;
            }
            IOUtils.write2outputStream(temp,o);
            temp.close();
        }
        o.close();
        return res;
    }

    /**
     * 读取小数据文件
     * @param fileName
     * @return
     */
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "读取字节数据",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public byte[] readBytesByFileName(String fileName) throws IOException{
        if (fileSystem == null){
            return  null;
        }
        Path path =new Path(fileName);
        FSDataInputStream fi = fileSystem.open(path);
        if (fi == null){
            return  null;
        }
        InputStream io = fi.getWrappedStream();
        if (io.available() > block_size){
            throw  new IOException("Data greater than "+block_size+" bytes");
        }
        byte[] res = IOUtils.copy2Bytes(io,0,block_size,true);
        io.close();
        return res;
    }

    /**
     * 将服务器的数据保存到字节里面(建议读取的文件是比较小的)
     * @param fileName
     * @param skip_size
     * @param blockSize
     */
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "读取文件指定位置的块数据",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public byte[] readBytes(String fileName, long skip_size,int blockSize) throws IOException {
        if (fileSystem == null){
            return  null;
        }
        if (blockSize > block_size){
            throw  new IOException("Data greater than "+block_size+" bytes");
        }
        Path path =new Path(fileName);
        FSDataInputStream fi = fileSystem.open(path);
        if (fi == null){
            return  null;
        }
        InputStream inputStream = fi.getWrappedStream();
        byte[] res = IOUtils.copy2Bytes(inputStream,skip_size,blockSize,true);;
        inputStream.close();
        return res;
    }

    /**
     * 将服务器的数据保存到输入流里面(建议读取的文件是比较小的)
     *
     * @param fileName
     * @param skip_size
     * @param blockSize
     */
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "读取文件指定位置的块数据",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public InputStream readInputStream(String fileName, long skip_size, int blockSize) throws IOException {
        if (fileSystem == null){
            return  null;
        }
        if (blockSize > block_size){
            throw  new IOException("Data greater than "+block_size+" bytes");
        }
        Path path =new Path(fileName);
        FSDataInputStream fi = fileSystem.open(path);
        if (fi == null){
            return  null;
        }
        InputStream inputStream = fi.getWrappedStream();
        InputStream temp = IOUtils.copy(inputStream,skip_size,blockSize,true);
        inputStream.close();
        return temp;
    }

    /**
     * 将指定文件下载到指定位置
     * @param local
     * @param fileName
     * @return
     * @throws IOException
     */
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "下载文件",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
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
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "将文件数据写入到输出流里面",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean read(String fileName,OutputStream outputStream) throws IOException{
        if (outputStream == null || fileName == null){
            return  false;
        }
        Path path = new Path(fileName);
        FSDataInputStream fi = fileSystem.open(path);
        if (fi == null){
            return false;
        }
        InputStream inputStream = fi.getWrappedStream();
        InputStream temp = null;
        while ((temp = IOUtils.copy(inputStream,0,block_size,true))!=null) {
            IOUtils.write2outputStream(temp,outputStream);
        }
        inputStream.close();
        return true;
    }

    /**
     * 将指定输入流里面的数据写入到文件里面
     * @param inputStream
     * @param fileName
     * @return
     * @throws IOException
     */
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "将输入流里面的数据写入到文件里面",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public boolean write( String fileName,InputStream inputStream) throws IOException{
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
        InputStream temp = null;
        while ((temp = IOUtils.copy(inputStream,0,block_size,true)) != null){
            IOUtils.write2outputStream(temp,o);
        }
        o.close();
        return true;
    }
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "打开HDFS文件系统",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public void open() throws IOException {
        configuration = new JobConf(AZ_HDFS_FilePorvider.class);
        configuration.setBoolean( "dfs.support.append",true);
        configuration.set( "dfs.client.block.write.replace-datanode-on-failure.policy","NEVER" );
        configuration.set( "dfs.client.block.write.replace-datanode-on-failure.enable","true" );
        fileSystem = FileSystem.get(URI.create(HDFS_URL),configuration);
    }
    @AZ_LogMethod(appName = "HDFSProvider",appDesc = "关闭HDFS文件系统",type = AZ_LogType.Log4j,logTime = {AZ_LogTime.ExceptionMethod})
    public void close() throws IOException {
        fileSystem.close();
    }

    public int getBlock_size() {
        return block_size;
    }

    public void setBlock_size(int block_size) {
        this.block_size = block_size;
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
