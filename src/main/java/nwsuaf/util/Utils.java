package nwsuaf.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

/**
 * @auther LazyMan
 * @date 2019-03-17
 * @describe 工具集
 */
public class Utils {

    /**
     * 支持 127.0.0.1 and 127.0.0.1/12
     */
    private static final String IP_PATTER = "";

    public static boolean isIp(String ip) {
        return ip.matches(IP_PATTER);
    }

    /**
     * ip 在sets集合中
     */
    public static boolean ipMatchSet(String ip, Set<String> sets) {
        for (String network : sets) {
            if (ipEqual(ip, network)) {
                return true;
            }
        }

        return false;
    }

    /**
     * ip 在network网段中
     */
    public static boolean ipEqual(String ip, String network) {
        return false;
    }

    /**
     * md5
     */
    public static String md5(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        return new BigInteger(1, md.digest()).toString();
    }
}
