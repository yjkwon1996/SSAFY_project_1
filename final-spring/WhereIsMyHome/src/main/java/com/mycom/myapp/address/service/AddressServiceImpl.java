package com.mycom.myapp.address.service;

import java.util.List;

import com.mycom.myapp.address.dao.AddressDao;
import com.mycom.myapp.address.dto.GugunDto;
import com.mycom.myapp.address.dto.SidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao dao;

    @Override
    public List<SidoDto> sidoList() {
        return dao.sidoList();
    }

    @Override
    public List<GugunDto> gugunList(String sidoCode) {
        return dao.gugunList(sidoCode);
    }
}
