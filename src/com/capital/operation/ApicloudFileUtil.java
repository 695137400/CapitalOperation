package com.capital.operation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.uzmap.pkg.uzcore.UZWebView;
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

    /**
     * 写入db到私有目录
     *
     * @param context
     */
    public void jsmethod_copyFileToData(UZModuleContext context) {
        String oldDirName = context.optString("oldDirName");
        String newDirName = context.optString("newDirName");
        try {
            InputStream in = this.getContext().getResources().getAssets().open(oldDirName);
            String path = "/data/data/com.capital.operation/databases/";
            if (!new File(path).exists()) {
                new File(path).mkdirs();
            }
            if (!new File(path + newDirName).exists()) {
                new File(path + newDirName).createNewFile();
            }else{
                System.out.println("文件已存在");
                return;
            }
            OutputStream os = new FileOutputStream(new File(path + newDirName));
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
            context.success("{results:false,message:'拷贝文件失败！" + e.getMessage() + "'}", false, true);
        }
    }

    /**
     * 拷贝db到内存卡
     *
     * @param context
     */
    public void jsmethod_copyDataToFile(UZModuleContext context) {
        String oldDirName = context.optString("oldDirName");
        String newDirName = context.optString("newDirName");
        try {
            String path = "/data/data/com.capital.operation/databases/" + oldDirName;
            InputStream in = new FileInputStream(new File(path));
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/数据备份/");
            if (!file.exists()) {
                file.mkdirs();
            }
            new File(file.getPath() + "/此文件夹下是数据备份文件，请妥善保存！").createNewFile();
            if (!new File(file.getPath() + "/" + newDirName).exists()) {
                new File(file.getPath() + "/" + newDirName+".db").createNewFile();
            }
            OutputStream os = new FileOutputStream(new File(file.getPath() + "/" + newDirName+".db"));
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
            context.success("{results:false,message:'拷贝文件失败！" + e.getMessage() + "'}", false, true);
        }
    }

    public void jsmethod_log(UZModuleContext context) {
        String TAG = context.optString("tag");
        String message = context.optString("message");
        LOG.debug(TAG, message);
    }
    static  AlertDialog al = null;
    public void jsmethod_Toast(UZModuleContext context) {
        String type = context.optString("type");
        String isHide = context.optString("isHide");
        ImageView iv = new ImageView(context.getContext());
        if ("success".equals(type)) {
            iv.setImageResource(R.drawable.success);
            System.out.println("success");
        }
        if ("fail".equals(type)) {
            iv.setImageResource(R.drawable.fail);
            System.out.println("fail");
        }
        if ("loading".equals(type)) {
            iv.setImageResource(R.drawable.loading);
            System.out.println("loading");
        }
       // iv.setBackgroundColor(Color.parseColor("#000000"));
        //iv.getBackground().setAlpha(255);
        if (null == al) {
            al = new AlertDialog.Builder(context.getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK).setCancelable(false).create();
        }else{
            al.dismiss();
            al.hide();
            al = new AlertDialog.Builder(context.getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK).setCancelable(false).create();
        }
        LinearLayout ll = new LinearLayout(context.getContext());
        ll.setOrientation(1);
       // ll.setBackgroundColor(Color.parseColor("#ffffff"));
        //ll.getBackground().setAlpha(255);
        ll.setGravity(Gravity.CENTER);
        ll.addView(iv);
        al.setView(ll, 0, 0, 0, 0);
        if ("true".equals(isHide)) {
            System.out.println("关闭");
            al.dismiss();
            al.hide();
        }else{
            al.show();
        }
        Window window = al.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        //lp.alpha = 0f;
        lp.width = 400;
        lp.height = 400;
        window.setAttributes(lp);
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
