package com.git.comm.utils.u4os;

import java.io.*;
import java.util.StringTokenizer;

public final class LinuxSystemTool {
    /**
     * @return int[] result
     * result.length==4;int[0]=MemTotal;int[1]=MemFree;int[2]=SwapTotal;int[3]=SwapFree;
     */
    public static int[] getMemInfo() throws IOException, InterruptedException {
        File file = new File("/proc/meminfo");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)));
        int[] result = new int[4];
        String str = null;
        StringTokenizer token = null;
        while((str = br.readLine()) != null) {
            token = new StringTokenizer(str);
            if(!token.hasMoreTokens())
                continue;

            str = token.nextToken();
            if(!token.hasMoreTokens())
                continue;

            if(str.equalsIgnoreCase("MemTotal:"))
                result[0] = Integer.parseInt(token.nextToken());
            else if(str.equalsIgnoreCase("MemFree:"))
                result[1] = Integer.parseInt(token.nextToken());
            else if(str.equalsIgnoreCase("SwapTotal:"))
                result[2] = Integer.parseInt(token.nextToken());
            else if(str.equalsIgnoreCase("SwapFree:"))
                result[3] = Integer.parseInt(token.nextToken());
        }
        return result;
    }

    public static float getCpuInfo() throws IOException, InterruptedException {
        File file = new File("/proc/stat");
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)));
        StringTokenizer token = new StringTokenizer(br.readLine());
        token.nextToken();
        int user1 = Integer.parseInt(token.nextToken());
        int nice1 = Integer.parseInt(token.nextToken());
        int sys1 = Integer.parseInt(token.nextToken());
        int idle1 = Integer.parseInt(token.nextToken());

        Thread.sleep(1000);

        br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file)));
        token = new StringTokenizer(br.readLine());
        token.nextToken();
        int user2 = Integer.parseInt(token.nextToken());
        int nice2 = Integer.parseInt(token.nextToken());
        int sys2 = Integer.parseInt(token.nextToken());
        int idle2 = Integer.parseInt(token.nextToken());

        return (float)((user2 + sys2 + nice2) - (user1 + sys1 + nice1)) / (float)((user2 + nice2 + sys2 + idle2) - (user1 + nice1 + sys1 + idle1));
    }
}


