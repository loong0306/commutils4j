package com.git.comm.utils.u4enum;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by dragon on 12/6/2017.
 */
public enum BusinessEnum {

    FIRST("FIRST", "1"),
    SECOND("SECOND", "2"),
    THIRD("THIRD", "3");

    BusinessEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static List<BusinessEnum> getList() {
        return Arrays.asList(BusinessEnum.values());
    }

    public static String getBusinessTypeDescByCode(String code) {
        for (BusinessEnum typeEnum : getList()) {
            if(StringUtils.equals(typeEnum.getCode(), code)){
                return typeEnum.getDesc();
            }
        }
        return code;
    }

    public static List<Map<String, Object>> getMap2List() {
        List<Map<String, Object>> list = Lists.newArrayList();
        for (BusinessEnum ele : BusinessEnum.values()) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("desc", ele.getDesc());
            map.put("code", ele.getCode());
            list.add(map);
        }
        return list;
    }
}
