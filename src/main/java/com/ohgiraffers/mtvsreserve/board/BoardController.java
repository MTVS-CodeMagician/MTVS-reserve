package com.ohgiraffers.mtvsreserve.board;

import com.ohgiraffers.mtvsreserve.board.domain.dto.BoardDTO;
import com.ohgiraffers.mtvsreserve.board.domain.dto.FileDTO;
import com.ohgiraffers.mtvsreserve.board.domain.service.BoardService;
import com.ohgiraffers.mtvsreserve.board.domain.service.FileService;
import com.ohgiraffers.mtvsreserve.board.domain.util.MD5Generator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;
    private FileService fileService;

    public BoardController(BoardService boardService, FileService fileService) {
        this.boardService = boardService;
        this.fileService = fileService;
    }

    @GetMapping("/board")
    public String list(Model model) {
        List<BoardDTO> boardDTOList = boardService.getBoardList();
        model.addAttribute("postList", boardDTOList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "board/post.html";
    }

    @PostMapping("/post")
    public String write(@RequestParam("file") MultipartFile files, BoardDTO boardDTO) {
        try {
            String origFilename = files.getOriginalFilename();
            String filename = new MD5Generator(origFilename).toString();
            /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
            String savePath = System.getProperty("user.dir") + "\\files";
            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
            if (!new File(savePath).exists()) {
                try {
                    new File(savePath).mkdir();
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
            String filePath = savePath + "\\" + filename;
            files.transferTo(new File(filePath));

            FileDTO fileDTO = new FileDTO();
            fileDTO.setOrigFilename(origFilename);
            fileDTO.setFilename(filename);
            fileDTO.setFilePath(filePath);

            Long fileId = fileService.saveFile(fileDTO);
            boardDTO.setFileId(fileId);
            boardService.savePost(boardDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/board";
    }


    // 여기서부터 5단계
    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.getPost(id);

        model.addAttribute("boardDTO", boardDTO);

        return "board/detail.html";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.getPost(id);
        model.addAttribute("boardDTO", boardDTO);
        return "board/edit.html";
    }

    @PutMapping("/post/edit/{id}")
    public String update(BoardDTO boardDTO) {
        boardService.savePost(boardDTO);
        return "redirect:/board";
    }

    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.deletePost(id);
        return "redirect:/board";
    }

}


//    public BoardDTO getPost(Long id){
//        Optional<Board> boardWrapper = boardrepository.findById(id);
//        Board board = boardWrapper.get();
//
//        BoardDTO boardDTO = BoardDTO.builder()
//                .id(board.getId())
//                .author(board.getAuthor())
//                .title(board.getTitle())
//                .content(board.getContent())
//                .createdDate(board.getCreatedDate())
//                .build();
//
//        return boardDTO;