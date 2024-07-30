package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.repositories.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardSaveService {
    private final BoardRepository boardRepository;

    // 게시글 저장하기
    public Board save(Board board) {
        return boardRepository.save(board);
    }
}