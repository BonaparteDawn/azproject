package common.framework.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.Serializable;

/**
 * Base64加密器
 * Created by Fuzhong.Yan on 16/11/12.
 */
public class Base64Util extends SecurityCoder implements Serializable{
    public byte[] encrypt(byte[] data) throws Exception{
        if (data == null){
            return  null;
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data).getBytes();
    }

    public byte[] decrypt(byte[] data)throws Exception{
        if (data==null){
            return  null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(new String(data));
    }

}
