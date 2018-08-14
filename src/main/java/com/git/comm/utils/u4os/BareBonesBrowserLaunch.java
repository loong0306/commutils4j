package com.git.comm.utils.u4os;

import javax.swing.*;
import java.lang.reflect.Method;

/**
 * <p>Title: BareBonesBrowserLaunch. </p>
 * <p>Description 根据系统打开浏览器 </p>
 * @author net ( thanks to Internet & author)
 * @date 2018/8/14 下午11:06
 */
public class BareBonesBrowserLaunch {
    public static void openURL(String url) {
        try {
            browse(url);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error attempting to launch web browser:\n" + e.getLocalizedMessage());
        }
    }

    private static void browse(String url) throws Exception {
        String osName = System.getProperty("os.name", "");
        if (osName.startsWith("Mac OS")) {
            Class fileMgr = Class.forName("com.apple.eio.FileManager");
            Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] { String.class });
            openURL.invoke(null, new Object[] { url });
        } else if (osName.startsWith("Windows")) {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } else {
            // assume Unix or Linux
            String[] browsers = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
            String browser = null;
            for (int count = 0; count < browsers.length && browser == null; count++) {
                if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0) {
                    browser = browsers[count];
                }
                if (browser == null) {
                    throw new NoSuchMethodException("Could not find web browser");
                } else {
                    Runtime.getRuntime().exec(new String[] { browser, url });
                }
            }
        }
    }
}
