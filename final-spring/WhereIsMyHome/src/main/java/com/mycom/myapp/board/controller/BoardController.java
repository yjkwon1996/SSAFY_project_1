package com.mycom.myapp.board.controller;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;
import com.mycom.myapp.board.service.BoardService;
import com.mycom.myapp.user.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@CrossOrigin(
        // localhost:5500 과 127.0.0.1 구분
        origins = "http://localhost:8080", // allowCredentials = "true" 일 경우, orogins="*" 는 X
        allowCredentials = "true",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
public class BoardController {
    private final BoardService service;

    private static final int SUCCESS = 1;

    @GetMapping(value="/boards")
    public ResponseEntity<BoardResultDto> boardList(BoardParamDto boardParamDto){

        BoardResultDto boardResultDto;


        if( boardParamDto.getSearchWord().isEmpty() ) {
            boardResultDto = service.boardList(boardParamDto);
        }else {
            boardResultDto = service.boardListSearchWord(boardParamDto);
        }

        if( boardResultDto.getResult() == SUCCESS ) {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value="/boards/{boardId}")
    public ResponseEntity<BoardResultDto> boardDetail(@PathVariable Long boardId, HttpSession session){

        BoardParamDto boardParamDto = new BoardParamDto();
        boardParamDto.setUserSeq( ((User) session.getAttribute("userDto")).getId());
        boardParamDto.setBoardId(boardId);

        BoardResultDto boardResultDto = service.boardDetail(boardParamDto);
        // 게시글 작성자와 현 사용자가 동일
        if( ((User) session.getAttribute("userDto")).getId() == boardResultDto.getDto().getUserSeq() ) {
            boardResultDto.getDto().setSameUser(true);
        }

        if( boardResultDto.getResult() == SUCCESS ) {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/boards")
    public ResponseEntity<BoardResultDto> boardInsert(
            BoardDto boardDto,
            MultipartHttpServletRequest request) {

        boardDto.setUserSeq( ((User) request.getSession().getAttribute("userDto")).getId());
        BoardResultDto boardResultDto = service.boardInsert(boardDto, request);

        if( boardResultDto.getResult() == SUCCESS ) {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT + multipart/form-data (X)
    // In RESTful,
    // PUT & DELETE methods are defined to be idempotent

    @PostMapping(value="/boards/{boardId}")
    public ResponseEntity<BoardResultDto> boardUpdate(
            BoardDto boardDto,
            MultipartHttpServletRequest request){

        BoardResultDto boardResultDto = service.boardUpdate(boardDto, request);
        boardDto.setUserSeq( ((User) request.getSession().getAttribute("userDto")).getId());

        if( boardResultDto.getResult() == SUCCESS ) {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/boards/{boardId}")
    public ResponseEntity<BoardResultDto> boardDelete(@PathVariable(value="boardId") Long boardId){
        BoardResultDto boardResultDto = service.boardDelete(boardId);

        if( boardResultDto.getResult() == SUCCESS ) {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
