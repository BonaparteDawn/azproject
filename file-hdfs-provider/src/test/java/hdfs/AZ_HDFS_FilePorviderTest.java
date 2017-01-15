package hdfs;

import com.alibaba.dubbo.container.spring.SpringContainer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class AZ_HDFS_FilePorviderTest extends BaseTest{
    @Autowired
    private AZ_HDFS_FilePorvider azHdfsFilePorvider;
    @Test
    public  void testUpload(){
        try {
//            azHdfsFilePorvider.writeBytes("I_MISS_YOU".getBytes(),"i_miss_you");
//            System.out.println(azHdfsFilePorvider.readBytes("i_miss_you").toString());
//            azHdfsFilePorvider.appendBytes("nihao".getBytes(),"i_miss_you");
//            azHdfsFilePorvider.close();
//            azHdfsFilePorvider.deleteFile("i_miss_you");
//            FileInputStream inputstream = new FileInputStream(new File("/Users/Fuzhong.Yan/Downloads/1.mp4"));
//            byte[] block_temp = new byte[1024*5];
//            int b_t_size = 0;
//            while((b_t_size = inputstream.read(block_temp)) > 0){
//                byte[]  block_out = new byte[b_t_size];
//                block_temp = new byte[1024*5];
//                System.arraycopy(block_temp,0,block_out,0,b_t_size-1);
//                boolean append_t = azHdfsFilePorvider.writeBytes(block_out,"7.mvk");
//                if (append_t == false){
//                    break;
//                }
//            }
//            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(new File("/Users/Fuzhong.Yan/Downloads/222.rar"));
//            azHdfsFilePorvider.read("312f3132332f6e756c6c6d6574726f6e6963342e352e362e726172",outputStream);
            long skip = 0;
            for (int i = 0 ; i < 1024*10;i++){
              byte[] bytes = azHdfsFilePorvider.readBytes("312f3132332f6e756c6c6d6574726f6e6963342e352e362e726172",skip,1024*1024*5);
                if (bytes == null){
                    break;
                }
                skip+=bytes.length;
                outputStream.write(bytes);
                outputStream.flush();
            }
            outputStream.close();
//            azHdfsFilePorvider.read(outputStream,"312f3132332f6e756c6c312e6d7034");
//            azHdfsFilePorvider.download("/Users/Fuzhong.Yan/Downloads/2.mkv","1.mvk");
//            azHdfsFilePorvider.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}