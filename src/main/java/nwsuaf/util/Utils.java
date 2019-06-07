package nwsuaf.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
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
    public static final String MSG = "msg";

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    private static final String CONNECT = "&";

    /**
     * pdf文件后缀
     */
    public static final String PDF_SUFFIX = ".pdf";

    /**
     * 支持 127.0.0.1 and 127.0.0.1/12
     */
    private static final String IP_PATTER = "([0-9]{1,3}\\.){3}[0-9]{1,3}(/[0-9]{1,2})*";

    public static boolean isIp(String ip) {
        return ip.matches(IP_PATTER);
    }

    /**
     * ip 在sets集合中
     */
    public static boolean ipMatchSet(String ip, Set<String> sets) {
        if (!ip.matches(IP_PATTER)) {
            return false;
        }

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
    public static boolean ipEqual(String ip, String cidr) {
        String[] ips = ip.split("\\.");
        int ipAddr = (Integer.parseInt(ips[0]) << 24) | (Integer.parseInt(ips[1]) << 16) | (Integer.parseInt(ips[2]) << 8) | Integer.parseInt(ips[3]);
        int type = 32;
        if (cidr.indexOf("/") >= 0) {
            type = Integer.parseInt(cidr.replaceAll(".*/", ""));
        }
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.replaceAll("/.*", "");
        String[] cidrIps = cidrIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24) | (Integer.parseInt(cidrIps[1]) << 16) | (Integer.parseInt(cidrIps[2]) << 8) | Integer.parseInt(cidrIps[3]);

        return (ipAddr & mask) == (cidrIpAddr & mask);
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

    /**
     * path=path/pid/filename
     */
    public static String absolutePath(int pid, String fileName) {
        StringBuilder result = new StringBuilder();
        result.append(UtilConfig.FILE_SAVE_PATH);
        result.append(File.separator);
        result.append(pid);
        result.append(File.separator);
        result.append(fileName);
        return result.toString();
    }

    /**
     * 带后缀名带文件名转化成pdf文件名
     */
    public static String fileNameToPDF(String fileName) {
        if (EnumFileType.PDF.isMy(fileName) || EnumFileType.CAD.isMy(fileName)) {
            return fileName;
        }
        return fileName.replace(".", "_") + Utils.PDF_SUFFIX;
    }

    public static boolean convertToPDF(String srcPath, String targetPath) {
        if (EnumFileType.WORLD.isMy(srcPath)) {
            return PDFUtils.doc2pdf(srcPath, targetPath);
        }

        if (EnumFileType.EXCEL.isMy(srcPath)) {
            return PDFUtils.excel2pdf(srcPath, targetPath);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(fileNameToPDF("aaa.xls"));
        System.out.println(EnumFileType.EXCEL.isMy("aaa.xls"));

        System.out.println((5 >> 2) & 1);
    }
}
