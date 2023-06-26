package com.ohgiraffers.mtvsreserve.board;

import com.ohgiraffers.mtvsreserve.board.domain.dto.BoardDTO;
import com.ohgiraffers.mtvsreserve.board.domain.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
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
    public String write(BoardDTO boardDTO) {
        boardService.savePost(boardDTO);
        return "redirect:/board";
    }

    // 여기서부터 5단계
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model) {
        BoardDTO boardDTO = boardService.getPost(id);

        model.addAttribute("boardDTO", boardDTO);

        return "board/detail.html";
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