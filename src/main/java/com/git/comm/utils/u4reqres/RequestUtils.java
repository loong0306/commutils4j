package com.git.comm.utils.u4reqres;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取请求参数
 */
public class RequestUtils {
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获得用户远程地址
     */
    public static String getRemoteAddr(HttpServletRequest request){
        String remoteAddr = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }else if (StringUtils.isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }else if (StringUtils.isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        if(StringUtils.isEmpty(remoteAddr)){
            remoteAddr = request.getRemoteAddr();
            if(StringUtils.isNotEmpty(remoteAddr) && "0:0:0:0:0:0:0:1".equals(remoteAddr)){
                remoteAddr = "127.0.0.1";
            }else {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }
}
