package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.repositories.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardListService {
    private final BoardRepository boardRepository;

    // 전체 게시글 목록 가져오기
    public List<Board> getBoard() {
        return boardRepository.findAll();
    }

    // 게시글 1개 가져오기
    public Board getBoards(Long id) {
        return boardRepository.findById(id).orElse(null);
    }
}