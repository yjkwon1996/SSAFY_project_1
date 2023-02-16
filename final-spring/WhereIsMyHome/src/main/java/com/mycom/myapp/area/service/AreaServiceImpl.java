package com.mycom.myapp.area.service;

import com.mycom.myapp.area.dao.AreaDao;
import com.mycom.myapp.area.dto.AreaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final AreaDao dao;

    @Override
    public int insertArea(AreaDto areaDto) {
        return dao.areaInsert(areaDto);
    }

    @Override
    public List<AreaDto> getAreas(Long userId) {
        return dao.getAreas(userId);
    }

    @Override
    public String getGugunName(int code) {
        return dao.getGugunName(code);
    }
}
