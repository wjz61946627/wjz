package nwsuaf.util;


import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;


/**
 * @auther LazyMan
 * @date 2019-03-16
 * @describe 项目配置
 */
public class UtilConfig {

    public UtilConfig() {
        throw new IllegalStateException("utils class");
    }

    /** 本项目默认编码 */
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8.defaultCharset();

    /**
     * 配置文件相对路径
     */
    public static final String MY_CONFIG_FILE_PATH = "myConfig.properties";

    /**
     * 文件存储路径
     */
    public static String FILE_SAVE_PATH;



    static {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(MY_CONFIG_FILE_PATH));

        FILE_SAVE_PATH = prop.getProperty("fileSavePath");
    }

}
