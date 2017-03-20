/*
package com.capital.operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.uzmap.pkg.uzcore.uzmodule.*;
import com.uzmap.pkg.uzcore.*;
import android.widget.*;
import org.jetbrains.annotations.Contract;
import org.json.JSONArray;
import org.json.JSONObject;

public class AndroidFileHelp {
    */
/**
     * SD卡路径 (sdcard)
     *//*

    private String SDPATH;
    */
/**
     * 私有文件夹（data/data/包名/files）
     *//*

    private String FILESPATH;
    */
/**
     * 私有数据文件夹 data/data/包名/app_database
     *//*

    private String DATAPATH;

    public AndroidFileHelp(UZAppActivity mContext) {
        SDPATH = Environment.getExternalStorageDirectory().getPath() + "//";//初始化内存卡地址
        FILESPATH = mContext.getFilesDir().getPath() + "//";//初始化私有文件地址
        DATAPATH = mContext.getDataDir().getPath() + "//";//初始化私有数据库地址
    }

    */
/**
     * SD卡存在，可以读写
     *
     * @return
     *//*

    private boolean isSDCardState() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    */
/**
     * 获取SDCard文件路径
     *//*

    public String getSDCardPath() {
        if (isSDCardState()) {//如果SDCard存在并且可以读写
            SDPATH = Environment.getExternalStorageDirectory().getPath();
            return SDPATH;
        } else {
            return null;
        }
    }

    */
/**
     * 获取SDCard 总容量大小(MB)
     *//*

    public long getSDCardTotal() {
        if (null != getSDCardPath() && "".equals(getSDCardPath())) {
            StatFs statfs = new StatFs(getSDCardPath());
            //获取SDCard的Block总数
            long totalBlocks = statfs.getBlockCount();
            //获取每个block的大小
            long blockSize = statfs.getBlockSize();
            //计算SDCard 总容量大小MB
            long SDtotalSize = totalBlocks * blockSize / 1024 / 1024;
            return SDtotalSize;
        } else {
            return 0;
        }
    }

    */
/**
     * 获取SDCard 可用容量大小(MB)
     *//*

    public long getSDCardFree() {
        if (null != getSDCardPath() && "".equals(getSDCardPath())) {
            StatFs statfs = new StatFs(getSDCardPath());
            //获取SDCard的Block可用数
            long availaBlocks = statfs.getAvailableBlocks();
            //获取每个block的大小
            long blockSize = statfs.getBlockSize();
            //计算SDCard 可用容量大小MB
            long SDFreeSize = availaBlocks * blockSize / 1024 / 1024;
            return SDFreeSize;
        } else {
            return 0;
        }
    }

    */
/**
     * 在SD卡上创建目录
     *
     * @param dirName 要创建的目录名
     * @return 创建得到的目录
     *//*

    public String createSDDirection(String dirName) {
        if (null != dirName && "".equals(dirName)) {
            if (null == SDPATH) {
                SDPATH = getSDCardPath();
            }
            if (null == SDPATH) {
                return null;
            }
            File dir = new File(SDPATH + dirName);
            if (dir.mkdir() && dir.exists()) {
                return dir.getPath();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    */
/**
     * 删除SD卡上的目录
     *
     * @param dirName 文件夹名字
     *//*

    public boolean deleteSDDirection(String dirName) {
        if (null == SDPATH) {
            SDPATH = getSDCardPath();
        }
        if (null == SDPATH) {
            return false;
        }
        File dir = new File(SDPATH + dirName);
        return deleteDirection(dir);
    }

    */
/**
     * 删除SD卡上的文件
     *
     * @param fileName 文件名
     *//*

    public boolean deleteSDFile(String fileName) {
        if (null == SDPATH) {
            SDPATH = getSDCardPath();
        }
        if (null == SDPATH) {
            return false;
        }
        File file = new File(SDPATH + fileName);
        return deleteFile(file);
    }

    */
/**
     * 修改SD卡上的文件或目录名
     *
     * @param oldName 原文件件名字
     * @param newName 新文件夹名字
     * @return
     *//*

    public boolean renameSDFile(String oldName, String newName) {
        if (null == SDPATH) {
            SDPATH = getSDCardPath();
        }
        if (null == SDPATH) {
            return false;
        }
        File oleFile = new File(SDPATH + oldName);
        File newFile = new File(SDPATH + newName);
        return oleFile.renameTo(newFile);
    }

    */
/**
     * 复制文件
     *
     * @param oldFileName 原文件
     * @param newFileName 副本文件
     * @return
     *//*

    public boolean copySDFile(String oldFileName, String newFileName) {
        File srcFile = new File(SDPATH + oldFileName);
        File destFile = new File(SDPATH + newFileName);
        return copyFile(srcFile, destFile);
    }

    */
/**
     * 移动单个文件
     *
     * @param oldFileName 原文件
     * @param newFileName 新文件
     * @return
     *//*

    public boolean moveSDFile(String oldFileName, String newFileName) {
        File srcFile = new File(SDPATH + oldFileName);
        File destFile = new File(SDPATH + newFileName);
        return moveFile(srcFile, destFile);
    }

    */
/**
     * 移动指定文件夹下所有文件
     *
     * @param oldDirName 原文件夹名字
     * @param newDirName 新文件夹名字
     * @return
     *//*

    public boolean moveSDFiles(String oldDirName, String newDirName) {
        File srcDir = new File(SDPATH + oldDirName);
        File destDir = new File(SDPATH + newDirName);
        return moveFiles(srcDir, destDir);
    }

    */
/**
     * 删除私有数据文件
     *
     * @param fileName 数据文件名
     * @return
     *//*

    public boolean deleteDataFile(String fileName) {
        File file = new File(DATAPATH + fileName);
        return deleteFile(file);
    }

    public boolean copyDataFiles(String oldDirName, String newDirName) {
        return copyFiles(oldDirName, newDirName);
    }

    */
/**
     * 删除目录
     *
     * @param dir
     * @return
     *//*

    private boolean deleteDirection(File dir) {
        if (dir == null || !dir.exists() || dir.isFile()) {
            return false;
        }
        for (int i = 0; i < dir.listFiles().length; i++) {
            if (dir.listFiles()[i].isFile()) {
                dir.listFiles()[i].delete();
            } else if (dir.listFiles()[i].isDirectory()) {
                deleteDirection(dir.listFiles()[i]);// 递归
            }
        }
        return dir.delete();
    }

    public boolean copyFile(File srcFile, File destFile) {
        try {
            if (srcFile.isDirectory() || destFile.isDirectory() || !srcFile.exists() || destFile.exists()) {
                return false;// 判断是否是文件
            }
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            int readLen = 0;
            byte[] buf = new byte[1024];
            while ((readLen = fis.read(buf)) != -1) {
                fos.write(buf, 0, readLen);
            }
            fos.flush();
            fos.close();
            fis.close();
        } catch (Exception e) {

        }
        return true;
    }

    public boolean copyFiles(String oldDirName, String newDirName) {
        File srcDir = new File(FILESPATH + oldDirName);
        File destDir = new File(FILESPATH + newDirName);
        if (!srcDir.isDirectory() || !destDir.isDirectory() || !srcDir.exists() || !destDir.exists()) {
            return false;// 判断是否是目录
        }
        File[] srcFiles = srcDir.listFiles();
        for (int i = 0; i < srcFiles.length; i++) {
            if (srcFiles[i].isFile()) {
                // 获得目标文件
                File destFile = new File(destDir.getPath() + "//" + srcFiles[i].getName());
                copyFile(srcFiles[i], destFile);
            } else if (srcFiles[i].isDirectory()) {
                File theDestDir = new File(destDir.getPath() + "//" + srcFiles[i].getName());
                copyFiles(srcFiles[i].getPath(), destDir.getPath() + "//" + srcFiles[i].getName());
            }
        }
        return true;
    }

    */
/**
     * 移动一个文件
     *
     * @param srcFile
     * @param destFile
     * @return
     * @throws IOException
     *//*

    public boolean moveFile(File srcFile, File destFile) {
        try {
            boolean is_copy = copyFile(srcFile, destFile);
            if (!is_copy) {
                return false;
            }
            return deleteFile(srcFile);
        } catch (Exception e) {
            LOG.debug("moveFile", e.getMessage());
            return false;
        }
    }

    */
/**
     * 移动目录下的所有文件到指定目录
     *
     * @param srcDir
     * @param destDir
     * @return
     * @throws IOException
     *//*

    public LogMessage moveFiles(File srcDir, File destDir) {
        LogMessage logMessage = new LogMessage();
        try {
            if (!srcDir.isDirectory()) {
                logMessage.setResults(false);
                logMessage.setMessage("目录：" + srcDir.getName() + "不是一个文件夹！");
            }
            if (!destDir.isDirectory()) {
                logMessage.setResults(false);
                logMessage.setMessage("目录：" + destDir.getName() + "不是一个文件夹！");
            }
            if (!srcDir.exists()) {
                logMessage.setResults(false);
                logMessage.setMessage("目录：" + srcDir.getName() + "不存在！");
            }
            if (!destDir.exists()) {
                logMessage.setResults(false);
                logMessage.setMessage("目录：" + destDir.getName() + "不存在！");
            }
            File[] srcDirFiles = srcDir.listFiles();
            for (int i = 0; i < srcDirFiles.length; i++) {
                if (srcDirFiles[i].isFile()) {
                    File oneDestFile = new File(destDir.getPath() + "//" + srcDirFiles[i].getName());
                    moveFile(srcDirFiles[i], oneDestFile);
                    if (!deleteFile(srcDirFiles[i]).isResults()) {
                        logMessage.setResults(false);
                        logMessage.setMessage("移动文件 [" + srcDirFiles[i].getName() + "] 失败！");
                    }
                } else if (srcDirFiles[i].isDirectory()) {
                    File oneDestFile = new File(destDir.getPath() + "//" + srcDirFiles[i].getName());
                    moveFiles(srcDirFiles[i], oneDestFile);
                    deleteDirection(srcDirFiles[i]);
                }
            }
            logMessage.setResults(true);
            logMessage.setMessage("移动文件成功！");
        } catch (Exception e) {
            LOG.debug("moveFiles", e.getMessage());
            logMessage.setResults(false);
            logMessage.setMessage("移动文件失败！" + e.getMessage());
        }
        return logMessage;
    }

    */
/**
     * 删除单个文件
     *
     * @param file
     * @return
     *//*

    public LogMessage deleteFile(File file) {
        LogMessage logMessage = new LogMessage();
        try {
            if (file.isDirectory() || file.isAbsolute()) {
                logMessage.setResults(false);
                logMessage.setMessage(file.getName() + " 是文件夹，不是文件！");
            }
            if (!file.exists()) {
                logMessage.setResults(false);
                logMessage.setMessage("文件：" + file.getName() + " 不存在！");
            } else {
                if (file.delete()) {
                    logMessage.setResults(false);
                    logMessage.setMessage("删除文件 [" + file.getName() + "] 成功！");
                } else {
                    logMessage.setResults(false);
                    logMessage.setMessage("删除文件 [" + file.getName() + "] 失败！");
                }
            }
            logMessage.setResults(true);
            logMessage.setMessage("移动文件成功！");
        } catch (Exception e) {
            LOG.debug("deleteFile", e.getMessage());
            logMessage.setResults(false);
            logMessage.setMessage("删除文件 [" + file.getName() + "] 失败！" + e.getMessage());
        }
        return logMessage;
    }
}
*/
