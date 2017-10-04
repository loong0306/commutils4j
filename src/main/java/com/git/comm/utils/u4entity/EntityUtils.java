package com.git.comm.utils.u4entity;

import org.modelmapper.ModelMapper;

public class EntityUtils {

    /**
     * 将dto映射为实体类
     * @param dto
     * @param entity
     * @return
     */
    public static Object dtoToEntity(Object dto, Object entity){
        Object obj = new Object();
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, entity.getClass());
    }
}
