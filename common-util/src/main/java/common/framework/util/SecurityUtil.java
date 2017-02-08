package common.framework.util;

import common.framework.security.*;
import org.springframework.util.Assert;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

/**
 * 安全工具类
 * Created by Fuzhong.Yan on 17/2/5.
 */
public class SecurityUtil {
    public static SecurityCoder AES(){
        return new AESUtil();
    }
    public static SecurityCoder Base64(){
        return new Base64Util();
    }
    public static SecurityCoder DES(){
        return new DESUtil();
    }
    public static SecurityCoder MD5(){
        return new MD5Util();
    }
    public static SecurityCoder RSA(String encode){
        RSAUtil rsaUtil= new RSAUtil();
        rsaUtil.setEncoded(encode);
        return rsaUtil;
    }

    /**
     * 生成密钥对
     * @param seed
     * @param keySize
     * @param algorithm
     * @return
     * @throws Exception
     */
    public static KeyPair generateKeyPair(byte[] seed,int keySize,String algorithm) throws  Exception{
        if (seed == null){
            return null;
        }
        int MIN_KEY_SIZE  = (int) Math.pow(2,9);
        int MAX_KEY_SIZE  = (int) Math.pow(2,14);
        if (keySize < MIN_KEY_SIZE){
            keySize = MIN_KEY_SIZE;
        }
        if (keySize > MAX_KEY_SIZE){
            keySize = MAX_KEY_SIZE;
        }
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(seed);
        keyPairGenerator.initialize(keySize,secureRandom);
        return keyPairGenerator.genKeyPair();
    }

    /**
     * 分段加密
     * @param securityCoder 加密器
     * @param temp 待加密数据
     * @param block_size 分段加密块数大小
     * @return
     */
    public static byte[] sub_encode(SecurityCoder securityCoder,byte[] temp,int block_size) throws Exception {
        Assert.notNull(securityCoder,"securityUtil_securityCoder_null");
        Assert.notNull(temp,"securityUtil_temp_null");
        if (block_size <= 0 ){
            block_size = (int) Math.pow(2,9);
        }
        byte[] res = null;
        for (int i=0;;i++){
            byte[] bytes = ByteUtils.read(temp,i,block_size);
            if (bytes==null){
                break;
            }
            res = ByteUtils.append(res,securityCoder.encrypt(bytes));
        }
        return res;
    }
    /**
     * 分段解密
     * @param securityCoder 解密器
     * @param temp 待解密数据
     * @param block_size 分段解密块数大小
     * @return
     */
    public static byte[] sub_decrypt(SecurityCoder securityCoder,byte[] temp,int block_size) throws Exception {
        Assert.notNull(securityCoder,"securityUtil_securityCoder_null");
        Assert.notNull(temp,"securityUtil_temp_null");
        if (block_size <= 0 ){
            block_size = (int) Math.pow(2,9);
        }
        byte[] res = null;
        for (int i=0;;i++){
            byte[] bytes = ByteUtils.read(temp,i,block_size);
            if (bytes==null){
                break;
            }
            res = ByteUtils.append(res,securityCoder.decrypt(bytes));
        }
        return res;
    }
}
