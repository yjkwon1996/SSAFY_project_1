package com.mycom.myapp.address.controller;

import java.util.List;

import com.mycom.myapp.address.dto.GugunDto;
import com.mycom.myapp.address.dto.SidoDto;
import com.mycom.myapp.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        // localhost:5500 과 127.0.0.1 구분
        origins = "http://localhost:8080", // allowCredentials = "true" 일 경우, orogins="*" 는 X
        allowCredentials = "true", 
        allowedHeaders = "*", 
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
    )
public class AddressController {

@Autowired
AddressService service;

@GetMapping(value="/sidos")
public ResponseEntity<List<SidoDto>> sidoList(){
    
    List<SidoDto> list = service.sidoList();
    return new ResponseEntity<List<SidoDto>>(list, HttpStatus.OK);
}

@GetMapping(value="/guguns/{sidoCode}")
public ResponseEntity<List<GugunDto>> guguns(@PathVariable String sidoCode){
    
    List<GugunDto> list = service.gugunList(sidoCode);
    return new ResponseEntity<List<GugunDto>>(list, HttpStatus.OK);
}
}