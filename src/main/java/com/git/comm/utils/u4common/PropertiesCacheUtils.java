package com.git.comm.utils.u4common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 所有properties配置缓存
 */
public class PropertiesCacheUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesCacheUtils.class);
    private static Map<String,String> propertiesAttrMap = new ConcurrentHashMap();

    //缓存properties文件
    private static Map<String, Properties> propertiesCache = new ConcurrentHashMap();

    public static String getValue(String key){
        String value =  propertiesAttrMap.get(key);
        if(value == null){
            try {
                throw new Exception("没有配置" + key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public static Integer getInteger(String key){
        return Integer.valueOf(getValue(key));

    }

    public static Long getLong(String key){
        return Long.valueOf(getValue(key));

    }

    public static Boolean getBoolean(String key){
        return Boolean.valueOf(getValue(key));

    }

    public static Double getDouble(String key){
        return Double.valueOf(getValue(key));

    }

    public static Map<String,String> getPropertiesMap(){
        return propertiesAttrMap;
    }


    public static Map<String, Properties> getProperties() {
        return propertiesCache;
    }


    /**
     * 获取properties
     * @param propertiesName
     * @return
     */
    public static Properties getProperties(String propertiesName){
        InputStream inputStream;
        Properties properties =propertiesCache.get(propertiesName);
        if(properties == null){
            inputStream = PropertiesCacheUtils.class.getResourceAsStream("/" + propertiesName);
            properties = new Properties();
            try {
                properties.load(inputStream);
                inputStream.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage(),e);
                //某些情况下释放资源;比如LOAD报错
                inputStream = null;
            }
            if(properties != null){
                propertiesCache.put(propertiesName, properties);
                prorsToMap(properties);
            }
        }
        return properties;
    }

    public static void prorsToMap(Properties properties){
        for(Object key:properties.keySet()){
            String strKey = key.toString();
            String value = properties.getProperty(strKey);
            propertiesAttrMap.put(strKey, value);
        }
    }
}
