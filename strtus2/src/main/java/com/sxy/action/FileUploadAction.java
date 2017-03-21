package com.sxy.action;

import java.io.File;

/**
 * Created by Administrator on 2017/3/20.
 */
public class FileUploadAction extends BaseAction {

    private File file;
    private String fileFileName;
    private String fileContentType;


    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    public String upload(){
        System.out.println(fileFileName);
        System.out.println(fileContentType);
        return SUCCESS;
    }

    public String list(){
        return SUCCESS;
    }

    //get set


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileFileName;
    }

    public void setFileName(String fileName) {
        fileFileName = fileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
}
