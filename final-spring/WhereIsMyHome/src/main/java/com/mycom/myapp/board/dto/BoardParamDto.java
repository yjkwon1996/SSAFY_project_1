package com.mycom.myapp.board.dto;

import lombok.*;

// for boardList, boardDetail
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardParamDto {

    private int limit;
    private int offset;
    private String searchWord;

    private Long boardId;
    private Long userSeq;
}
