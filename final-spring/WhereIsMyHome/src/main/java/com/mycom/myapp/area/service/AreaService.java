package com.mycom.myapp.area.service;

import com.mycom.myapp.area.dto.AreaDto;

import java.util.List;

public interface AreaService {
    int insertArea(AreaDto areaDto);
    List<AreaDto> getAreas(Long userId);

    String getGugunName(int code);
}
