package com.mycom.myapp.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myapp.board.dao.BoardDao;
import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardFileDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDao dao;

    @Value("${app.fileupload.uploadPath}")
    String uploadFolder;

    @Value("${app.fileupload.uploadPath}")
    String uploadPath;

    /* 업로드 후 upload 폴더 refresh 하거나 preferences / workspace - refresh... 2개 option check */
    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @Override
    @Transactional
    public BoardResultDto boardInsert(BoardDto dto, MultipartHttpServletRequest request) {

        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            dao.boardInsert(dto); // useGeneratedKeys="true" keyProperty="boardId"

            // for transaction test
//			String s = null;
//			s.length();

            List<MultipartFile> fileList = request.getFiles("file");

            File uploadDir = new File(uploadPath + File.separator + uploadFolder);
            if (!uploadDir.exists()) uploadDir.mkdir();

            for (MultipartFile part : fileList) {

                Long boardId = dto.getBoardId();

                String fileName = part.getOriginalFilename();

                //Random File Id
                UUID uuid = UUID.randomUUID();

                //file extension
                String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()

                String savingFileName = uuid + "." + extension;

                File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);

                System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
                part.transferTo(destFile);

                // Table Insert
                BoardFileDto boardFileDto = new BoardFileDto();
                boardFileDto.setBoardId(boardId);
                boardFileDto.setFileName(fileName);
                boardFileDto.setFileSize(part.getSize());
                boardFileDto.setFileContentType(part.getContentType());
                String boardFileUrl = uploadFolder + "/" + savingFileName;
                boardFileDto.setFileUrl(boardFileUrl);

                dao.boardFileInsert(boardFileDto);
            }

            boardResultDto.setResult(SUCCESS);

        }catch(IOException e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }
        return boardResultDto;
    }

    @Override
    @Transactional
    public BoardResultDto boardUpdate(BoardDto dto, MultipartHttpServletRequest request){

        BoardResultDto boardResultDto = new BoardResultDto();


        try {
            dao.boardUpdate(dto);

            List<MultipartFile> fileList = request.getFiles("file");

            File uploadDir = new File(uploadPath + File.separator + uploadFolder);
            if (!uploadDir.exists()) uploadDir.mkdir();

            List<String> fileUrlList = dao.boardFileUrlDeleteList(dto.getBoardId());
            for(String fileUrl : fileUrlList) {
                File file = new File(uploadPath + File.separator, fileUrl);
                if(file.exists()) {
                    file.delete();
                }
            }

            dao.boardFileDelete(dto.getBoardId());


            for (MultipartFile part : fileList) {
                Long boardId = dto.getBoardId();

                String fileName = part.getOriginalFilename();

                //Random File Id
                UUID uuid = UUID.randomUUID();

                //file extension
                String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()

                String savingFileName = uuid + "." + extension;

                File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);

                System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
                part.transferTo(destFile);

                // Table Insert
                BoardFileDto boardFileDto = new BoardFileDto();
                boardFileDto.setBoardId(boardId);
                boardFileDto.setFileName(fileName);
                boardFileDto.setFileSize(part.getSize());
                boardFileDto.setFileContentType(part.getContentType());
                String boardFileUrl = uploadFolder + "/" + savingFileName;
                boardFileDto.setFileUrl(boardFileUrl);

                dao.boardFileInsert(boardFileDto);
            }

            boardResultDto.setResult(SUCCESS);

        }catch(IOException e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }

        return boardResultDto;
    }

    @Override
    @Transactional
    public BoardResultDto boardDelete(Long boardId) {

        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            List<String> fileUrlList = dao.boardFileUrlDeleteList(boardId);
            for(String fileUrl : fileUrlList) {
                File file = new File(uploadPath + File.separator, fileUrl);
                if(file.exists()) {
                    file.delete();
                }
            }

            dao.boardFileDelete(boardId);
            dao.boardReadCountDelete(boardId);
            dao.boardDelete(boardId);
            boardResultDto.setResult(SUCCESS);

        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }

        return boardResultDto;
    }

    @Override
    @Transactional
    public BoardResultDto boardDetail(BoardParamDto boardParamDto) {

        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            int userReadCnt = dao.boardUserReadCount(boardParamDto);
            if( userReadCnt == 0 ) {
                dao.boardUserReadInsert(boardParamDto.getBoardId(), boardParamDto.getUserSeq());
                dao.boardReadCountUpdate(boardParamDto.getBoardId());
            }

            BoardDto dto = dao.boardDetail(boardParamDto);
            List<BoardFileDto> fileList = dao.boardDetailFileList(dto.getBoardId());

            dto.setFileList(fileList);
            boardResultDto.setDto(dto);

            boardResultDto.setResult(SUCCESS);

        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto boardList(BoardParamDto boardParamDto) {

        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            List<BoardDto> list = dao.boardList(boardParamDto);
            int count = dao.boardListTotalCount();
            boardResultDto.setList(list);
            boardResultDto.setCount(count);
            boardResultDto.setResult(SUCCESS);

        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {

        BoardResultDto boardResultDto = new BoardResultDto();

        try {
            List<BoardDto> list = dao.boardListSearchWord(boardParamDto);
            int count = dao.boardListSearchWordTotalCount(boardParamDto);

            boardResultDto.setList(list);
            boardResultDto.setCount(count);

            boardResultDto.setResult(SUCCESS);

        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }

        return boardResultDto;
    }
}