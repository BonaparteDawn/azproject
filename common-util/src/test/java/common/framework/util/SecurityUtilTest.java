package common.framework.util;

import common.framework.security.SecurityCoder;
import org.junit.Test;

import java.security.KeyPair;

/**
 * Created by Fuzhong.Yan on 17/2/5.
 */
public class SecurityUtilTest {
    @Test
    public void AES() throws Exception {
        SecurityCoder s = SecurityUtil.AES();
        String e = s.encrypt("AES yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国");
        String d = s.decrypt(e);
        System.out.println("AES e:"+e);
        System.out.println("AES d:"+d);
    }

    @Test
    public void base64() throws Exception {
        SecurityCoder s = SecurityUtil.Base64();
        String e = s.encrypt("Base64 yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国");
        String d = s.decrypt(e);
        System.out.println("Base64 e:"+e);
        System.out.println("Base64 d:"+d);
    }

    @Test
    public void DES() throws Exception {
        SecurityCoder s = SecurityUtil.DES();
        String e = s.encrypt("DES yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国");
        String d = s.decrypt(e);
        System.out.println("DES e:"+e);
        System.out.println("DES d:"+d);
    }

    @Test
    public void MD5() throws Exception {
        SecurityCoder s = SecurityUtil.MD5();
        String e = s.encrypt("MD5 yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国");
        System.out.println("MD5 e:"+e);
    }
    @Test
    public void RSA() throws Exception {
        //生成私钥和公钥;注意明文长度最长字节为(1024/8)-11,超过部分会报异常,建议分段加密
        KeyPair p = SecurityUtil.generateKeyPair("test".getBytes(), 1024, "RSA");
        String privateEncode = ByteUtils.to16Hex(p.getPrivate().getEncoded())+",";
        String publicEncode = ","+ByteUtils.to16Hex(p.getPublic().getEncoded());
        //私钥加密
        SecurityCoder s = SecurityUtil.RSA(privateEncode);
        String e = s.encrypt("RSA 爱你中华人民共和国");
        //公钥解密
        s = SecurityUtil.RSA(publicEncode);
        String d = s.decrypt(e);
        System.out.println("RSA e:"+e);
        System.out.println("RSA d:"+d);
    }
    @Test
    public void sub_encode() throws Exception {
        //生成私钥和公钥;注意明文长度最长字节数为((1024/8)-11),超过部分会报异常,建议分段加密
        KeyPair p = SecurityUtil.generateKeyPair("test".getBytes(), 1024, "RSA");
        String privateEncode = ByteUtils.to16Hex(p.getPrivate().getEncoded())+",";
        String publicEncode = ","+ByteUtils.to16Hex(p.getPublic().getEncoded());
        //私钥加密
        SecurityCoder s = SecurityUtil.RSA(privateEncode);
        int block_size1= 1024/8-11;
        byte[] e = SecurityUtil.sub_encode(s,"yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国yfz我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国我爱你中国".getBytes(),block_size1);
        System.out.println("sub_encode:"+ByteUtils.to16Hex(e));
        //公钥解密
        s = SecurityUtil.RSA(publicEncode);
        int block_size2= 1024/8;
        byte[] b = SecurityUtil.sub_decrypt(s, e, block_size2);
        System.out.println("sub_sub_decrypt:"+new String(b));
    }
}