package nwsuaf.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;

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
     * 结果返回
     */
    public static final String RESULT = "result";

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    private static final String CONNECT = "&";

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
    public static String md5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        md.update(str.getBytes());
        String result = new BigInteger(1, md.digest()).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - result.length(); i++) {
            result = "0" + result;
        }
        return result;
    }

    public static String securityMD5(String content) {
        StringBuilder result = new StringBuilder();
        result.append(content);
        result.append(CONNECT);
        result.append(UtilConfig.SECURITY);
        return md5(result.toString());
    }

    /**
     * 检查密码
     */
    public static boolean checkPassword(String password) {
        // 不可为空
        if (StringUtils.isBlank(password)) {
            return false;
        }

        // 长度不对
        if (password.length() < UtilConfig.PASSWORD_LEFT || password.length() > UtilConfig.PASSWORD_RIGHT) {
            return false;
        }

        // 格式不对
        if (!password.matches(UtilConfig.PASSWORD_FORMAT)) {
            return false;
        }

        return true;
    }

    /**
     * 检查邮箱
     */
    public static boolean checkEmail(String email) {
        // 不可为空
        if (StringUtils.isBlank(email)) {
            return false;
        }

        // 长度不对
        if (email.length() > UtilConfig.EMAIL_RIGHT) {
            return false;
        }

        // 格式不对
        if (!email.matches(UtilConfig.EMAIL_FORMAT)) {
            return false;
        }

        return true;
    }

    public static JsonElement objectToJson(Object value) {
        return new JsonParser().parse(new Gson().toJson(value));
    }
}
