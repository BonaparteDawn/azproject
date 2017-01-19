package common.framework.util;

import org.springframework.util.Assert;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * Created by Fuzhong.Yan on 17/1/18.
 */
public class InternetUtil {
    /**
     * 网络超时
     */
    private static int DEFAULT_TIME_OUT = 3000;

    /**
     * ping网络IP地址
     * @param ip
     * @return
     * @throws IOException
     */
    public static boolean ping(String ip) throws IOException {
        Assert.hasLength(ip,"IP_LEN0");
        return InetAddress.getByName(ip).isReachable(DEFAULT_TIME_OUT);
    }

    /**
     * ping网络IP地址
     * @param ip
     * @param time_out
     * @return
     * @throws IOException
     */
    public static boolean ping(String ip,int time_out) throws IOException {
        Assert.hasLength(ip,"IP_LEN0");
        if (time_out <= 0){
            time_out = DEFAULT_TIME_OUT;
        }
        return InetAddress.getByName(ip).isReachable(time_out);
    }

    /**
     * 从指定URL访问资源
     * @param url_address
     * @return
     * @throws MalformedURLException
     */
    public static String accessResource(String url_address) throws IOException{
        Assert.notNull(url_address,"url_address_null");
        URL url = new URL(url_address);
        URLConnection ct = url.openConnection();
        ct.setReadTimeout(DEFAULT_TIME_OUT);
        ct.setDoInput(true);
        ct.setConnectTimeout(DEFAULT_TIME_OUT);
        InputStream inputStream = ct.getInputStream();
        String res = IOUtils.read(inputStream);
        inputStream.close();
        return res;
    }
}
