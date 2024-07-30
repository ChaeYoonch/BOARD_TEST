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

    public List<Board> getBoard() {
        return boardRepository.findAll();
    }

    public Board getBoards(Long id) {
        return boardRepository.findById(id).orElse(null);
    }
}