package common.framework.security;

import common.framework.util.ByteUtils;
import java.util.UUID;

/**
 * 用于各种加密算法的接口
 * Created by Fuzhong.Yan on 16/11/12.
 */
public abstract class SecurityCoder {
    /**
     * 安全种子
     */
    private String seed;

    /**
     * encoded
     */
    private String encoded;

    /**
     * 加密
     * @param data
     * @return
     */
    public abstract   byte[] encrypt(byte[] data) throws Exception;
    /**
     * 解密
     * @param data
     * @return
     */
    public abstract byte[] decrypt(byte[] data) throws Exception;


    /**
     * 加密
     * @param data
     * @return
     */
    public  String encrypt(String data) throws Exception{
        byte[] res = encrypt(data.getBytes());
        if (res == null){
            return null;
        }
        return ByteUtils.to16Hex(res);
    }
    /**
     * 解密
     * @param data
     * @return
     */
    public  String decrypt(String data) throws Exception{
        byte[] res = decrypt(ByteUtils.toBytes(data));
        if (res == null){
            return  null;
        }
        return new String(res);
    }

    public String getEncoded() {
        return encoded;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    public String getSeed() {
        if (seed == null || "".equals(seed)){
            seed = UUID.randomUUID().toString();
        }
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
