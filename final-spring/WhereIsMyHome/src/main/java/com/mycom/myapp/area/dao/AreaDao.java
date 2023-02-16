package com.mycom.myapp.area.dao;

import com.mycom.myapp.area.dto.AreaDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDao {
    int areaInsert(AreaDto dto);
    List<AreaDto> getAreas(Long userId);

    String getGugunName(int code);
}
