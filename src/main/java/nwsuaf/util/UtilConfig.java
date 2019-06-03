package nwsuaf.util;


import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


/**
 * @auther LazyMan
 * @date 2019-03-16
 * @describe 项目配置
 */
public class UtilConfig {

    public UtilConfig() {
        throw new IllegalStateException("utils class");
    }

    /**
     * 本项目默认编码
     */
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8.defaultCharset();

    /**
     * 配置文件相对路径
     */
    public static final String MY_CONFIG_FILE_PATH = "myConfig.properties";

    /**
     * 文件存储路径
     */
    public static String FILE_SAVE_PATH;

    /**
     * ip 黑名单
     */
    public static Set<String> IP_BLACK_SET = new HashSet<String>();

    /**
     * 生成token用的key
     */
    public static final String SECURITY;

    /**
     * session有效期
     */
    public static final int SESSION_TIMEOUT;

    public static final int PASSWORD_LEFT = 6;
    public static final int PASSWORD_RIGHT = 20;
    public static final String PASSWORD_FORMAT = "[a-zA-Z0-9]+";

    public static final int EMAIL_RIGHT = 30;
    public static final String EMAIL_FORMAT = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$";

    static {

        Properties prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(MY_CONFIG_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        SECURITY = prop.getProperty("security");
        SESSION_TIMEOUT = Integer.parseInt(prop.getProperty("user.session.timeout"));

        FILE_SAVE_PATH = prop.getProperty("fileSavePath");

        for (int i = 0; i < 100; i++) {
            String ip = prop.getProperty("check.ip" + i);
            if (StringUtils.isBlank(ip)) {
                continue;
            }
            IP_BLACK_SET.add(ip.trim());
        }
    }
}
