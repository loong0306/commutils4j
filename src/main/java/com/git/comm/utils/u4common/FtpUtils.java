package com.git.comm.utils.u4common;

import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.provider.ftp.FtpFileSystemConfigBuilder;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

import java.io.IOException;

/**
 * FtpUtils
 */
public class FtpUtils {

    /**
     * 得到远程文件列表
     */
    public static FileObject[] getFilesByFtp(String url){
        FileObject[] fileObjects = null;
        try {
            FileSystemManager fsManager = VFS.getManager();
            FileObject fo = fsManager.resolveFile(url);
            FileSystemOptions options = new FileSystemOptions();
            FtpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(options, false);
            fileObjects = fo.getChildren();
        } catch (FileSystemException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileObjects;
    }

    /**
     * 筛选所需文件
     */
    public static FileObject[] getNeedFiles(String url){
        FileObject[] fileObjects = getFilesByFtp(url);
        FileObject[] newFileObjects = null;
        for (int i = 0; i < fileObjects.length; i++){
            // 在此处做文件筛选
        }
        return newFileObjects;
    }

    /**
     * ftp/sftp
     * 通过前置服务器无跳板机上传至所需服务器
     * @param sourcePath 前置服务器地址
     * @param targetPath 上传服务器地址
     * @throws FileSystemException
     */
    public static void copyFile(String sourcePath, String targetPath) throws FileSystemException {
        try {
            FileObject[] getDownloadFiles = null;
            // 获取需要上传的文件
            FileSystemManager fsManager = VFS.getManager();
            // 全部文件
            getDownloadFiles = getFilesByFtp(sourcePath);
            // 如需筛选，选用下面方法
            // getDownloadFiles = getNeedFiles(sourcePath);
            // 上传文件至服务器
            FileSystemOptions opts = new FileSystemOptions();;
            SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
            FileObject getUploadFiles = fsManager.resolveFile(targetPath, opts);
            for (int i = 0; i < getDownloadFiles.length; i++) {
                FileObject tmp = fsManager.resolveFile(getUploadFiles, getDownloadFiles[i].getName().getBaseName());
                if (!tmp.exists()) {
                   tmp.copyFrom(getDownloadFiles[i], Selectors.SELECT_SELF);
                }
            }
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }
}
