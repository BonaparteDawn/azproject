package common.framework.security;

import common.framework.util.ByteUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.SecureRandom;

/**
 * Created by Fuzhong.Yan on 16/11/13.
 */
public class AESUtil extends  SecurityCoder implements Serializable {
    private int keySize = 128;
    public byte[] encrypt(byte[] data) throws Exception {
        if (data == null){
            return  null;
        }
        SecretKeySpec key = new SecretKeySpec(generateEncode(), "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        return cipher.doFinal(data);
    }

    public byte[] decrypt(byte[] data) throws Exception {
        if (data == null){
            return  null;
        }
        SecretKeySpec key = new SecretKeySpec(generateEncode(), "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        return cipher.doFinal(data);
    }
    private byte[] generateEncode() throws Exception {
        if ( getSeed() == null || "".equals(getSeed())){
            throw new Exception("SEED_IS_NULL");
        }
        byte[] enCodeFormat = null;
        if (getEncoded() == null){
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(getKeySize(), new SecureRandom(getSeed().getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            enCodeFormat = secretKey.getEncoded();
            setEncoded(ByteUtils.to16Hex(enCodeFormat));
        }else {
            enCodeFormat = ByteUtils.toBytes(getEncoded());
        }
        return enCodeFormat;
    }

    public int getKeySize() {
        if (keySize !=128 && keySize!=192 && keySize!=256){
            keySize = 128;
        }
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }
}
