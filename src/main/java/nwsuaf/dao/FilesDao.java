package nwsuaf.dao;

import nwsuaf.model.Files;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
public interface FilesDao {

    public int filesInsert(Files files);

    public int filesDelete(int fileId);

    public int filesUpdate(Files files);

    public Files filesFindByFileId(int fileId);

    public Files filesFindByFileName(String fileName);
}
