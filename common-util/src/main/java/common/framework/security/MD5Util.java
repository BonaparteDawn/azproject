package common.framework.security;

import java.io.Serializable;
import java.security.MessageDigest;

/**
 * Created by Fuzhong.Yan on 16/11/12.
 */
public class MD5Util extends SecurityCoder implements Serializable{
    public byte[] encrypt(byte[] data)  throws Exception{
        if (data == null){
            return null;
        }
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data);
        return md.digest();
    }

    public byte[] decrypt(byte[] data) throws Exception {
        throw new Exception("DECRYPT_UNSUPPORTED");//不支持解密
    }

}
