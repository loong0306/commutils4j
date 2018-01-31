package com.git.comm.utils.u4file;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by dragon on 1/31/2018.
 */
public class StreamUtils {
    /**
     * 将InputStream转换成byte[]
     *
     * @param inputStream inputStream
     * @return byte[]
     * @throws IOException
     */
    public static byte[] convertInputStream2ByteArray(InputStream inputStream) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len;

        while ((len = inputStream.read(buffer)) > -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }

        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 将OutPutStream转换成inputStream
     * @param outputStream outputStream
     * @return ByteArrayInputStream
     */
    public static ByteArrayInputStream convertOutputStream2InputStream(OutputStream outputStream) {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) outputStream;
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
}
