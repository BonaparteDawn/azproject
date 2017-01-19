package common.framework.util;

import constant.AZ_Constant;

import java.io.*;
import java.nio.Buffer;

/**
 * Created by Fuzhong.Yan on 17/1/3.
 */
public class IOUtils {
    /**
     * 获取输入流中的指定块的字节数据流
     * @param inputStream
     * @param skip_size
     * @param block_size
     * @param untilNull(true:直到数据流结束,否则必须返回指定块大小的数据)
     * @return
     * @throws IOException
     */
    public static InputStream copy(InputStream inputStream,long skip_size,int block_size,boolean untilNull) throws IOException {
        if (inputStream == null){
            return null;
        }
        if (skip_size < 0){
            skip_size = 0;
        }
        if (block_size < 0){
            block_size = AZ_Constant.FILE_BLOCK_SIZE*AZ_Constant.FILE_BLOCK_UNIT_M;
        }
        byte[] bytes = null;
        if (untilNull){
            bytes = copy2Bytes(inputStream,skip_size,block_size,true);
        }else {
            bytes = copy2Bytes(inputStream,skip_size,block_size);
        }
        if (bytes == null){
            return null;
        }
        return new ByteArrayInputStream(bytes);
    }
    /**
     * 获取输入流中的指定块的字节数据流
     * @param inputStream
     * @param skip_size
     * @param block_size
     * @return
     * @throws IOException
     */
    public static InputStream copy(InputStream inputStream,long skip_size,int block_size) throws IOException {
        if (inputStream == null){
            return null;
        }
        if (skip_size < 0){
            skip_size = 0;
        }
        if (block_size < 0){
            block_size = AZ_Constant.FILE_BLOCK_SIZE*AZ_Constant.FILE_BLOCK_UNIT_M;
        }
        byte[] bytes = copy2Bytes(inputStream,skip_size,block_size);
        if (bytes == null){
            return null;
        }
        return new ByteArrayInputStream(bytes);
    }
    /**
     * 获取输入流中的指定块的字节数据流
     * @param inputStream
     * @param skip_size
     * @param block_size
     * @return
     * @throws IOException
     */
    public static byte[] copy2Bytes(InputStream inputStream,long skip_size,int block_size) throws IOException {
        if (inputStream == null){
            return null;
        }
        if (skip_size < 0){
            skip_size = 0;
        }
        if (block_size < 0){
            block_size = AZ_Constant.FILE_BLOCK_SIZE*AZ_Constant.FILE_BLOCK_UNIT_M;
        }
        inputStream.skip(skip_size);
        byte[] bytes = new byte[block_size];
        int size = inputStream.read(bytes);
        if (size < 0){
            return null;
        }
        byte[] temp = new byte[size];
        System.arraycopy(bytes,0,temp,0,size);
        return temp;
    }
    /**
     * 获取输入流中的指定块的字节数据流
     * @param inputStream
     * @param skip_size
     * @param block_size
     * @param untilNull(true:直到数据流结束,否则必须返回指定块大小的数据)
     * @return
     * @throws IOException
     */
    public static byte[] copy2Bytes(InputStream inputStream,long skip_size,int block_size,boolean untilNull) throws IOException {
        if (inputStream == null){
            return null;
        }
        if (skip_size < 0){
            skip_size = 0;
        }
        if (block_size < 0){
            block_size = AZ_Constant.FILE_BLOCK_SIZE*AZ_Constant.FILE_BLOCK_UNIT_M;
        }
        byte[] res = null;
        if (untilNull){
            int remain = block_size;
            while (remain > 0){
                byte [] temp= IOUtils.copy2Bytes(inputStream,skip_size,remain);
                if (temp == null){
                    break;
                }
                res = ByteUtils.append(res,temp);
                remain-=temp.length;
                skip_size = 0;
            }
        }else {
            res = IOUtils.copy2Bytes(inputStream,skip_size,block_size);
        }
        return res;
    }
    /**
     * 将输入流里面的数据写入到输出流里面
     * @param inputStream
     * @param outputStream
     * @param max_block_num
     * @param block_size
     * @return
     * @throws IOException
     */
    public static boolean write2outputStream(InputStream inputStream, OutputStream outputStream,long max_block_num,int block_size) throws IOException {
        if (inputStream == null || outputStream == null){
            return false;
        }
        if (max_block_num < 0){
            max_block_num = 1;
        }
        if (block_size < 0){
            block_size = AZ_Constant.FILE_BLOCK_SIZE*AZ_Constant.FILE_BLOCK_UNIT_M;
        }
        for (int i =0; i < max_block_num ; i++){
            byte[] bytes = new byte[block_size];
            int a_size = inputStream.read(bytes);
            if (a_size < 0){
                break;
            }
            byte[] temp = new byte[a_size];
            System.arraycopy(bytes,0,temp,0,a_size);
            outputStream.write(temp);
            outputStream.flush();
        }
        return true;
    }
    /**
     * 将输入流里面的数据写入到输出流里面
     * @param inputStream
     * @param outputStream
     * @return
     * @throws IOException
     */
    public static boolean write2outputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        boolean res = false;
        if (inputStream == null || outputStream == null){
            return false;
        }
        byte[] bytes = new byte[inputStream.available()];
        int a_size = inputStream.read(bytes);
        if (a_size > 0){
            outputStream.write(bytes);
            outputStream.flush();
            res = true;

        }
        return res;
    }
    /**
     * 将输入流里面的数据写入到输出流里面
     * @param bytes
     * @param outputStream
     * @return
     * @throws IOException
     */
    public static boolean write2outputStream(byte[] bytes, OutputStream outputStream) throws IOException {
        if (bytes == null || outputStream == null){
            return false;
        }
        outputStream.write(bytes);
        outputStream.flush();
        return true;
    }

    /**
     * 将数据流里面的数据读取出来,保存成字符串
     * @param inputStream
     * @return
     */
    public static String read(InputStream inputStream) throws IOException {
        if (inputStream == null){
            return null;
        }
        String res = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (write2outputStream(inputStream, outputStream)){
            res = outputStream.toString();
        }
        outputStream.close();
        return res;
    }
}
