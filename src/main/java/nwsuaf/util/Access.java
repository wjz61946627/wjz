package nwsuaf.util;

/**
 * @auther LazyMan
 * @date 2019-05-27
 * @describe 权限枚举，小端编码
 */
public enum Access {
    /**
     * 文件-读取'
     */
    READ(0),

    /**
     * 文件-上传
     */
    UPLOAD(1),

    /**
     * 文件-删除
     */
    DELETE(2),

    //
    ;

    private int index;

    private Access(int index) {
        this.index = index;
    }
}
