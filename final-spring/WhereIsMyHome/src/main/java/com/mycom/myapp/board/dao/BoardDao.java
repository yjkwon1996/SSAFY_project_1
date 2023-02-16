package com.mycom.myapp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardFileDto;
import com.mycom.myapp.board.dto.BoardParamDto;

@Mapper
public interface BoardDao {

    BoardDto boardDetail(BoardParamDto boardParamDto);
    List<BoardFileDto> boardDetailFileList(Long boardId);

    // map - Dto
    int boardUserReadCount(BoardParamDto boardParamDto);

    // map - @param
    int boardUserReadInsert(
            @Param("boardId") Long boardId,
            @Param("userSeq") Long userSeq );

    int boardReadCountUpdate(Long boardId);


    int boardDelete(Long boardId);
    int boardFileDelete(Long boardId);
    List<String> boardFileUrlDeleteList(Long boardId);
    int boardReadCountDelete(Long boardId);

    int boardInsert(BoardDto dto);
    int boardFileInsert(BoardFileDto dto);

    List<BoardDto> boardList(BoardParamDto boardParamDto);
    int boardListTotalCount();

    List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
    int boardListSearchWordTotalCount(BoardParamDto boardParamDto);


    int boardUpdate(BoardDto dto);

}
