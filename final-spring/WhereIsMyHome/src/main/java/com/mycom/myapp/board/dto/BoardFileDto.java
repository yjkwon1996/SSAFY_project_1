package com.mycom.myapp.board.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardFileDto {
    private Long fileId;
    private Long boardId;
    private String fileName;
    private long fileSize;
    private String fileContentType;
    private String fileUrl;
    private LocalDateTime regDt;
}