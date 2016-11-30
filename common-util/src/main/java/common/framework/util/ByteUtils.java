package common.framework.util;

import java.math.BigInteger;

/**
 * Created by Fuzhong.Yan on 16/11/12.
 */
public class ByteUtils {
    /**
     * 将byte[]转为16进制的字符串
     * @param bytes byte[]
     */
    public static String to16Hex(byte[] bytes) throws Exception{
        String res = null;
        if (bytes != null && bytes.length !=0) {
            //radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制转换后的字符串
            res = new BigInteger(1, bytes).toString(16);
        }
        return res;
    }

    /**
     * 将16进制的字符串转为字节
     * @param hex
     * @return
     */
    public static byte[] toBytes(String hex){
        byte[] res = null;
        if (hex != null && !"".equals(hex)) {
            res = new BigInteger(hex, 16).toByteArray();
            if (res[0] == 0) {
                byte[] tmp = new byte[res.length - 1];
                System.arraycopy(res, 1, tmp, 0, tmp.length);
                res = tmp;
            }
        }
        return res;
    }
}
