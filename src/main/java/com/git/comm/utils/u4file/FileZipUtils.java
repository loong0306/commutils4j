package com.git.comm.utils.u4file;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import java.io.File;

public class FileZipUtils {

    /**
     *
     * @param srcPath 源文件
     * @param desPath 目标文件
     */
    public static void compress(String srcPath, String desPath){
        File srcFile = new File(srcPath);// 源文件
        File desFile = new File(desPath);// 目标文件
        if (!srcFile.exists()){
            throw new RuntimeException("要压缩的文件不存在");
        }
        Project project = new Project();
        Zip zip = new Zip();
        zip.setProject(project);
        zip.setDestFile(desFile);
        FileSet fileSet = new FileSet();
        fileSet.setProject(project);
        fileSet.setDir(srcFile);
        zip.addFileset(fileSet);
        zip.execute();
    }
}
