package com.capital.operation;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.webkit.WebView;
import com.uzmap.pkg.uzcore.UZWebView;
import com.uzmap.pkg.uzcore.annotation.UzJavascriptMethod;
import com.uzmap.pkg.uzcore.uzmodule.UZModule;
import com.uzmap.pkg.uzcore.uzmodule.UZModuleContext;
import org.json.JSONObject;

import java.io.*;

/**
 * <P style='margin: 0px; padding: 0px;'><b>PackageName:</b> com.capital.operation.</P>
 * <P style='margin: 0px; padding: 0px;'><b>ProjectName:</b> CapitalOperation.</P>
 * <P style='margin: 0px; padding: 0px;'><b>User:</b> 李志超.</P>
 * <P style='margin: 0px; padding: 0px;'><b>Date:</b> 2017-3-16 0016.</P>
 * <P style='margin: 0px; padding: 0px;'><b>Time:</b> 18:31:34</P>
 */
public class ApicloudFileUtil extends UZModule {

    public ApicloudFileUtil(UZWebView webView) {
        super(webView);
    }

    @UzJavascriptMethod
    public void jsmethod_copyFileToData(UZModuleContext context) {
        String oldDirName = context.optString("oldDirName");
        String newDirName = context.optString("newDirName");
        try {
            InputStream in = this.getContext().getResources().getAssets().open(oldDirName);
            OutputStream os = new FileOutputStream(new File(mContext.getFilesDir().getPath() + "/" + newDirName));
            //文件拷贝
            byte flush[] = new byte[1024];
            int len = 0;
            while (0 <= (len = in.read(flush))) {
                os.write(flush, 0, len);
            }
            //关闭流的注意 先打开的后关
            os.close();
            in.close();
            JSONObject map = new JSONObject();
            map.put("results", true);
            map.put("message", "拷贝文件成功！");
            context.success(map, true);
        } catch (Exception e) {
            context.success("拷贝文件失败！" + e.getMessage(), false, true);
        }
    }

    @UzJavascriptMethod
    public void jsmethod_copyDataToFile(UZModuleContext context) {
        String oldDirName = context.optString("oldDirName");
        String newDirName = context.optString("newDirName");
        try {
            InputStream in = new FileInputStream(new File(mContext.getFilesDir().getPath() + "/" + oldDirName));
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/CapitalOperation/");
            if (!file.exists()) {
                file.mkdirs();
            }
            OutputStream os = new FileOutputStream(file.getPath() + "/" + newDirName);
            //文件拷贝
            byte flush[] = new byte[1024];
            int len = 0;
            while (0 <= (len = in.read(flush))) {
                os.write(flush, 0, len);
            }
            //关闭流的注意 先打开的后关
            os.close();
            in.close();
            JSONObject map = new JSONObject();
            map.put("results", true);
            map.put("message", "拷贝文件成功！");
            context.success(map, true);
        } catch (Exception e) {
            context.success("{results:false,message:'拷贝文件失败！'}" + e.getMessage(), false, true);
        }
    }
    @UzJavascriptMethod
    public void jsmethod_openDebug(UZModuleContext context)
    {
        try
        {
            JSONObject localJSONObject = new JSONObject();
            if (Build.VERSION.SDK_INT >= 19)
            {
                WebView.setWebContentsDebuggingEnabled(true);
                localJSONObject.put("result", "success");
                localJSONObject.put("code", 1000);
            }
        }
        catch (Exception e)
        {
            context.success("{results:false,message:'谷歌调试失败！'}" + e.getMessage(), false, true);
        }
    }
    /*@UzJavascriptMethod
    public void jsmethod_getSDCardPath(UZModuleContext context) {
        context.success(fileHelp.getSDCardPath(), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_getSDCardTotal(UZModuleContext context) {
        context.success("" + fileHelp.getSDCardTotal(), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_getSDCardFree(UZModuleContext context) {
        context.success("" + fileHelp.getSDCardFree(), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_createSDDirection(UZModuleContext context) {
        String dirName = context.optString("dirName");
        if (null == dirName || "".equals(dirName)) {
            context.success("0", false, true);
        }
        context.success(fileHelp.createSDDirection(dirName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_deleteSDDirection(UZModuleContext context) {
        String dirName = context.optString("dirName");
        context.success("" + fileHelp.deleteSDDirection(dirName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_deleteSDFile(UZModuleContext context) {
        String fileName = context.optString("fileName");
        context.success("" + fileHelp.deleteSDFile(fileName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_renameSDFile(UZModuleContext context) {
        String oldName = context.optString("oldName");
        String newName = context.optString("newName");
        context.success("" + fileHelp.renameSDFile(oldName, newName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_copySDFileTo(UZModuleContext context) {
        String oldFileName = context.optString("oldFileName");
        String newFileName = context.optString("newFileName");
        context.success("" + fileHelp.copySDFile(oldFileName, newFileName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_copySDFiles(UZModuleContext context) {
        String oldDirName = context.optString("oldDirName");
        String newDirName = context.optString("newDirName");
        context.success("" + fileHelp.copySDFiles(oldDirName, newDirName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_moveSDFileTo(UZModuleContext context) {
        String oldFileName = context.optString("oldFileName");
        String newFileName = context.optString("newFileName");
        context.success("" + fileHelp.moveSDFile(oldFileName, newFileName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_moveSDFiles(UZModuleContext context) {
        String oldDirName = context.optString("oldDirName");
        String newDirName = context.optString("newDirName");
        context.success("" + fileHelp.moveSDFiles(oldDirName, newDirName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_deleteDataFile(UZModuleContext context) {
        String fileName = context.optString("fileName");
        context.success("" + fileHelp.deleteDataFile(fileName), false, true);
    }

    @UzJavascriptMethod
    public void jsmethod_copyDataFiles(UZModuleContext context) {
        String oldDirName = context.optString("oldDirName");
        String newDirName = context.optString("newDirName");
        context.success("" + fileHelp.copyDataFiles(oldDirName, newDirName), false, true);
    }*/
}
