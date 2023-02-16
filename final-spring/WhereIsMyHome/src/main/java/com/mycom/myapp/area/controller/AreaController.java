package com.mycom.myapp.area.controller;

import com.mycom.myapp.area.dto.AreaDto;
import com.mycom.myapp.area.service.AreaService;
import com.mycom.myapp.board.dto.BoardResultDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(
        // localhost:5500 과 127.0.0.1 구분
        origins = "http://localhost:8080", // allowCredentials = "true" 일 경우, orogins="*" 는 X
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
public class AreaController {

    private final AreaService areaService;

    @GetMapping("/api/gugun/{code}")
    public getGugunNameResponse getGugunName(@PathVariable("code") int code) {
        String ret = areaService.getGugunName(code);
        return new getGugunNameResponse(ret);
    }

    @GetMapping("/api/address/{userId}")
    public List<GetAreaResponse> getAreas(@PathVariable("userId") Long userId) {
        List<AreaDto> dto = areaService.getAreas(userId);
        List<GetAreaResponse> ret = new ArrayList<>();

        for(AreaDto areaDto : dto) {
            ret.add(new GetAreaResponse(areaDto.getAreaNumber()));
        }

        return ret;
    }

    @PostMapping("/api/addaddress")
    public InsertAreaResponse saveArea(@RequestBody AreaDto areaDto) {
        int areaNumber = areaService.insertArea(areaDto);
        return new InsertAreaResponse(areaNumber);
    }

    @Data
    @AllArgsConstructor
    public static class getGugunNameResponse {
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class InsertAreaResponse {
        private int areaNumber;
    }

    @Data
    @AllArgsConstructor
    public static class GetAreaResponse {
        private String areaNumber;
    }
}
