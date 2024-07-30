package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.repositories.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardDeleteService {
    private final BoardRepository boardRepository;

    public void delete(Long id) {
        boardRepository.deleteById(id); // id 값으로 게시글 삭제
    }
}