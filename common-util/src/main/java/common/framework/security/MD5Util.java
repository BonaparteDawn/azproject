package common.framework.security;

import enums.AZ_LogType;
import common.framework.interfaces.Log;
import common.framework.interfaces.MessageSummary;
import common.framework.service.AZ_LogFactory;
import common.framework.util.ByteUtils;
import constant.AZ_Constant;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Fuzhong.Yan on 16/11/12.
 */
public class MD5Util extends SecurityCoder implements MessageSummary, Serializable{

    private Log log = AZ_LogFactory.productLog(AZ_LogType.Log4j,MD5Util.class);

    public byte[] encrypt(byte[] data)  throws Exception{
        if (data == null){
            return null;
        }
        MessageDigest md = getMessageDigest();
        md.update(data);
        return md.digest();
    }

    public byte[] decrypt(byte[] data) throws Exception {
        log.error("DECRYPT_UNSUPPORTED");
        throw new Exception("DECRYPT_UNSUPPORTED");//不支持解密
    }

    /**
     * 获得输入流的MD5值
     *
     * @param inputStream
     * @return
     */
    public String productSummary(InputStream inputStream) throws IOException {
        Assert.notNull(inputStream,"INPUT_STREAM_IS_NULL");
        String res = null;
        long inputSize = inputStream.available()/AZ_Constant.FILE_BLOCK_UNIT_M;
        long startTime = System.currentTimeMillis();
        try {
            MessageDigest messageDigest = getMessageDigest();
            DigestInputStream digestInputStream = new DigestInputStream(inputStream,messageDigest);
            // read的过程中进行MD5处理，直到读完文件
            byte[] buffer =new byte[AZ_Constant.FILE_BLOCK_SIZE*AZ_Constant.FILE_BLOCK_UNIT_M];
            while (digestInputStream.read(buffer) > 0);
            // 获取最终的MessageDigest
            messageDigest= digestInputStream.getMessageDigest();
            // 拿到结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
            try {
                res = ByteUtils.to16Hex(resultByteArray);
            } catch (Exception e) {
                log.error(e.getMessage(),e);
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(),e);
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        log.info("数据流的大小:"+inputSize+"M");
        log.info("MD5值为:"+res);
        log.info("MD5耗时:"+(endTime-startTime)/1000.0+" s");
        return res;
    }

    private MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5");
    }
}
