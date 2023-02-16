package com.mycom.myapp.board.dto;

import java.util.List;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardResultDto {
    private int result;
    private BoardDto dto;
    private List<BoardDto> list;
    private int count;

}
