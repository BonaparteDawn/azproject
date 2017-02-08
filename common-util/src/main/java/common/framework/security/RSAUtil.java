package common.framework.security;

import common.framework.util.ByteUtils;

import javax.crypto.Cipher;
import java.io.Serializable;
import java.security.*;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by Fuzhong.Yan on 16/11/12.
 */
public class RSAUtil extends  SecurityCoder implements Serializable{
    /**
     * 密钥最短长度
     */
    private static int MIN_KEY_SIZE  = (int) Math.pow(2,9);
    /**
     * 密钥最长长度
     */
    private static int MAX_KEY_SIZE  = (int) Math.pow(2,14);
    /**
     * 密钥长度
     */
    private int keySize  = MIN_KEY_SIZE;
    /**
     * 密钥对
     */
    private KeyPair keyPair;

    /**
     * 公钥Key
     */
    private String publicEncodeKey;

    /**
     * 私钥Key
     */
    private String privateEncodeKey;

    /**
     * 使用私钥加密
     * @param data
     * @return
     * @throws Exception
     */
    public byte[] encrypt(byte[] data)  throws Exception{
        if (data == null){
            return null;
        }
        if ( getSeed() == null || "".equals(getSeed())){
            throw new Exception("SEED_IS_NULL");
        }
        byte[] res = null;
        productKeyPair();
        Cipher cipher = Cipher.getInstance("RSA");
        if (privateEncodeKey !=null && publicEncodeKey == null){
            cipher.init(Cipher.ENCRYPT_MODE,convert2PrivateKey(privateEncodeKey));
        }else if (publicEncodeKey != null && privateEncodeKey == null){
            cipher.init(Cipher.ENCRYPT_MODE,convert2PublicKey(publicEncodeKey));
        }else {
            cipher.init(Cipher.ENCRYPT_MODE,convert2PrivateKey(privateEncodeKey));
        }
        res = cipher.doFinal(data);
        return res;
    }

    /**
     * 使用私钥解密
     * @param data
     * @return
     * @throws Exception
     */
    public byte[] decrypt(byte[] data)  throws Exception{
        if (data == null){
            return null;
        }
        if ( getSeed() == null || "".equals(getSeed())){
            throw new Exception("SEED_IS_NULL");
        }
        byte[] res = null;
        productKeyPair();
        Cipher cipher = Cipher.getInstance("RSA");
        if (privateEncodeKey !=null && publicEncodeKey == null){
            cipher.init(Cipher.DECRYPT_MODE,convert2PrivateKey(privateEncodeKey));
        }else if (publicEncodeKey != null && privateEncodeKey == null){
            cipher.init(Cipher.DECRYPT_MODE,convert2PublicKey(publicEncodeKey));
        }else {
            cipher.init(Cipher.DECRYPT_MODE,convert2PrivateKey(privateEncodeKey));
        }
        res = cipher.doFinal(data);
        return res;
    }



    public void productKeyPair() throws Exception{
        if (keyPair == null && privateEncodeKey == null && publicEncodeKey == null){
            keyPair = generateKeyPair(getSeed().getBytes());
            if (keyPair != null){
                publicEncodeKey = ByteUtils.to16Hex(keyPair.getPublic().getEncoded());
                privateEncodeKey = ByteUtils.to16Hex(keyPair.getPrivate().getEncoded());
            }else{
                throw new Exception("KEY_PAIR_IS_NULL");
            }
        }else {
            return;
        }
    }

    private KeyPair generateKeyPair(byte[] seed) throws  Exception{
        if (seed == null){
            return null;
        }
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(seed);
        keyPairGenerator.initialize(getKeySize(),secureRandom);
        return keyPairGenerator.genKeyPair();
    }

    public int getKeySize() {
        if (keySize < MIN_KEY_SIZE){
            keySize = MIN_KEY_SIZE;
        }
        if (keySize > MAX_KEY_SIZE){
            keySize = MAX_KEY_SIZE;
        }
        return keySize;
    }

    public String getPublicEncodeKey() throws Exception {
        return publicEncodeKey;
    }

    private PublicKey convert2PublicKey(String publicEncodeKey)  throws  Exception{
        KeyFactory kf = KeyFactory.getInstance("RSA");
        KeySpec a = new X509EncodedKeySpec(ByteUtils.toBytes(publicEncodeKey));
        PublicKey publicKey = kf.generatePublic(a);
        return publicKey;
    }

    private PrivateKey convert2PrivateKey(String privateEncodeKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(ByteUtils.toBytes(privateEncodeKey));
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public void setPublicEncodeKey(String publicEncodeKey) throws  Exception{
        this.publicEncodeKey = publicEncodeKey;
        this.privateEncodeKey = null;
    }

    public String getPrivateEncodeKey() throws Exception {
        return privateEncodeKey;
    }

    public void setPrivateEncodeKey(String privateEncodeKey) throws Exception{
        this.privateEncodeKey = privateEncodeKey;
        this.publicEncodeKey = null;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    @Override
    public String getEncoded() {
        super.setEncoded(privateEncodeKey+","+publicEncodeKey);
        return super.getEncoded();
    }

    @Override
    public void setEncoded(String encoded) {
        super.setEncoded(encoded);
        String temp = encoded.replaceAll("\\s","");
        String[] s = temp.split(",");
        if (s!=null && s.length == 1){
            privateEncodeKey = s[0];
        }
        if (s!=null && s.length ==2 && s[0]!=null && !"".equals(s[0])){
            privateEncodeKey = s[0];
            publicEncodeKey = null;
        }else if (s!=null && s.length ==2 && s[1]!=null && !"".equals(s[1])){
            privateEncodeKey = null;
            publicEncodeKey = s[1];
        }
    }
}
