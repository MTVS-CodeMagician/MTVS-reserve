package com.ohgiraffers.mtvsreserve.board.domain.service;


import com.ohgiraffers.mtvsreserve.board.domain.entity.Board;
import com.ohgiraffers.mtvsreserve.board.domain.repository.BoardRepository;
import com.ohgiraffers.mtvsreserve.board.domain.dto.BoardDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO.toEntity()).getId();
    }

    @Transactional
    public List<BoardDTO> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for (Board board : boardList) {
            BoardDTO boardDto = BoardDTO.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdDate(board.getCreatedDate())
                    .build();

            boardDTOList.add(boardDto);
        }
        return boardDTOList;
    }

    //5단계
//    @Transactional
//    public BoardDTO getPost(Long id) {
//        Optional<Board> boardWrapper = boardRepository.findById(id);
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
//    }

    @Transactional
    public BoardDTO getPost(Long id) {
        Board board = boardRepository.findById(id).get();

        BoardDTO boardDTO = BoardDTO.builder()
                .id(board.getId())
                .author(board.getAuthor())
                .title(board.getTitle())
                .content(board.getContent())
                .fileId(board.getFileId())
                .createdDate(board.getCreatedDate())
                .build();
        return boardDTO;
    }

    @Transactional
    public void deletePost(Long id){
        boardRepository.deleteById(id);
    }

}