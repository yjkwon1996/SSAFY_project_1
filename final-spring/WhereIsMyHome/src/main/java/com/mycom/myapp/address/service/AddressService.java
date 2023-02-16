package com.mycom.myapp.address.service;

import java.util.List;

import com.mycom.myapp.address.dto.GugunDto;
import com.mycom.myapp.address.dto.SidoDto;

public interface AddressService {
    List<SidoDto> sidoList();
    List<GugunDto> gugunList(String sidoCode);
}