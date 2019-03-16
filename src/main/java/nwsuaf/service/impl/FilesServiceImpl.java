package nwsuaf.service.impl;

import nwsuaf.model.Files;
import nwsuaf.service.FilesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wjz
 * @date 2019/3/16
 * @describe
 */
@Service
public class FilesServiceImpl implements FilesService {

    @Resource
    private FilesService filesService;

    public int filesInsert(Files files){
        return filesService.filesInsert(files);
    }

    public int filesDelete(int fileId){
        return filesService.filesDelete(fileId);
    }

    public int filesUpdate(Files files){
        return filesService.filesUpdate(files);
    }

    public Files filesFindByFileId(int fileId){
        return filesService.filesFindByFileId(fileId);
    }

    public Files filesFindByFileName(String fileName){
        return filesService.filesFindByFileName(fileName);
    }

    public List<Files> filesFindByUploader(String uploader){
        return filesService.filesFindByUploader(uploader);
    }
}
