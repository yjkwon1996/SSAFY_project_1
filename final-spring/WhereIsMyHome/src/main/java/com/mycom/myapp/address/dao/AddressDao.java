package com.mycom.myapp.address.dao;

import java.util.List;

import com.mycom.myapp.address.dto.GugunDto;
import com.mycom.myapp.address.dto.SidoDto;
import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.address.dto.GugunDto;
import com.mycom.myapp.address.dto.SidoDto;

@Mapper
public interface AddressDao {
    List<SidoDto> sidoList();
    List<GugunDto> gugunList(String sidoCode);
}