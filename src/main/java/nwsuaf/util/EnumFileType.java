package nwsuaf.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther LazyMan
 * @date 2019-05-31
 * @describe 文件类型
 */
public enum EnumFileType {
    /**
     * 文档
     */
    WORLD(".docx", ".doc"),

    /**
     * 表格
     */
    EXCEL(".xlsx", ".xls"),

    /**
     * cad图
     */
    CAD(".dwg")
    //
    ;

    // 文件后缀
    private Set<String> suffix;

    private EnumFileType(String... suffixs) {
        suffix = new HashSet<>();

        for (String s : suffixs) {
            suffix.add(s);
        }
    }

    /**
     * 是否属于当前类型
     */
    public boolean isMy(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index < 0) {
            return false;
        }
        // 截取文件后缀
        return suffix.contains(fileName.substring(index));
    }

    /**
     * 检查文件类型是否合法
     */
    public static boolean checkFileType(String fileName) {
        boolean result = false;
        for (EnumFileType fileType : EnumFileType.values()) {
            if (!fileType.isMy(fileName)) {
                result = true;
            }
        }

        return result;
    }
}
