package hdfs;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Fuzhong.Yan on 16/10/30.
 */
public class AZ_HDFS_FilePorviderTest extends BaseTest {
    @Autowired
    private AZ_HDFS_FilePorvider azHdfsFilePorvider;
    @Test
    public  void testUpload(){
        try {
//            azHdfsFilePorvider.writeBytes("I_MISS_YOU".getBytes(),"i_miss_you");
//            System.out.println(azHdfsFilePorvider.readBytes("i_miss_you").toString());
//            FileInputStream inputStream = new FileInputStream(new File("/Users/Fuzhong.Yan/Downloads/1.mkv"));
//            azHdfsFilePorvider.write(inputStream,"1.mvk");
//            inputStream.close();
//            FileOutputStream outputStream = new FileOutputStream(new File("/Users/Fuzhong.Yan/Downloads/11.mkv"));
//            azHdfsFilePorvider.read(outputStream,"1.mvk");
//            azHdfsFilePorvider.download("/Users/Fuzhong.Yan/Downloads/2.mkv","1.mvk");
            azHdfsFilePorvider.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}