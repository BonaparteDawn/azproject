package common.framework.security;

import common.framework.util.ByteUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.SecureRandom;

/**
 DES加密介绍
 DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 */
public class DESUtil extends  SecurityCoder implements Serializable{

    public byte[] encrypt(byte[] data) throws Exception {
        if (data == null){
            return  null;
        }
        SecretKeySpec key = new SecretKeySpec(generateEncode(), "DES");
        Cipher cipher = Cipher.getInstance("DES");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        return cipher.doFinal(data);
    }

    public byte[] decrypt(byte[] data) throws Exception {
        if (data == null){
            return  null;
        }
        SecretKeySpec key = new SecretKeySpec(generateEncode(), "DES");
        Cipher cipher = Cipher.getInstance("DES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        return cipher.doFinal(data);
    }

    private byte[] generateEncode() throws Exception {
        if ( getSeed() == null || "".equals(getSeed())){
            throw new Exception("SEED_IS_NULL");
        }
        byte[] enCodeFormat = null;
        if (getEncoded() == null){
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56, new SecureRandom(getSeed().getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            enCodeFormat = secretKey.getEncoded();
            setEncoded(ByteUtils.to16Hex(enCodeFormat));
        }else {
            enCodeFormat = ByteUtils.toBytes(getEncoded());
        }
        return enCodeFormat;
    }
}
