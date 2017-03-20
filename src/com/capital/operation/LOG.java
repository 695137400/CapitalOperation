package com.capital.operation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2016/11/25.
 */
public class LOG {
    static File file = new File("/sdcard/CapitalOperation/log.txt");

    public static void debug(String methodName, String info) {
        try {
            if (!file.exists()) {
                file = new File(methodName+".log");
                file.createNewFile();
            }
            Writer w = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");
            Date date = new Date();
            SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            w.write("\n");
            w.write(time.format(date));
            w.write("\n执行方法：");
            w.write(methodName);
            w.write("\n");
            w.write(info);
            w.flush();
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
